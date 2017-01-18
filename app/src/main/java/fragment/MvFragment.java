package fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.zzh.qqplayer.R;
import com.itheima.leon.funhttplib.NetworkListener;

import java.util.ArrayList;
import java.util.List;

import adapter.MVFragmentPageStateAdapter;
import base.BaseFragment;
import butterknife.BindView;
import model.MVBean;
import network.MVRequest;
import utils.URLProviderUtil;


/**
 * 类    名:  HomeFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 18:12$
 * 描    述： ${TODO}
 */

public class MvFragment extends BaseFragment
{
    @BindView(R.id.mv_tablayout)
    TabLayout mMvTablayout;
    @BindView(R.id.mv_vp)
    ViewPager mMvVp;
    private MVFragmentPageStateAdapter adapter;
    private              List<MVBean.MVPageBean> list = new ArrayList<>();
    private static final String                  TAG  = "MvFragment";

    @Override
    protected int getFragmentId()
    {
        return R.layout.fragment_mv;
    }

    @Override
    protected void init()
    {
        super.init();
        new MVRequest(URLProviderUtil.getMVareaUrl(), netWorkListener).execute();
        //        adapter = new MVAdapter();
        adapter =
                new MVFragmentPageStateAdapter(getChildFragmentManager(),list);
        mMvTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mMvVp.setAdapter(adapter);
        mMvTablayout.setupWithViewPager(mMvVp);
    }

    private NetworkListener netWorkListener = new NetworkListener<List<MVBean.MVPageBean>>()
    {
        @Override
        public void onFailed(String s)
        {
            Log.d(TAG, "onFailed ");
        }

        @Override
        public void onSuccess(List<MVBean.MVPageBean> mvPageBeen)
        {
            list.addAll(mvPageBeen);
            adapter.notifyDataSetChanged();
            Log.d(TAG, "onSuccess ");
        }

    };


    //    private class MVAdapter extends PagerAdapter
    //    {
    //
    //        @Override
    //        public Object instantiateItem(ViewGroup container, int position)
    //        {
    ////            TextView tv = new TextView(getContext());
    ////            tv.setText(list.get(position).getCode());
    ////            tv.setTextSize(20);
    ////            container.addView(tv);
    ////            return tv;
    //            MVPageFragment mvPageFragment =
    //                    MVPageFragment.newInstance(list.get(position).getCode());
    //            return null;
    //        }
    //
    //        @Override
    //        public CharSequence getPageTitle(int position)
    //        {
    //            return list != null ? list.get(position).getName() : null;
    //        }
    //
    //        @Override
    //        public void destroyItem(ViewGroup container, int position, Object object)
    //        {
    //            container.removeView((View) object);
    //        }
    //
    //        @Override
    //        public int getCount()
    //        {
    //            return list != null ? list.size() : 0;
    //        }
    //
    //        @Override
    //        public boolean isViewFromObject(View view, Object object)
    //        {
    //            return view == object;
    //        }
    //    }
}
