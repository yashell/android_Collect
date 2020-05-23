package com.zhanglian.collect.ui.news;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhanglian.collect.R;
import com.zhanglian.collect.ui.home.HomeData;
import com.zhanglian.collect.ui.home.HomeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;
    private RecyclerView recyclerview;
    private List<NewsData> dataList = new ArrayList<>();
    NewsRecyclerViewAdapter adapter;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        root = inflater.inflate(R.layout.fragment_news, container, false);
        newsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        recyclerview =(RecyclerView) root.findViewById(R.id.home_recycler_view);


        EditText sendText = root.findViewById(R.id.home_search);//初始化文本

        Drawable right=getResources().getDrawable(R.drawable.search);
        right.setBounds(0,0,70,70);//必须设置图片的大小否则没有作用
        sendText.setCompoundDrawables(null,null ,right,null);//设置图片left这里如果是右边就放到第二个参数里面依次对应


        initData();

        NewsRecyclerViewAdapter adapter = new NewsRecyclerViewAdapter(dataList);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(root.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerview.scrollToPosition(0); //默认滚动到哪一条
        recyclerview.addItemDecoration(new DividerItemDecoration(root.getContext(),DividerItemDecoration.VERTICAL));


        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("刷新数据1", "onResume: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        // TODO Auto-generated method stub
        super.onHiddenChanged(hidden);
        if (root != null && !hidden) {
            Log.d("刷新数据2", "onResume: ");
        }
    }

    private void initData() {
        for(int i = 0; i < 10; i++) {
            NewsData dataA = new NewsData("孙阳",0,"533001199001120390","电动车行业门店采集","云南省昆明市盘龙区北京路411号","2020-05-21 19:51:02");
            dataList.add(dataA);
            NewsData dataB = new NewsData("王刚"+ i,1,"533001199001120390","电动车行业门店采集","云南省昆明市盘龙区北京路411号","2020-05-21 19:51:02");
            dataList.add(dataB);
        }
    }
}
