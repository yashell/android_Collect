package com.zhanglian.collect.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhanglian.collect.R;

import java.util.ArrayList;
import java.util.List;


public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    private List<HomeData> mFruitList;

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
                HomeData fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), "你点击了View"+ fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.dataImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                HomeData fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(), "你点击了图片"+ fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeData item = mFruitList.get(position);

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
        return mFruitList.size();
    }

    public HomeRecyclerViewAdapter(List<HomeData> fruitList) {
        mFruitList = fruitList;
    }


}
