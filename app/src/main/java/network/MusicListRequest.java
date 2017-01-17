package network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;

import model.MusicListBean;

/**
 * 类    名:  HomeRequest
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/16
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/16: 21:09$
 * 描    述： ${TODO}
 */

public class MusicListRequest extends Request<MusicListBean>
{
    public MusicListRequest(String url, NetworkListener listener)
    {
        super(url, listener);
    }
}
