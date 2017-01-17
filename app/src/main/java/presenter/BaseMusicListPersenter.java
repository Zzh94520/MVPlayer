package presenter;

import java.util.List;

import model.MusicListBean;

/**
 * 类    名:  BaseListPersenter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/16
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/16: 15:06$
 * 描    述： ${TODO}
 */

public interface BaseMusicListPersenter
{
    void loadListData();
    void loadMoreData();
    void refresh();
    List<MusicListBean.PlayListsBean> getDataList();
}
