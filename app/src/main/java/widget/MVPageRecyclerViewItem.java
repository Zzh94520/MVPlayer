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
import model.MVListBean;

/**
 * 类    名:  MVPageRecyclerViewItem
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 19:26$
 * 描    述： ${TODO}
 */

public class MVPageRecyclerViewItem extends RelativeLayout
{
    @BindView(R.id.home_recycler)
    ImageView mHomeRecycler;
    @BindView(R.id.mv_page_title)
    TextView  mMvPageTitle;
    @BindView(R.id.mv_page_name)
    TextView  mMvPageName;

    public MVPageRecyclerViewItem(Context context)
    {
        this(context,null);
    }

    public MVPageRecyclerViewItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_page_mv, this);
        ButterKnife.bind(inflate);
    }

    public void bind(MVListBean.VideosBean bean)
    {
        mMvPageTitle.setText(bean.getTitle());
        mMvPageName.setText(bean.getArtistName());
        Glide.with(getContext()).load(bean.getAlbumImg()).into(mHomeRecycler);
    }
}
