package com.example.zzh.qqplayer;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import base.BaseActivity;
import butterknife.BindView;
import factory.FactoryFragment;

public class MainActivity extends BaseActivity
{

    @BindView(R.id.bottom_Bar)
    BottomBar   mBottomBar;
    @BindView(R.id.home_container)
    FrameLayout mHomeContainer;

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

    private OnTabSelectListener tabSelectListener = new OnTabSelectListener()
    {
        @Override
        public void onTabSelected(@IdRes int tabId)
        {
            //拿到fragmentfactory的实例
            FactoryFragment factoryFragment = FactoryFragment.getInstance();
            //拿到fragment的管理器
            FragmentManager fragmentManager = getSupportFragmentManager();
            //创建一个事物
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            //替换fragment
            transaction.replace(R.id.home_container, factoryFragment.getFragment(tabId));
            //提交事物
            transaction.commit();

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

}
