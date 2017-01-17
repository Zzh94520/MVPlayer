package presenter;

import java.util.List;

/**
 * 类    名:  BasePersenter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/17
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/17: 21:40$
 * 描    述： ${TODO}
 */
public interface BasePersenter<T>
{
    void loadListData();
    void loadMoreData();
    List<T> getDataList();
    void refresh();
}
