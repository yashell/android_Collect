package com.zhanglian.collect.ui.news;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhanglian.collect.R;
import com.zhanglian.collect.Utils.Utils;
import com.zhanglian.collect.ui.home.HomeData;
import com.zhanglian.collect.ui.home.HomeDetails;
import com.zhanglian.collect.ui.home.HomeList;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {
    private List<NewsData> dataList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View dataView;
        ImageView dataImage;
        TextView dataName;
        TextView dataIdentity;
        TextView dataTask;
        TextView dataAdd;
        TextView dataTime;

        public ViewHolder(View view) {
            super(view);
            dataView = view;
            dataImage = view.findViewById(R.id.tv_icon);
            dataName = view.findViewById(R.id.tv_title);

            dataIdentity = view.findViewById(R.id.tv_identity);
            dataTask = view.findViewById(R.id.tv_task);
            dataAdd = view.findViewById(R.id.tv_add);
            dataTime = view.findViewById(R.id.tv_time);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item_recyclerview, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                NewsData fruit = dataList.get(position);
                // 原型预警的列表是任务的，虽然我写了NewsList,但这里还是跳转HomeList
                if (Utils.isFastClick()) {
                    Intent intent = new Intent(view.getContext(), HomeDetails.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
        holder.dataImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                NewsData fruit = dataList.get(position);
                Toast.makeText(view.getContext(), "你点击了图片"+ fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsData item = dataList.get(position);

        switch (item.getStatus()){
            case 0:
                holder.dataImage.setImageResource(R.drawable.news_status0);
                break;
            case 1:
                holder.dataImage.setImageResource(R.drawable.news_status1);
                break;
            case 2:
                holder.dataImage.setImageResource(R.drawable.news_status2);
                break;
            case 3:
                holder.dataImage.setImageResource(R.drawable.news_status3);
                break;
            case 4:
                holder.dataImage.setImageResource(R.drawable.news_status4);
                break;
        }



        holder.dataName.setText(item.getName());
        holder.dataIdentity.setText(item.getIdentity());
        holder.dataTask.setText(item.getTask());
        holder.dataAdd.setText(item.getAdd());
        holder.dataTime.setText(item.getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public NewsRecyclerViewAdapter(List<NewsData> mdataList) {
        dataList = mdataList;
    }


}
