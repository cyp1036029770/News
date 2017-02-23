package com.example.chen.news;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.news.activity.LoginActivity;
import com.example.chen.news.base.BaseActivity;
import com.example.chen.news.fragment.CollectionFragment;
import com.example.chen.news.fragment.MeFragment;
import com.example.chen.news.fragment.NewsFragment;
import com.example.chen.news.fragment.SettingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fragmentGroups)
    FrameLayout fragmentGroups;
    @Bind(R.id.navigationView)
    NavigationView navigationView;
    @Bind(R.id.activity_main_drawer)
    DrawerLayout activityMainDrawer;
    private FragmentManager fm;
    private NewsFragment newsFragment;
    private MeFragment meFragment;
    private CollectionFragment collectionFragment;
    private SettingFragment settingFragment;
    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init(savedInstanceState);
        initView();
    }



    private void init(Bundle savedInstanceState) {
        fm = getSupportFragmentManager();
        if(savedInstanceState==null){
            newsFragment = new NewsFragment();
            meFragment = new MeFragment();
            collectionFragment = new CollectionFragment();
            settingFragment = new SettingFragment();
            fm.beginTransaction().replace(R.id.fragmentGroups, newsFragment,NewsFragment.class.getSimpleName()).commit();
        }


    }

    private void initView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, activityMainDrawer, toolbar, R.string.open, R.string.close);
        activityMainDrawer.setDrawerListener(toggle);
        toggle.syncState();
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("新闻");
       // toolbar.setTitleTextAppearance(); gai该属性设置toolbar的字体的基本属性
        headerView =  navigationView.getHeaderView(0);
        CircleImageView circleImageView= (CircleImageView) headerView.findViewById(R.id.circleview);
       TextView simpleName= (TextView) headerView.findViewById(R.id.simpleName);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                activityMainDrawer.closeDrawer(Gravity.LEFT);
                toolbar.setTitle(item.getTitle());
                switch (item.getItemId()){
                    case  R.id.news:
                        fm.beginTransaction().replace(R.id.fragmentGroups,newsFragment,NewsFragment.class.getSimpleName()).commit();
                         break;
                    case  R.id.me:
                        fm.beginTransaction().replace(R.id.fragmentGroups,meFragment,MeFragment.class.getSimpleName()).commit();
                        break;
                    case R.id.collection:
                        fm.beginTransaction().replace(R.id.fragmentGroups,collectionFragment,CollectionFragment.class.getSimpleName()).commit();
                        break;
                    case R.id.setting:

                        fm.beginTransaction().replace(R.id.fragmentGroups,settingFragment,SettingFragment.class.getSimpleName()).commit();
                        break;
                }
                return true;
            }
        });
    }


}
