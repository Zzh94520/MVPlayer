package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzh.qqplayer.PlayerActivity;

import java.util.List;

import model.MVListBean;
import widget.MVPageRecyclerViewItem;

/**
 * 类    名:  MVPageAdapter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 17:49$
 * 描    述： ${TODO}
 */
public class MVPageAdapter extends RecyclerView.Adapter<MVPageAdapter.MVPageViewHolder>
{

    private Context mContext;
    private List<MVListBean.VideosBean> mDataList;

    public MVPageAdapter(Context context, List<MVListBean.VideosBean> dataList)
    {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public MVPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MVPageRecyclerViewItem itemView = new MVPageRecyclerViewItem(mContext);
        return new MVPageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MVPageViewHolder holder, int position)
    {
        holder.mViewItem.bind(mDataList.get(position));
        holder.mViewItem.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(mContext,PlayerActivity.class);
            mContext.startActivity(intent);
        }
    };
    @Override
    public int getItemCount()
    {
        return mDataList != null ? mDataList.size() : 0;
    }

    class MVPageViewHolder extends RecyclerView.ViewHolder
    {
        private MVPageRecyclerViewItem mViewItem;
        public MVPageViewHolder(View itemView)
        {
            super(itemView);
            mViewItem = (MVPageRecyclerViewItem) itemView;
        }
    }
}
