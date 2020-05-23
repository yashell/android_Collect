package com.zhanglian.collect.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.zhanglian.collect.MainActivity;
import com.zhanglian.collect.R;

import java.util.ArrayList;
import java.util.List;

public class HomeList extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<HomeListData> dataList = new ArrayList<>();
    HomeListRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);
        //系统标题栏隐藏
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null) actionbar.hide();
        //getWindow().addFlags(WindowManager.LayoutParams.ALPHA_CHANGED);//隐藏状态栏
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        Intent intent=getIntent();
        String data1= intent.getStringExtra("parameterA");
        int data2= intent.getIntExtra("parameterB",-1);

        recyclerview =(RecyclerView) this.findViewById(R.id.home_list_recycler_view);
        initData();

        HomeListRecyclerViewAdapter adapter = new HomeListRecyclerViewAdapter(dataList);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerview.scrollToPosition(0); //默认滚动到哪一条
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    public void goback(View view){
        Intent intent = new Intent(this,MainActivity.class);
        view.getContext().startActivity(intent);
        finish();
    }

    private void initData() {
        HomeListData data0 = new HomeListData("雅迪电动车专卖店", "云南省昆明市盘龙区北京路411号","2020-05-21 19:51:02");
        dataList.add(data0);
        HomeListData data1 = new HomeListData("小牛电动车专卖店",  "云南省昆明市盘龙区北京路411号","2020-05-21 19:51:02");
        dataList.add(data1);
        HomeListData data2 = new HomeListData("新日电动车专卖店",  "云南省昆明市盘龙区北京路411号","2020-05-21 19:51:02");
        dataList.add(data2);
    }
}
