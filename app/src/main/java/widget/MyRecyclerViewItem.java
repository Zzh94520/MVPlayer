package widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.zzh.qqplayer.R;

/**
 * 类    名:  MyRecyclerViewItem
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 21:05$
 * 描    述： ${TODO}
 */

public class MyRecyclerViewItem extends RelativeLayout
{
    public MyRecyclerViewItem(Context context)
    {
        this(context,null);
    }

    public MyRecyclerViewItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_recycleview, this);
    }
}
