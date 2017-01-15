package com.example.zzh.qqplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类    名:  SplashActivity
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 12:16$
 * 描    述： ${TODO}
 */

public class SplashActivity extends BaseActivity
{
    @BindView(R.id.splash_iv)
    ImageView mSplashIv;

    @Override
    protected int getLayoutResId()
    {
        return R.layout.splash_activity;
    }

    @Override
    protected void init()
    {
        super.init();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim1);
        animation.setAnimationListener(animationListener);
        mSplashIv.setAnimation(animation);
        animation.start();
    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener()
    {
        @Override
        public void onAnimationStart(Animation animation)
        {

        }

        @Override
        public void onAnimationEnd(Animation animation)
        {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation)
        {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
