package fragment;

import android.support.v7.widget.RecyclerView;

import adapter.MusicListRecycleAdapter;
import presenter.BasePersenter;
import presenter.impl.MusicListPersenter;

/**
 * 类    名:  HomeFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 18:12$
 * 描    述： ${TODO}
 */

public class MusicListFragment extends BaseContainerFragment
{

    private MusicListPersenter mMusicListPersenter;

    @Override
    protected RecyclerView.Adapter getAdapter()
    {
        return new MusicListRecycleAdapter(getContext(),mMusicListPersenter.getDataList());
    }

    @Override
    protected BasePersenter getPersenter(BaseContainerFragment baseContainerFragment)
    {
        mMusicListPersenter = new MusicListPersenter(baseContainerFragment);
        mMusicListPersenter.loadListData();
        return mMusicListPersenter;
    }
    //    @BindView(R.id.music_list_recyclerview)
//    RecyclerView       mMusicListRecyclerview;
//    @BindView(R.id.music_list_swipe_refresh)
//    SwipeRefreshLayout mMusicListSwipeRefresh;
//
//    private MusicListPersenter      mMusicListPersenter;
//    private LinearLayoutManager     mLinearLayoutManager;
//    private MusicListRecycleAdapter adapter;
//    private List<MusicListBean.PlayListsBean> mDataList;
//
//    @Override
//    protected int getFragmentId()
//    {
//        return R.layout.fragment_music_list;
//    }
//
//    @Override
//    protected void init()
//    {
//        super.init();
//        mMusicListPersenter = new MusicListPersenter(this);
//        mMusicListPersenter.loadListData();
//        setViewData();
//
//        mMusicListSwipeRefresh.setOnRefreshListener(mRefreshListener);
//        mMusicListRecyclerview.addOnScrollListener(mOnScrollListener);
//    }
//
//    private void setViewData()
//    {
//        mDataList = mMusicListPersenter.getDataList();
//        mMusicListRecyclerview.setHasFixedSize(true);
//        mLinearLayoutManager = new LinearLayoutManager(getContext());
//        adapter = new MusicListRecycleAdapter(getContext(), mDataList);
//        mMusicListRecyclerview.setLayoutManager(mLinearLayoutManager);
//        mMusicListRecyclerview.setAdapter(adapter);
//    }
//
//    private SwipeRefreshLayout.OnRefreshListener mRefreshListener =
//            new SwipeRefreshLayout.OnRefreshListener()
//            {
//                @Override
//                public void onRefresh()
//                {
//                    mMusicListPersenter.refresh();
//                }
//            };
//
//    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener()
//    {
//        @Override
//        public void onScrollStateChanged(RecyclerView recyclerView, int newState)
//        {
//            if (newState == RecyclerView.SCROLL_STATE_IDLE)
//            {
//                if (mLinearLayoutManager.findLastVisibleItemPosition() ==
//                    mMusicListRecyclerview.getAdapter().getItemCount() - 1)
//                {
//                    mMusicListPersenter.loadMoreData();
//                }
//            }
//        }
//    };
//
//    @Override
//    public void onDataLoadSuccess()
//    {
//        mDataList = mMusicListPersenter.getDataList();
//        adapter.notifyDataSetChanged();
//        mMusicListSwipeRefresh.setRefreshing(false);
//        Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
//    }
}
