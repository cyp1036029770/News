package com.example.chen.news.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chen.news.base.BaseFragment;

/**
 * Created by chen on 2017/2/6.
 */
public class SettingFragment extends BaseFragment {
    @Override
    protected void initAdapter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        TextView tv=new TextView(getContext());
        tv.setText("Setting");
        return tv;
    }
}
