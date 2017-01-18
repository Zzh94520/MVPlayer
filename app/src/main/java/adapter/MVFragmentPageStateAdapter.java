package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import fragment.MVPageFragment;
import model.MVBean;

/**
 * 类    名:  MVFragmentPageStateAdapter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 18:51$
 * 描    述： ${TODO}
 */

public class MVFragmentPageStateAdapter extends FragmentStatePagerAdapter
{
    private List<MVBean.MVPageBean> mList;

    public MVFragmentPageStateAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public MVFragmentPageStateAdapter(FragmentManager fm, List<MVBean.MVPageBean> list)
    {
        super(fm);
        mList = list;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return mList.get(position).getName();
    }

    @Override
    public Fragment getItem(int position)
    {
        return MVPageFragment.newInstance(mList.get(position).getCode());
    }

    @Override
    public int getCount()
    {
        return mList != null ? mList.size() : 0;
    }
}
