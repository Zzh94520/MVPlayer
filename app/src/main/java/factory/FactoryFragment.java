package factory;

import com.example.zzh.qqplayer.R;

import base.BaseFragment;
import fragment.HomeFragment;
import fragment.MusicListFragment;
import fragment.MvFragment;
import fragment.VbangFragment;

/**
 * 类    名:  FactoryFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 16:41$
 * 描    述： ${TODO}
 */

public class FactoryFragment
{
    private static FactoryFragment mFactoryFragment;
    private FactoryFragment(){}
    public static FactoryFragment getInstance()
    {
        if (mFactoryFragment == null)
        {
            synchronized (FactoryFragment.class)
            {
                if (mFactoryFragment == null)
                {
                    mFactoryFragment = new FactoryFragment();
                    return mFactoryFragment;
                }
            }
        }
        return mFactoryFragment;
    }

    public BaseFragment getFragment(int tabId)
    {
        switch (tabId)
        {
            case R.id.home:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case R.id.mv:
                MvFragment mvFragment = new MvFragment();
                return mvFragment;
            case R.id.vbang:
                VbangFragment vbangFragment = new VbangFragment();
                return vbangFragment;
            case R.id.musiclist:
                MusicListFragment musicListFragment = new MusicListFragment();
                return musicListFragment;
        }
        return null;
    }
}
