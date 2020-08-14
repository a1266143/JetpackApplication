package com.stork.jetpackapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MonitorView extends View {

    private Paint mPaint;
    private final int SIZE_QUEUE = 25;
//    private Queue<Integer> mQueue = new PriorityQueue<>(SIZE_QUEUE);
    private List<Integer> mQueue = new ArrayList<>();
    private List<PointF> mPointsLocations = new ArrayList<>();

    private Path mPath = new Path();


    public MonitorView(Context context) {
        this(context,null);
    }

    public MonitorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MonitorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initData();
    }

    private Object lock = new Object();

    private void init(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.YELLOW);
    }

    private void initData(){
        for (int i = 0; i < SIZE_QUEUE; i++) {
            mQueue.add(-20);
            mPointsLocations.add(new PointF());
        }
    }

    private int mWidth,mHeight;
    //需要记录一个最大数，当最大数的值更改了，需要重新计算频谱的像素
    private int mMaxValue = 1;

    private int mLastValue;

    /**
     * 外部通过调用此方法来驱动频谱图
     * @param value
     */
    public synchronized void addData(int value){
        synchronized (lock){
            Log.e("xiaojun","add data = "+value);
            if (value > mLastValue){
                mLastValue = value;
            }
            if (value>mMaxValue)
                mMaxValue = value;
            mQueue.remove(0);
            mQueue.add(value);
            Log.e("xioajun","mqueue.size = "+mQueue.size()+",mqueue.lastvalue = "+mQueue.get(mQueue.size()-1)+",value = "+value);
            postInvalidate();
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSpectrum(canvas);
        drawRectangle(canvas);
    }

    private void drawRectangle(Canvas canvas){
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(0,0,mWidth,mHeight,mPaint);
    }


private Paint mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private void drawSpectrum(Canvas canvas){
        mPaint.setStrokeWidth(2);
        mPath.reset();
        int index = 0;
        float widthPer2Point = 1.f*mWidth/SIZE_QUEUE;
        float widthTotal = 0;
        synchronized (lock){
            Iterator<Integer> iterator = mQueue.iterator();
            while(iterator.hasNext()){
                int value = iterator.next();
                //算出百分比
                float percent = 1.f*value/mMaxValue;
                Log.e("xiaojun","percent="+percent);
                //根据百分比算出高度
                float ponitHeight = (1-percent)*mHeight;
                mPointsLocations.get(index).x = widthTotal;
                mPointsLocations.get(index).y = ponitHeight;
                if (index == 0)
                    mPath.moveTo(widthTotal,ponitHeight);
                else
                    mPath.lineTo(widthTotal,ponitHeight);
                Log.e("xiaojun","坐标x="+widthTotal+",y="+ponitHeight+",value = "+value+",mMaxValue = "+mMaxValue);
                widthTotal += widthPer2Point;
                index++;
            }
        }
        mPaint.setColor(Color.GREEN);
        canvas.drawPath(mPath,mPaint);
        mPaint2.setColor(Color.WHITE);
        for (int i = 0; i < mPointsLocations.size(); i++) {
            PointF point = mPointsLocations.get(i);
            canvas.drawCircle(point.x,point.y,5,mPaint2);
        }
    }
}
