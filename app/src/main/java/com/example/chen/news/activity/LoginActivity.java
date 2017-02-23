package com.example.chen.news.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.chen.news.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.qqlogin_iv)
    ImageView qqloginIv;
    @Bind(R.id.sinalogin_iv)
    ImageView sinaloginIv;
    @Bind(R.id.weixinlogin_iv)
    ImageView weixinloginIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.qqlogin_iv, R.id.sinalogin_iv, R.id.weixinlogin_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qqlogin_iv:

                break;
            case R.id.sinalogin_iv:
                break;
            case R.id.weixinlogin_iv:
                break;
        }
    }
}
