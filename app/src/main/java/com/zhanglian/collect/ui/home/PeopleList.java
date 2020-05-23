package com.zhanglian.collect.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.zhanglian.collect.MainActivity;
import com.zhanglian.collect.R;

import java.util.ArrayList;
import java.util.List;

public class PeopleList extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<PeopleListData> dataList = new ArrayList<>();
    PeopleListRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);
        //系统标题栏隐藏
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null) actionbar.hide();
        //getWindow().addFlags(WindowManager.LayoutParams.ALPHA_CHANGED);//隐藏状态栏
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        recyclerview =(RecyclerView) this.findViewById(R.id.People_list_recycler_view);
        initData();

        PeopleListRecyclerViewAdapter adapter = new PeopleListRecyclerViewAdapter(dataList);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerview.scrollToPosition(0); //默认滚动到哪一条
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
    public void goBackHomeDetails(View view){
        finish();
    }

    public void goPeopleAdd(View view){
        Intent intent = new Intent(this, PeopleAdd.class);
        view.getContext().startActivity(intent);
    }
    private void initData() {
        PeopleListData data0 = new PeopleListData("王刚", "533001199510120300","18582381066");
        dataList.add(data0);
        PeopleListData data1 = new PeopleListData("李茂",  "533001199510120300","18582381066");
        dataList.add(data1);
        PeopleListData data2 = new PeopleListData("王遂",  "533001199510120300","18582381066");
        dataList.add(data2);
    }

}
