package com.cx.smartcity.data;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BarActivity extends AppCompatActivity {
    private BarChart chart;
    String titles[] = {
            "标题1","标题2","标题3",
            "标题4","标题5","标题6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        chart = (BarChart) findViewById(R.id.chart);

        initAxis();
        initData();
    }

    private void initData() {
        BarData data = new BarData();
        List<BarEntry> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            list.add(new BarEntry(i, new Random().nextInt(200)));
        }
        BarDataSet set = new BarDataSet(list, "数据1");
        set.setColor(Color.RED);

        List<BarEntry> list2 = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            list2.add(new BarEntry(i, new Random().nextInt(200)));
        }
        BarDataSet set2 = new BarDataSet(list2, "数据2");
        set2.setColor(Color.BLUE);

        data.addDataSet(set);
        data.addDataSet(set2);
        data.setBarWidth(0.35f);
        data.groupBars(0, 0.25f,0);

        chart.setData(data);
        chart.invalidate();
    }

    private void initAxis() {
        XAxis xAxis = chart.getXAxis();
        chart.getAxisRight().setEnabled(false);
        chart.setDescription(null);
        chart.getAxisLeft().setAxisMinimum(0);
        xAxis.setCenterAxisLabels(true);
        xAxis.setLabelCount(6);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if (value == -1 || value == 6) {
                    return  "";
                }
                return titles[(int) value];
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    }

    public void back(View view) {
        finish();
    }
}