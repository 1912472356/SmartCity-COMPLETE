package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class YanglaoJIzhongActivity extends AppCompatActivity {
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanglao_j_izhong);
        pieChart = (PieChart) findViewById(R.id.pie_chart);

        pieChart.setDescription(null);
        pieChart.setHoleRadius(0);
        pieChart.setTransparentCircleRadius(0);
        pieChart.setUsePercentValues(true);

        PieData data = new PieData();

        List<PieEntry> list = new ArrayList<>();
        list.add(new PieEntry(10, "40 ~ 50岁"));
        list.add(new PieEntry(20, "50 ~ 60岁"));
        list.add(new PieEntry(20, "60 ~ 70岁"));
        list.add(new PieEntry(20, "70 ~ 80岁"));
        list.add(new PieEntry(20, "80 ~ 90岁"));
        list.add(new PieEntry(10, "90 ~ 100岁"));
        PieDataSet set = new PieDataSet(list, "老人的年龄分布");
        set.setColors(Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.CYAN,Color.DKGRAY);
        data.addDataSet(set);
        pieChart.setData(data);

        pieChart.invalidate();
    }

    public void back(View view) {
        finish();
    }
}