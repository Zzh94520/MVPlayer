package fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.zzh.qqplayer.R;

import base.BaseFragment;
import butterknife.BindView;
import presenter.BasePersenter;
import widget.BaseResult;

/**
 * 类    名:  BaseContainerFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/17
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/17: 21:36$
 * 描    述： ${TODO}
 */

public abstract class BaseContainerFragment extends BaseFragment implements BaseResult
{
    @BindView(R.id.home_recyclerview)
    RecyclerView       mRecyclerview;
    @BindView(R.id.home_swipe_refresh)
    SwipeRefreshLayout mHomeSwipeRefresh;
    private BasePersenter mPersenter;
    private LinearLayoutManager mManager;

    private static final String TAG = "BaseContainerFragment";

    @Override
    protected int getFragmentId()
    {
        return R.layout.base_container_fragment;
    }

    @Override
    protected void init()
    {
        super.init();
        mPersenter = getPersenter(this);
        setAdapterAndEvent();
    }

    protected void setAdapterAndEvent()
    {
        mRecyclerview.setHasFixedSize(true);
        //创建管理器
        mManager = new LinearLayoutManager(getContext());
        //设置管理器
        mRecyclerview.setLayoutManager(mManager);
        //设置adapter
        mRecyclerview.setAdapter(getAdapter());
        mRecyclerview.addOnScrollListener(mOnScrollListener);
        mHomeSwipeRefresh.setOnRefreshListener(mOnRefreshListener);
    }

    //设置滚动监听，实现上拉加载
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener()
    {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState)
        {
            LinearLayoutManager layoutManager =
                    (LinearLayoutManager) recyclerView.getLayoutManager();
            if (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_IDLE)
            {
                if (layoutManager.findLastVisibleItemPosition() ==
                    recyclerView.getAdapter().getItemCount() - 1)
                {
                    mHomeSwipeRefresh.setRefreshing(true);
                    mPersenter.loadMoreData();
                }
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
    };

    //设置监听，实现下拉刷新
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh()
        {
            mPersenter.refresh();
        }
    };

    @Override
    public void onDataLoadSuccess()
    {
        mRecyclerview.getAdapter().notifyDataSetChanged();
        mHomeSwipeRefresh.setRefreshing(false);
        Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataLoadFailed()
    {
        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
    }

    protected abstract RecyclerView.Adapter getAdapter();

    protected abstract BasePersenter getPersenter(BaseResult baseResult);
}
