package com.zhanglian.collect.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.zhanglian.collect.MainActivity;
import com.zhanglian.collect.R;

public class PeopleList extends AppCompatActivity {

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
    }
    public void goBackHomeDetails(View view){
        Intent intent = new Intent(this, HomeDetails.class);
        view.getContext().startActivity(intent);
        finish();
    }

}
