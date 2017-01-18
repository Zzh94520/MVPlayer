package presenter.impl;

import com.itheima.leon.funhttplib.NetworkListener;

import java.util.ArrayList;
import java.util.List;

import model.MVListBean;
import network.MVPageRequest;
import presenter.BasePersenter;
import utils.URLProviderUtil;
import widget.BaseResult;

/**
 * 类    名:  MVPagePersenter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 17:45$
 * 描    述： ${TODO}
 */
public class MVPagePersenter implements BasePersenter<MVListBean.VideosBean>
{
    private BaseResult mBaseResult;
    private String mCode;
    private final List<MVListBean.VideosBean> list;

    public MVPagePersenter(BaseResult baseResult, String code)
    {
        mBaseResult = baseResult;
        mCode = code;
        list = new ArrayList<>();
    }

    @Override
    public void loadListData()
    {
        loadListData(0);
    }

    @Override
    public void loadMoreData()
    {
        loadListData(list.size());
    }

    @Override
    public List<MVListBean.VideosBean> getDataList()
    {
        return list;
    }

    @Override
    public void refresh()
    {
        list.clear();
        loadListData(0);
    }

    private void loadListData(int offset)
    {
        String url = URLProviderUtil.getMVListUrl(mCode, offset, 10);
        new MVPageRequest(url,mNetWorkListener).execute();
    }

    private NetworkListener<MVListBean> mNetWorkListener = new NetworkListener<MVListBean>() {
        @Override
        public void onFailed(String s)
        {
            mBaseResult.onDataLoadFailed();
        }

        @Override
        public void onSuccess(MVListBean mvListBean)
        {
            list.addAll(mvListBean.getVideos());
            mBaseResult.onDataLoadSuccess();
        }
    };
}
