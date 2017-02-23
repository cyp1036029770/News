package com.example.chen.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.chen.news.MyApplication;


public class SPUtils {

    public static void saveSetting(String name, String content) {
        SharedPreferences.Editor user_setting;
        if (name.equals("first")) {
            user_setting = MyApplication.ctx.getSharedPreferences("tips", Context.MODE_PRIVATE).edit();
        } else {
            user_setting = MyApplication.ctx.getSharedPreferences("user_setting", Context.MODE_PRIVATE).edit();
        }
        user_setting.remove(name);
        user_setting.putString(name, content).commit();

    }

    public static void saveSetting(String name, int content) {
        SharedPreferences.Editor user_setting = MyApplication.ctx.getSharedPreferences("user_setting", Context.MODE_PRIVATE).edit();
        user_setting.remove(name);
        user_setting.putInt(name, content).commit();
    }

    public static void removeSetting() {
        MyApplication.ctx.getSharedPreferences("user_setting", Context.MODE_PRIVATE).edit().clear().commit();
    }

    public static String getSetting(String name) {
        if (name.equals("first")) {
            return MyApplication.ctx.getSharedPreferences("first", Context.MODE_PRIVATE).getString("first", "");
        } else {
            return MyApplication.ctx.getSharedPreferences("user_setting", Context.MODE_PRIVATE).getString(name, "");
        }
    }

    public static int getIntSetting(String name) {
        return MyApplication.ctx.getSharedPreferences("user_setting", Context.MODE_PRIVATE).getInt(name, 0);
    }

}
