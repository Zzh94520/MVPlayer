package com.example.zzh.qqplayer;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import base.BaseActivity;

/**
 * 类    名:  AboutActivity
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 19:38$
 * 描    述： ${TODO}
 */
public class AboutActivity extends BaseActivity
{
    @Override
    protected int getLayoutResId()
    {
        return R.layout.activity_about;
    }

    @Override
    protected void init()
    {
        super.init();
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(R.string.about);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
