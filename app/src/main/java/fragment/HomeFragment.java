package fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zzh.qqplayer.R;

import adapter.HomeRecycleAdapter;
import base.BaseFragment;
import butterknife.BindView;

/**
 * 类    名:  HomeFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 18:12$
 * 描    述： ${TODO}
 */

public class HomeFragment extends BaseFragment
{
    @BindView(R.id.home_recyclerview)
    RecyclerView mHomeRecyclerview;

    @Override
    protected int getFragmentId()
    {
        return R.layout.fragment_home;
    }

    @Override
    protected void init()
    {
        super.init();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mHomeRecyclerview.setLayoutManager(manager);
        mHomeRecyclerview.setAdapter(new HomeRecycleAdapter(getContext()));
    }
}
