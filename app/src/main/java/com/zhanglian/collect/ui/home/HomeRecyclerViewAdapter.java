package com.zhanglian.collect.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhanglian.collect.MainActivity;
import com.zhanglian.collect.R;
import com.zhanglian.collect.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;


public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    private List<HomeData> dataList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View dataView;
        ImageView dataImage;
        TextView dataName;
        int dataStatus;
        TextView dataTime;

        public ViewHolder(View view) {
            super(view);
            dataView = view;
            dataImage = view.findViewById(R.id.tv_icon);
            dataName = view.findViewById(R.id.tv_title);
            dataTime = view.findViewById(R.id.tv_time);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item_recyclerview, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                HomeData data = dataList.get(position); // data 为当前数据
                if (Utils.isFastClick()) {
                    Intent intent = new Intent(view.getContext(),HomeList.class);
                    view.getContext().startActivity(intent);
                }
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeData item = dataList.get(position);

        if(item.getStatus() == 0){
            holder.dataImage.setImageResource(R.drawable.status0);
        } else{
            holder.dataImage.setImageResource(R.drawable.status1);
        }

        holder.dataName.setText(item.getName());
        holder.dataTime.setText(item.getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public HomeRecyclerViewAdapter(List<HomeData> mdataList) {
        dataList = mdataList;
    }


}
