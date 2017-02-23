package com.example.chen.news.utils;

import android.util.Log;
import android.widget.Toast;

import com.example.chen.news.MyApplication;


/**
 * Created by SchafferW on 2016/11/15.
 */

public class NotifyUtils {

    public static void w(String s) {
        Toast.makeText(MyApplication.ctx,s.toString(),Toast.LENGTH_SHORT).show();
    }
}
