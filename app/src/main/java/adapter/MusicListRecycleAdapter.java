package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import model.MusicListBean;
import widget.MusicRecyclerViewItem;

/**
 * 类    名:  HomeRecycleAdapter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 20:41$
 * 描    述： ${TODO}
 */
public class MusicListRecycleAdapter extends RecyclerView.Adapter<MusicListRecycleAdapter.MyViewHolder>
{
    private List<MusicListBean.PlayListsBean> mBeanList = new ArrayList<>();
    private Context mContext;
    public MusicListRecycleAdapter(Context context)
    {
        mContext = context;
    }

    public MusicListRecycleAdapter(Context context, List<MusicListBean.PlayListsBean> musicListBeanList)
    {
        mContext = context;
        this.mBeanList = musicListBeanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder viewHolder = new MyViewHolder(new MusicRecyclerViewItem(mContext));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        MusicListBean.PlayListsBean musicListBean = mBeanList.get(position);
        holder.musicListViewHolder.bind(musicListBean);
    }

    @Override
    public int getItemCount()
    {
        return mBeanList != null ? mBeanList.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private MusicRecyclerViewItem musicListViewHolder;
        public MyViewHolder(MusicRecyclerViewItem itemView)
        {
            super(itemView);
            musicListViewHolder = itemView;
        }
    }
}
