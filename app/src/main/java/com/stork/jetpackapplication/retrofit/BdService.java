package com.stork.jetpackapplication.retrofit;

import com.stork.jetpackapplication.bean.SingerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Lj service
 * created by xiaojun at 2020/8/7
 */
public interface BdService {
    //ting?from=android&version=2.4.0&method=baidu.ting.artist.get72HotArtist&format=json&order=1&offset=0&limit=50
    @Headers(value = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36")
    @GET("ting?from=android&version=2.4.0&method=baidu.ting.artist.get72HotArtist&format=json")
    Call<SingerList> singerList(@Query("order") int order, @Query("offset") int offset, @Query("limit") int limit);
}
