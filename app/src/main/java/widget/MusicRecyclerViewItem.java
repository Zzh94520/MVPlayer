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
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import model.MusicListBean;

/**
 * 类    名:  MyRecyclerViewItem
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 21:05$
 * 描    述： ${TODO}
 */

public class MusicRecyclerViewItem extends RelativeLayout
{
    @BindView(R.id.music_list_recycler)
    ImageView mMusicListRecycler;
    @BindView(R.id.item_avatar)
    ImageView mItemAvatar;
    @BindView(R.id.item_tv_title)
    TextView  mItemTvTitle;
    @BindView(R.id.item_description)
    TextView  mItemDescription;
    @BindView(R.id.item_count)
    TextView  mItemCount;

    private static final String TAG = "MusicRecyclerViewItem";

    public MusicRecyclerViewItem(Context context)
    {
        this(context, null);
    }

    public MusicRecyclerViewItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    private void init(Context context)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music_list, this);
        ButterKnife.bind(this, view);
    }

    public void bind(MusicListBean.PlayListsBean bean)
    {
        Glide.with(getContext())
             .load(bean.getPlayListBigPic())
             .centerCrop()
             .into(mMusicListRecycler);
        mItemDescription.setText(bean.getCreator().getNickName());
        mItemTvTitle.setText(bean.getTitle());
        String s = String.format("%d首", bean.getVideoCount());
        mItemCount.setText(s);
        Glide.with(getContext())
             .load(bean.getCreator().getLargeAvatar())
             .bitmapTransform(new CropCircleTransformation(getContext()))
             .into(mItemAvatar);
    }
}
