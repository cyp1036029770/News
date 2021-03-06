package com.example.chen.news.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by 10360 on 2016/10/26.
 */

public class StateBarUtils {
    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            View view = createStatusBarView(activity, color);
            if (view != null) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                viewGroup.addView(view);

                View contentView =  ((ViewGroup) activity.getWindow().getDecorView()
                        .findViewById(Window.ID_ANDROID_CONTENT)).getChildAt(0);
                if(contentView instanceof ViewGroup){
                    ViewGroup content = (ViewGroup)contentView;
                    //这个是为了内容不会伸到zh
                    content.setFitsSystemWindows(true);
                    content.setClipToPadding(true);
                }
            }
        }
    }

    /**
     * 获取系统状态栏的高度
     * @param activity
     * @return
     */
    private static int getStatusBarHeight(Activity activity) {
        int viewHeight = 0;
        if (activity != null) {
            int resourseId =
                    activity.getResources().getIdentifier("status_bar_height", "dimen", "android");

            viewHeight = activity.getResources().getDimensionPixelSize(resourseId);
        }
        return viewHeight;
    }


    /**
     * 创建一个view填充状态栏
     */
    private static View createStatusBarView(Activity activity, int color) {

        int viewHeight = getStatusBarHeight(activity);
        if (viewHeight == 0) {
            return null;
        } else {
            View view = new View(activity);
            ViewGroup.LayoutParams layoutParams =
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, viewHeight);
            view.setLayoutParams(layoutParams);
            view.setBackgroundColor(color);
            return view;
        }
    }

}
