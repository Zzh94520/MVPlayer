package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import adapter.MVPageAdapter;
import presenter.BasePersenter;
import presenter.impl.MVPagePersenter;
import widget.BaseResult;

/**
 * 类    名:  MVPageFragment
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 17:43$
 * 描    述： ${TODO}
 */
public class MVPageFragment extends BaseContainerFragment
{

    private MVPagePersenter mMvPagePersenter;
    private String mCode;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mCode = bundle.getString("code");
    }

    public static MVPageFragment newInstance(String code)
    {
        MVPageFragment mvPageFragment = new MVPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("code",code);
        mvPageFragment.setArguments(bundle);
        return mvPageFragment;
    }

    @Override
    protected RecyclerView.Adapter getAdapter()
    {
        return new MVPageAdapter(getContext(), mMvPagePersenter.getDataList());
    }

    @Override
    protected BasePersenter getPersenter(BaseResult baseResult)
    {
        mMvPagePersenter = new MVPagePersenter(baseResult, mCode);
        mMvPagePersenter.loadListData();
        return mMvPagePersenter;
    }
}
