package com.stork.jetpackapplication;

import android.app.Application;

public class MyApplication extends Application {
    public static int AGE = 18;
    public int getAge(){
        return AGE;
    }
}
