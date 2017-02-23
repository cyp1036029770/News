package com.example.chen.news;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.example.chen.news.utils.Utils;

import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;

/**
 * Created by chen on 2017/2/6.
 */
public class MyApplication extends Application {
    public static Context ctx;
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        ctx = this;
        FIR.init(this);
        FIR.checkForUpdateInAppStore(new VersionCheckCallback() {
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
            }

            @Override
            public void onFail(Exception e) {
                super.onFail(e);
            }

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }
}
