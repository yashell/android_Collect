package com.zhanglian.collect.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhanglian.collect.MainActivity;
import com.zhanglian.collect.R;
import com.zhanglian.collect.ui.news.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerview;
    private List<HomeData> dataList = new ArrayList<>();
    HomeRecyclerViewAdapter adapter;
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerview =(RecyclerView) root.findViewById(R.id.home_recycler_view);
        final TextView textview =(TextView) root.findViewById(R.id.text_home);
        String aa = "fsadfadsfasd";
        textview.setText(aa);

        initData();

        HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(dataList);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(root.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerview.scrollToPosition(0); //默认滚动到哪一条
        recyclerview.addItemDecoration(new DividerItemDecoration(root.getContext(),DividerItemDecoration.VERTICAL));

        return root;
    }
    private void initData() {
        for(int i = 0; i < 10; i++) {
            HomeData apple = new HomeData("电动车行业门店采集", R.drawable.titlebg,0,"2020-05-21 19:51:02");
            dataList.add(apple);
            HomeData banana = new HomeData("banana"+ i,  R.drawable.titlebg,1,"2020-05-21 19:51:02");
            dataList.add(banana);
        }
    }
}
