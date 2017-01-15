package com.example.zzh.qqplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.roughike.bottombar.OnTabSelectListener;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
{
    @BindView(R.id.home_Container)
    FrameLayout                      mHomeContainer;
    @BindView(R.id.bottom_Bar)
    com.roughike.bottombar.BottomBar mBottomBar;


    @Override
    protected int getLayoutResId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void init()
    {
        super.init();
        mBottomBar.setOnTabSelectListener(tabSelectListener);
    }

    private OnTabSelectListener tabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId)
        {
            switch (tabId)
            {
                case R.id.home:
                    break;
                case R.id.mv:
                    break;
                case R.id.vbang:
                    break;
                case R.id.musiclist:
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.settings_menu:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
