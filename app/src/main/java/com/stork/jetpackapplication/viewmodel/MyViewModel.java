package com.stork.jetpackapplication.viewmodel;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stork.jetpackapplication.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel implements Observable {
    private MutableLiveData<List<User>> users;


    public LiveData<List<User>> getUsers(){
        if (users == null){
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }



    private void loadUsers(){
        //Do an asynchronous operation to fetch users
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    List<User> listUsers = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        User user = new User();
                        user.name = "lee-"+(i+1);
                        user.age = 19+i;
                        listUsers.add(user);
                    }
                    users.postValue(listUsers);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("xiaojun","onCleared");
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {

    }

    /**
     * 用户类
     */
    public static class User{
        public String name;
        public int age;
    }
}
