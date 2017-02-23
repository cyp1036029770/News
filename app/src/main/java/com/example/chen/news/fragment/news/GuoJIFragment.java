package com.example.chen.news.fragment.news;

import com.example.chen.news.adapter.NewsAdapter;
import com.example.chen.news.base.HttpModel;
import com.example.chen.news.bean.NewsBean;
import com.example.chen.news.face.IRetrofit;
import com.example.chen.news.fragment.BaseNewsFragment;
import com.example.chen.news.network.HttpUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chen on 2017/2/8.
 */
public class GuoJIFragment extends BaseNewsFragment {
    @Override
    public void initData() {
        HttpUtils.getInstance().create(IRetrofit.class).getNewsBean(HttpModel.GUOJI,HttpModel.KEY).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                lv.setAdapter(new NewsAdapter(response.body().getResult().getData(),ctx));
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {

            }
        });

    }

    @Override
    protected void loadMore() {
        swip.setRefreshing(false);
    }
}
