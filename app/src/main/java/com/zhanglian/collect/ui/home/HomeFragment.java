package com.zhanglian.collect.ui.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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

        EditText editText = (EditText) root.findViewById(R.id.home_search);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //点击搜索的时候隐藏软键盘
                    hideKeyboard(root);
                    // 在这里写搜索的操作,一般都是网络请求数据
                    Toast.makeText(root.getContext(), "执行了搜索", Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }
        });





        EditText sendText = root.findViewById(R.id.home_search);//初始化文本

        Drawable right=getResources().getDrawable(R.drawable.search);
        right.setBounds(0,0,70,70);//必须设置图片的大小否则没有作用
        sendText.setCompoundDrawables(null,null ,right,null);//设置图片left这里如果是右边就放到第二个参数里面依次对应

        recyclerview =(RecyclerView) root.findViewById(R.id.home_recycler_view);
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
    /**
     * 隐藏软键盘
     * @param view    :一般为EditText
     */
    public void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
