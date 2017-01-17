package presenter.impl;

import com.itheima.leon.funhttplib.NetworkListener;

import java.util.ArrayList;
import java.util.List;

import fragment.BaseContainerFragment;
import fragment.HomeFragment;
import model.HomeBean;
import network.HomeRequest;
import presenter.BasePersenter;
import utils.URLProviderUtil;

/**
 * 类    名:  HomePersenter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/16
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/16: 15:56$
 * 描    述： ${TODO}
 */

public class HomePersenter implements BasePersenter<HomeBean>
{
    private HomeFragment mHomeFragment;
    private List<HomeBean> list ;

    public HomePersenter(BaseContainerFragment baseContainerFragment)
    {
        mHomeFragment = (HomeFragment) baseContainerFragment;
        list = new ArrayList<HomeBean>();
    }

    @Override
    public void loadListData()
    {
        loadListData(0,10);
    }

    @Override
    public void loadMoreData()
    {
        loadListData(list.size(),10);
    }

    @Override
    public void refresh()
    {
        list.clear();
        loadListData(0,10);
    }

    @Override
    public List<HomeBean> getDataList()
    {
        return list;
    }

    private void loadListData(int offset,int size)
    {
        String url = URLProviderUtil.getHomeUrl(offset, 10);
//        OkHttpClient client = new OkHttpClient();
//        final Request request = new Request.Builder().get().url(url).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e)
//            {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException
//            {
//                List<HomeBean> homeBeen = mGson.fromJson(response.body().string(),
//                                          new TypeToken<List<HomeBean>>() {}.getType());
//                list.addAll(homeBeen);
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run()
//                    {
//                        mHomeFragment.onDataLoadSuccess();
//                    }
//                });
//            }
//        });
        new HomeRequest(url,mListNetworkListener).execute();
    }

    private NetworkListener<List<HomeBean>> mListNetworkListener = new NetworkListener<List<HomeBean>>(){
        @Override
        public void onFailed(String s)
        {
            mHomeFragment.onDataLoadFailed();
        }

        @Override
        public void onSuccess(List<HomeBean> homeBeen)
        {
            list.addAll(homeBeen);
            mHomeFragment.onDataLoadSuccess();
        }

    };
}




