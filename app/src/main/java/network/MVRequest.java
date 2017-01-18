package network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;

import java.util.List;

import model.MVBean;

/**
 * 类    名:  MVRequest
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 12:47$
 * 描    述： ${TODO}
 */

public class MVRequest extends Request<List<MVBean.MVPageBean>>
{
    public MVRequest(String url, NetworkListener listener)
    {
        super(url, listener);
    }
}
