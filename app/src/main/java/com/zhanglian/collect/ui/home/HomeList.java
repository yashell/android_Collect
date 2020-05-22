package com.zhanglian.collect.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.zhanglian.collect.R;

public class HomeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);
        Intent intent=getIntent();
        String data1= intent.getStringExtra("parameterA");
        int data2= intent.getIntExtra("parameterB",-1);
    }
}
