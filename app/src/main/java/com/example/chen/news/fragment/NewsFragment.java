package com.example.chen.news.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chen.news.R;
import com.example.chen.news.base.BaseFragment;
import com.example.chen.news.fragment.news.GuoJIFragment;
import com.example.chen.news.fragment.news.GuoNeiFragment;
import com.example.chen.news.fragment.news.JunShiFragment;
import com.example.chen.news.fragment.news.KeJiFragment;
import com.example.chen.news.fragment.news.SheHuiFragment;
import com.example.chen.news.fragment.news.ShiShangFragment;
import com.example.chen.news.fragment.news.TiYuFragment;
import com.example.chen.news.fragment.news.TopNewsFragment;
import com.example.chen.news.fragment.news.YuLeFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/2/6.
 */
public class NewsFragment extends BaseFragment {



    ViewPager pager;
    SmartTabLayout viewpagertab;
    private List<Fragment> fragmentList;


    @Override
    protected void initAdapter() {
       pager.setAdapter(new NewsFragmentAdapter(getFragmentManager()));
        viewpagertab.setViewPager(pager);
    }

    @Override
    protected void initData() {
        //news集合
        fragmentList = new ArrayList<>();
        fragmentList.add(new TopNewsFragment());
        fragmentList.add(new SheHuiFragment());
        fragmentList.add(new GuoJIFragment());
        fragmentList.add(new GuoNeiFragment());
        fragmentList.add(new JunShiFragment());
        fragmentList.add(new ShiShangFragment());
        fragmentList.add(new YuLeFragment());
        fragmentList.add(new TiYuFragment());
        fragmentList.add(new KeJiFragment());
        pager.setOffscreenPageLimit(1);

    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.fragment_news, container,false);
        this.pager = (ViewPager) inflate.findViewById(R.id.pager);
        this.viewpagertab = (SmartTabLayout) inflate.findViewById(R.id.viewpagertab);

        return inflate;
    }





    public  class  NewsFragmentAdapter extends FragmentPagerAdapter{
         String[] title;
        public NewsFragmentAdapter(FragmentManager fm) {
            super(fm);
            title = new String[]{"头条","社会","国内","娱乐","体育","军事","科技","财经","时尚"};
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }
}
