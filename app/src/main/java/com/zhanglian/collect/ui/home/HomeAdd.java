package com.zhanglian.collect.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.zhanglian.collect.R;

public class HomeAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_add);
        //系统标题栏隐藏
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null) actionbar.hide();
        //getWindow().addFlags(WindowManager.LayoutParams.ALPHA_CHANGED);//隐藏状态栏
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    public void goBackHomeDetails2(View view){
        finish();
    }
    public void homeSure(View view){
        finish();
    }
    public void goAct(View view){
        Intent intent = new Intent();
        intent.setClass(this,PeopleAdd.class);
        startActivity(intent);
    }
}
