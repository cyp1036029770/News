package com.example.chen.news.network;


import com.example.chen.news.MyApplication;
import com.example.chen.news.base.HttpModel;

import java.io.File;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chen on 2016/12/18.
 */
public class HttpUtils {
    public static  Retrofit retrofit;
    public  static  HttpUtils instance;
    public  static  synchronized HttpUtils getInstance(){
        if(instance==null){
            instance=new HttpUtils();
        }
        return  instance;
    }

    private HttpUtils(){
        File httpCacheDirectory = new File(MyApplication.ctx.getExternalCacheDir(), "responses");
        //设置缓存 10M
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        OkHttpClient client=new OkHttpClient.Builder()
                .writeTimeout(3000, TimeUnit.MINUTES)
                .readTimeout(3000, TimeUnit.MINUTES)
                .connectTimeout(3000,TimeUnit.MINUTES)
               .addInterceptor(new CacheInterceptor())
                .cache(cache)
                .build();
        retrofit=new Retrofit.Builder().baseUrl(HttpModel.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
               .client(client)
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public   <T> T create(Class<T> tClass) {
        return retrofit.create(tClass) ;
    }

    /*public <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }*/
}
