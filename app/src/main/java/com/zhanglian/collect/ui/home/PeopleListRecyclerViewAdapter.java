package com.zhanglian.collect.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhanglian.collect.R;
import com.zhanglian.collect.Utils.Utils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PeopleListRecyclerViewAdapter extends RecyclerView.Adapter<PeopleListRecyclerViewAdapter.ViewHolder> {
    private List<PeopleListData> dataList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View dataView;
        TextView dataName;
        TextView dataId;
        TextView dataPhone;

        public ViewHolder(View view) {
            super(view);
            dataView = view;
            dataName = view.findViewById(R.id.tv_title);
            dataId = view.findViewById(R.id.tv_add);
            dataPhone = view.findViewById(R.id.tv_time);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_list_item_recyclerview, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                PeopleListData data = dataList.get(position);
                if (Utils.isFastClick()) {
                    Intent intent = new Intent(view.getContext(), PeopleAdd.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PeopleListData item = dataList.get(position);
        String aa= item.getName();

        holder.dataName.setText(item.getName());
        holder.dataId.setText(item.getId());
        holder.dataPhone.setText(item.getPhone());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public PeopleListRecyclerViewAdapter(List<PeopleListData> mdataList) {
        dataList = mdataList;
    }


}
