package com.zhanglian.collect.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.zhanglian.collect.MainActivity;
import com.zhanglian.collect.R;

public class HomeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details);
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
        TextView textView = (TextView) findViewById(R.id.test);
        textView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(HomeDetails.this,PeopleList.class);
                        startActivity(intent);
                    }
                }
        );


    }

    public void goBackHomeList(View view){
        Intent intent = new Intent(this, HomeList.class);
        view.getContext().startActivity(intent);
        finish();
    }
}
