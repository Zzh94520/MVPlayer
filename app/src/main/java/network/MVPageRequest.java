package network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;

import model.MVListBean;

/**
 * 类    名:  MVPageRequest
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 18:12$
 * 描    述： ${TODO}
 */

public class MVPageRequest extends Request<MVListBean>
{
    public MVPageRequest(String url, NetworkListener listener)
    {
        super(url, listener);
    }
}
