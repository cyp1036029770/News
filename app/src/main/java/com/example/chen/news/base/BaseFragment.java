package com.example.chen.news.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chen on 2017/2/6.
 */
public abstract class   BaseFragment extends Fragment {


    private View rootView;
    public boolean isVisible;
    public Context ctx;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null){
            rootView = initView(inflater,container);
            initData();
            initAdapter();

        }
        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    protected abstract void initAdapter();

    protected abstract void initData();

    protected abstract View initView(LayoutInflater inflater, ViewGroup container);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
            isVisible = true;
        }else {
            isVisible=false;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }



}
