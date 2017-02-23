package com.example.chen.news.face;

import com.example.chen.news.bean.NewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chen on 2017/2/7.
 */
public interface IRetrofit {
    @GET("index")
    Call<NewsBean> getNewsBean(@Query("type") String type,
                                  @Query("key") String key);
}
