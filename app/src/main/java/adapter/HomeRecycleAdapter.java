package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import model.HomeBean;
import widget.MyRecyclerViewItem;

/**
 * 类    名:  HomeRecycleAdapter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 20:41$
 * 描    述： ${TODO}
 */
public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.MyViewHolder>
{
    private List<HomeBean> mBeanList = new ArrayList<>();
    private Context mContext;
    public HomeRecycleAdapter(Context context)
    {
        mContext = context;
    }

    public HomeRecycleAdapter(Context context, List<HomeBean> homeBeanList)
    {
        mContext = context;
        this.mBeanList = homeBeanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder viewHolder = new MyViewHolder(new MyRecyclerViewItem(mContext));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        HomeBean homeBean = mBeanList.get(position);
        holder.homeViewHolder.bind(homeBean);
    }

    @Override
    public int getItemCount()
    {
        return mBeanList != null ? mBeanList.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private MyRecyclerViewItem homeViewHolder;
        public MyViewHolder(MyRecyclerViewItem itemView)
        {
            super(itemView);
            homeViewHolder = itemView;
        }
    }
}
