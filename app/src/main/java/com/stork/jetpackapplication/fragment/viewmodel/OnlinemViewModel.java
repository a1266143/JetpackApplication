package com.stork.jetpackapplication.fragment.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stork.jetpackapplication.bean.SingerList;
import com.stork.jetpackapplication.retrofit.Net;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ViewModel
 * created by xiaojun at 2020/8/7
 */
public class OnlinemViewModel extends ViewModel {

    private MutableLiveData<SingerList> ldSingerList;

    public LiveData<SingerList> getSingerList(){
        if (ldSingerList == null){
            ldSingerList = new MutableLiveData<>();
            getSingerListReal();
        }
        return ldSingerList;
    }

    private void getSingerListReal(){
        Call<SingerList> callSingerList = Net.getInstance().getBdService().singerList(1,0,50);
        callSingerList.enqueue(new Callback<SingerList>() {
            @Override
            public void onResponse(Call<SingerList> call, Response<SingerList> response) {
                if (response.code() == 200){
                    SingerList singerList = response.body();
                    if (singerList!=null)
                        ldSingerList.postValue(singerList);//post值
                }
            }

            @Override
            public void onFailure(Call<SingerList> call, Throwable t) {
                Log.e("xiaojun","网络失败:"+t.getLocalizedMessage());
                ldSingerList.postValue(null);
            }
        });
    }

}
