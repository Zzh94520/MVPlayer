package widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zzh.qqplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.HomeBean;

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
    @BindView(R.id.home_recycler)
    ImageView mHomeRecycler;
    @BindView(R.id.item_iv)
    ImageView mItemIv;
    @BindView(R.id.item_tv_title)
    TextView  mItemTvTitle;
    @BindView(R.id.item_tv)
    TextView  mItemTv;

    public MyRecyclerViewItem(Context context)
    {
        this(context, null);
    }

    public MyRecyclerViewItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_recycleview, this);
        ButterKnife.bind(this,view);
    }

    public void bind(HomeBean bean)
    {
        Glide.with(getContext()).load(bean.getPosterPic()).centerCrop().into(mHomeRecycler);
        mItemTv.setText(bean.getDescription());
        mItemTvTitle.setText(bean.getTitle());
    }
}
