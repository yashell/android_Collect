package com.zhanglian.collect.ui.user;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.zhanglian.collect.R;
import com.zhanglian.collect.chart.MyValueFormatter;
import com.zhanglian.collect.chart.ValueFormatter;

import java.util.ArrayList;

public class UserFragment extends Fragment {

    private UserViewModel userViewModel;
    private BarChart chart;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        //final TextView textView = root.findViewById(R.id.text_user);
        userViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        chart = root.findViewById(R.id.myChart);
        initChart();
        return root;
    }
    public void initChart(){
        //背景颜色
        chart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        chart.getDescription().setEnabled(false);

        //设置最大值条目，超出之后不会有值
        chart.setMaxVisibleValueCount(60);

        //分别在x轴和y轴上进行缩放
        chart.setPinchZoom(true);
        //设置剩余统计图的阴影
        chart.setDrawBarShadow(false);
        //设置网格布局
        chart.setDrawGridBackground(false);
        //通过自定义一个x轴标签来实现2,015 有分割符符bug
        ValueFormatter custom = new MyValueFormatter(" ");
        //获取x轴线
        XAxis xAxis = chart.getXAxis();

        //设置x轴的显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置网格布局
        xAxis.setDrawGridLines(true);
        //图表将避免第一个和最后一个标签条目被减掉在图表或屏幕的边缘
        xAxis.setAvoidFirstLastClipping(true);
        //绘制标签  指x轴上的对应数值 默认true
        xAxis.setDrawLabels(true);
        xAxis.setValueFormatter(custom);
        //缩放后x 轴数据重叠问题
        xAxis.setGranularityEnabled(true);

        // X轴那条线
        xAxis.setDrawAxisLine(true);
        //获取右边y标签
        YAxis axisRight = chart.getAxisRight();
        axisRight.setStartAtZero(false);
        axisRight.setDrawAxisLine(false);
        axisRight.setEnabled(false);
        //获取左边y轴的标签
        YAxis axisLeft = chart.getAxisLeft();
        //设置Y轴数值 从零开始
        axisLeft.setStartAtZero(true);
        // Y轴左边那条线
        axisLeft.setDrawAxisLine(true);

        //不显示X轴网格线
        xAxis.setDrawGridLines(false);
        //右侧Y轴网格线设置为虚线
        axisRight.enableGridDashedLine(10f, 10f, 0f);
        axisRight.setDrawGridLines(false);

        chart.getAxisLeft().setDrawGridLines(false);
        //设置动画时间
        chart.animateXY(600,600);

        // 显示图例
        chart.getLegend().setEnabled(false);
        Legend legend = chart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        getData();
        //设置柱形统计图上的值
        chart.getData().setValueTextSize(10);
        for (IDataSet set : chart.getData().getDataSets()){
            set.setDrawValues(!set.isDrawValuesEnabled());
        }
    }

    public void getData(){
        ArrayList<BarEntry> values = new ArrayList<>();
        BarEntry barEntry = new BarEntry(Float.valueOf("1"),Float.valueOf("15"));
        BarEntry barEntry1 = new BarEntry(Float.valueOf("2"),Float.valueOf("9"));
        BarEntry barEntry2 = new BarEntry(Float.valueOf("3"),Float.valueOf("17"));
        BarEntry barEntry3 = new BarEntry(Float.valueOf("4"),Float.valueOf("12"));
        BarEntry barEntry4 = new BarEntry(Float.valueOf("5"),Float.valueOf("3"));
        BarEntry barEntry5 = new BarEntry(Float.valueOf("6"),Float.valueOf("13"));
        BarEntry barEntry6 = new BarEntry(Float.valueOf("7"),Float.valueOf("14"));
        BarEntry barEntry7 = new BarEntry(Float.valueOf("8"),Float.valueOf("17"));
        BarEntry barEntry8 = new BarEntry(Float.valueOf("9"),Float.valueOf("12"));
        BarEntry barEntry9 = new BarEntry(Float.valueOf("10"),Float.valueOf("6"));
        BarEntry barEntry10 = new BarEntry(Float.valueOf("11"),Float.valueOf("2"));
        BarEntry barEntry11 = new BarEntry(Float.valueOf("12"),Float.valueOf("10"));
        values.add(barEntry);
        values.add(barEntry1);
        values.add(barEntry2);
        values.add(barEntry3);
        values.add(barEntry4);
        values.add(barEntry5);
        values.add(barEntry6);
        values.add(barEntry7);
        values.add(barEntry8);
        values.add(barEntry9);
        values.add(barEntry10);
        values.add(barEntry11);
        BarDataSet set1;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(values, " ");
            //set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
            // 柱状图设置为单一颜色
            set1.setColors(Color.parseColor("#199ed8"));
            set1.setDrawValues(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            chart.setData(data);

            chart.setFitBars(true);
        }
        //绘制图表
        chart.invalidate();

    }
}
