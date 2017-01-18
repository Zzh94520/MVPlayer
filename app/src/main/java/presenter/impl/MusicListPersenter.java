package presenter.impl;

import android.os.Handler;

import com.itheima.leon.funhttplib.NetworkListener;

import java.util.ArrayList;
import java.util.List;

import model.MusicListBean;
import network.MusicListRequest;
import presenter.BasePersenter;
import utils.URLProviderUtil;
import widget.BaseResult;

/**
 * 类    名:  MusicListPersenter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/16
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/16: 22:04$
 * 描    述： ${TODO}
 */

public class MusicListPersenter implements BasePersenter<MusicListBean.PlayListsBean>
{
    private       BaseResult                      mBaseResult;
    private ArrayList<MusicListBean.PlayListsBean> mListsBeen;
    private static final String  TAG      = "MusicListPersenter";
    private              Handler mHandler = new Handler();

    public MusicListPersenter(BaseResult baseResult)
    {
        mBaseResult = baseResult;
        mListsBeen = new ArrayList<MusicListBean.PlayListsBean>();
    }

    @Override
    public void loadListData()
    {
        loadListData(0);
    }

    @Override
    public void loadMoreData()
    {
        loadListData(mListsBeen.size());
    }

    @Override
    public void refresh()
    {
        mListsBeen.clear();
        loadListData(0);
    }

    @Override
    public List<MusicListBean.PlayListsBean> getDataList()
    {
        return mListsBeen;
    }

    private void loadListData(int offset)
    {
        String url = URLProviderUtil.getYueDanUrl(offset, 10);
        new MusicListRequest(url, mListNetworkListener).execute();
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().get().url(url).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e)
//            {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run()
//                    {
//                        mBaseResult.onDataLoadFailed();
//                    }
//                });
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException
//            {
//                Gson gson = new Gson();
//                MusicListBean musicListBean =
//                        gson.fromJson(response.body().string(), MusicListBean.class);
//                mListsBeen.addAll(musicListBean.getPlayLists());
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run()
//                    {
//                        mBaseResult.onDataLoadSuccess();
//                    }
//                });
//            }
//        });
    }

    private NetworkListener<MusicListBean> mListNetworkListener =
            new NetworkListener<MusicListBean>()
            {
                @Override
                public void onFailed(String s)
                {
                    mBaseResult.onDataLoadFailed();
                }

                @Override
                public void onSuccess(MusicListBean musicListBean)
                {
                    mListsBeen.addAll(musicListBean.getPlayLists());
                    mBaseResult.onDataLoadSuccess();
                }
            };
}
