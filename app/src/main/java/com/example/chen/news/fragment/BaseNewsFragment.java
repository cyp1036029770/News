package com.example.chen.news.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chen.news.R;

/**
 * Created by chen on 2017/2/8.
 */
public abstract class BaseNewsFragment  extends Fragment{

    private View rootView;
    public android.widget.ListView lv;
    public Context ctx;
    public android.support.v4.widget.SwipeRefreshLayout swip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView==null){
            rootView = initView(inflater,container);
        }
        initData();
        return rootView;
    }
    public abstract void initData();



    protected  View initView(LayoutInflater inflater, ViewGroup container){
       View view= inflater.inflate(R.layout.fragment_base,container,false);
        this.swip = (SwipeRefreshLayout) view.findViewById(R.id.swip);
        this.lv = (ListView) view.findViewById(R.id.lv);
        /*swip.post(new Runnable() {
            @Override
            public void run() {
swip.setRefreshing(true);
            }
        });*/
        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(lv.getId()==0&&lv.getTop()==0){
                    loadMore();

                }
            }
        });
        initListener();
        return  view;
    }

    private void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    protected abstract void loadMore();

    ;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ctx = activity;
    }

}
