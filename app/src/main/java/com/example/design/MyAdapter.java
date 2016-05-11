package com.example.design;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bear on 2016/5/11.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Actor> actors;
    private Context mContext;

    public MyAdapter( Context mContext,List<Actor> actors) {
        this.mContext = mContext;
        this.actors = actors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //给ViewHolder设置布局文件
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(v);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //给Viewholder设置元素
        Actor p=actors.get(position);
        holder.mTextView.setText(p.name);
        holder.mImageView.setImageDrawable(mContext.getDrawable(p.getImageResourceId(mContext)));


    }

    @Override
    public int getItemCount() {
        //返回数据的总数
        return actors == null ? 0 : actors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView.findViewById(R.id.name);
            mImageView= (ImageView) itemView.findViewById(R.id.pic);
        }
    }
}
