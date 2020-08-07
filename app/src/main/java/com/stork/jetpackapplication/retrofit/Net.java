package com.stork.jetpackapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit封装类
 * created by xiaojun at 2020/8/7
 */
public class Net {
    private static Net sNet = new Net();
    private static final String URL_BD = "http://tingapi.ting.baidu.com/v1/restserver/";
    private static BdService sBdService;
    private Net(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BD)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sBdService = retrofit.create(BdService.class);
    }


    public static Net getInstance(){
        return sNet;
    }

    public BdService getBdService(){
        return sBdService;
    }
}
