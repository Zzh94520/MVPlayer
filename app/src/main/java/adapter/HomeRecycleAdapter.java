package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import widget.MyRecyclerViewItem;

/**
 * 类    名:  HomeRecycleAdapter
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/15
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/15: 20:41$
 * 描    述： ${TODO}
 */
public class HomeRecycleAdapter extends RecyclerView.Adapter
{
    private Context mContext;
    public HomeRecycleAdapter(Context context)
    {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder viewHolder = new MyViewHolder(new MyRecyclerViewItem(mContext));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        public MyViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
