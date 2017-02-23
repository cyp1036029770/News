package com.example.chen.news.utils;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Config;
import android.util.LruCache;
import android.widget.ImageView;

import com.example.chen.news.R;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;

/**
 * Created by 10360 on 2016/10/30.
 * 图片加载的工具类
 */

public class ImageLoaderUtils {
    public  static void  imageLoader(Context ctx, String imageURL, ImageView imageView){
        //设置了预加载图片和图片加载错误的时候的图片
        Picasso.with(ctx).load(imageURL).error(R.mipmap.load_fail).placeholder(R.mipmap.load).into(imageView);

    }


}
