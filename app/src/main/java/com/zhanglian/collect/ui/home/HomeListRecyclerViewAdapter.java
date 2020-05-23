package com.zhanglian.collect.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhanglian.collect.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class HomeListRecyclerViewAdapter extends RecyclerView.Adapter<HomeListRecyclerViewAdapter.ViewHolder> {
    private List<HomeListData> dataList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View dataView;
        TextView dataName;
        TextView dataAdd;
        TextView dataTime;

        public ViewHolder(View view) {
            super(view);
            dataView = view;
            dataName = view.findViewById(R.id.tv_title);
            dataAdd = view.findViewById(R.id.tv_add);
            dataTime = view.findViewById(R.id.tv_time);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list_item_recyclerview, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                HomeListData data = dataList.get(position);
                Intent intent = new Intent(view.getContext(),HomeDetails.class);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeListData item = dataList.get(position);
        holder.dataName.setText(item.getName());
        holder.dataAdd.setText(item.getAdd());
        holder.dataTime.setText(item.getTime());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public HomeListRecyclerViewAdapter(List<HomeListData> mdataList) {
        dataList = mdataList;
    }


}
