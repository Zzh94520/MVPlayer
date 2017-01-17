package fragment;

import android.support.v7.widget.RecyclerView;

import adapter.HomeRecycleAdapter;
import presenter.BasePersenter;
import presenter.impl.HomePersenter;

/**
 * 类    名:  HomeFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 18:12$
 * 描    述： ${TODO}
 */

public class HomeFragment extends BaseContainerFragment
{

    private HomePersenter mHomePersenter;

    @Override
    protected RecyclerView.Adapter getAdapter()
    {
        return new HomeRecycleAdapter(getContext(),mHomePersenter.getDataList());
    }

    @Override
    public BasePersenter getPersenter(BaseContainerFragment baseContainerFragment)
    {
        mHomePersenter = new HomePersenter(baseContainerFragment);
        mHomePersenter.loadListData();
        return mHomePersenter;
    }


//    @BindView(R.id.home_recyclerview)
//    public RecyclerView       mHomeRecyclerview;
//    @BindView(R.id.home_swipe_refresh)
//    public SwipeRefreshLayout mHomeSwipeRefresh;
//
//    private              List<HomeBean> mHomeBeanList;
//    private HomeRecycleAdapter  mAdapter;
//    private HomePersenter       mHomePersenter;
//    private LinearLayoutManager mManager;

//    @Override
//    protected int getFragmentId()
//    {
//        return R.layout.fragment_home;
//    }
//
//    @Override
//    protected void init()
//    {
//        super.init();
//        getPersenter();
//        setAdapterAndEvent();
//
//    }


    //
//    private void getPersenter()
//    {
//        mHomePersenter = new HomePersenter(this);
//        mHomePersenter.loadListData();
//    }

//    //设置监听，实现下拉刷新
//    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
//        @Override
//        public void onRefresh()
//        {
//            mHomePersenter.refresh();
//        }
//    };
//
//    //初始化RecyclerView视图
//    private void setAdapterAndEvent()
//    {
//        mHomeRecyclerview.setHasFixedSize(true);
//        //获取集合数据
//        mHomeBeanList = mHomePersenter.getDataList();
//        //创建adapter
//        mAdapter = new HomeRecycleAdapter(getContext(), mHomeBeanList);
//        //创建管理器
//        mManager = new LinearLayoutManager(getContext());
//        //设置管理器
//        mHomeRecyclerview.setLayoutManager(mManager);
//        //设置adapter
//        mHomeRecyclerview.setAdapter(mAdapter);
//        mHomeRecyclerview.addOnScrollListener(mOnScrollListener);
//        mHomeSwipeRefresh.setOnRefreshListener(mOnRefreshListener);
//    }

//    //设置滚动监听，实现上拉加载
//    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener()
//    {
//        @Override
//        public void onScrollStateChanged(RecyclerView recyclerView, int newState)
//        {
//            LinearLayoutManager layoutManager =
//                    (LinearLayoutManager) recyclerView.getLayoutManager();
//            if (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_IDLE)
//            {
//                if (layoutManager.findLastVisibleItemPosition() ==
//                    recyclerView.getAdapter().getItemCount() - 1)
//                {
//                    mHomeSwipeRefresh.setRefreshing(true);
//                    mHomePersenter.loadMoreData();
//                }
//            }
//            super.onScrollStateChanged(recyclerView, newState);
//        }
//    };

//    //网络请求成功，则更新数据
//    @Override
//    public void onDataLoadSuccess()
//    {
//        mHomeBeanList = mHomePersenter.getDataList();
//        mAdapter.notifyDataSetChanged();
//        mHomeSwipeRefresh.setRefreshing(false);
//        Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
//    }
}
