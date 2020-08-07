package com.stork.jetpackapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.stork.jetpackapplication.databinding.ActivityMainBinding;
import com.stork.jetpackapplication.fragment.OnlineMFragment;
import com.stork.jetpackapplication.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试JetPack中LiveData相关概念
 * 目前已经能够使用ViewModel和LiveData
 * next:
 * 搞清
 * Transformations.map
 * 和
 * Transformations.switchMap
 * 的不同
 * created by xiaojun at 2020/8/6
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //使用ViewModel来处理 屏幕 旋转时 数据丢失的问题
        //ViewModel还可以处理 2个Fragment 的通信
        MyViewModel model = new ViewModelProvider(this).get(MyViewModel.class);
        /*model.getUsers().observe(this, new Observer<List<MyViewModel.User>>() {
            @Override
            public void onChanged(List<MyViewModel.User> users) {
                for (MyViewModel.User user :
                        users) {
                    Log.e("xiaojun","接收到用户数据:"+user.name);
                }
            }
        });*/
        LiveData<List<MyViewModel.User>> users = model.getUsers();
        //将LiveData分配给观察者对象之前，将存储在其中的值进行更改
        //比如将得到的List<User>对象改为List<String>对象，然后传递给下游
        LiveData<List<String>> newData = Transformations.map(users, new Function<List<MyViewModel.User>, List<String>>() {
            @Override
            public List<String> apply(List<MyViewModel.User> input) {
                List<String> list = new ArrayList<>();
                for (MyViewModel.User user :
                        input) {
                    list.add(user.name);
                }
                return list;
            }
        });
        newData.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                for (String name :
                        strings) {
                    Log.e("xiaojun", "接收到数据:" + name + "-2");
                }
            }
        });
        //数据绑定
        binding.setLifecycleOwner(this);

        binding.setMyviewmodel(model);

        binding.setActivityHandler(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new OnlineMFragment()).commit();
    }

    public void clickTextView(View view){
        Toast.makeText(this,"你点击了",Toast.LENGTH_SHORT).show();
    }

}