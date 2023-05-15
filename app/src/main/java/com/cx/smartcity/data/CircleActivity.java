package com.cx.smartcity.data;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleActivity extends AppCompatActivity {
    private PieChart chart;
    String titles[] = {
            "标题1","标题2","标题3",
            "标题4","标题5","标题6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        chart = (PieChart) findViewById(R.id.chart);

        initAxis();
        initData();
    }
    private void initAxis() {
        chart.setUsePercentValues(true);
        chart.setCenterText("环形图");
        chart.setCenterTextSize(18);
    }

    private void initData() {
        PieData data = new PieData();
        List<PieEntry> list = new ArrayList<>();
        for (String row : titles) {
            list.add(new PieEntry(new Random().nextInt(10), row));
        }
        PieDataSet set = new PieDataSet(list, "数据");
        set.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.format("%.2f", Double.parseDouble(super.getFormattedValue(value, axis) ))+ "%";
            }

            @Override
            public String getFormattedValue(float value) {
                return String.format("%.2f", Double.parseDouble(super.getFormattedValue(value) ))+ "%";
            }
        });
        set.setColors(Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN,Color.CYAN);
        data.addDataSet(set);
        chart.setData(data);
    }

    public void back(View view) {
        finish();
    }
}