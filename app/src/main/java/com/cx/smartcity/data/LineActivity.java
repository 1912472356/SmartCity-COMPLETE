package com.cx.smartcity.data;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineActivity extends AppCompatActivity {
    private LineChart chart;
    String titles[] = {
            "标题1","标题2","标题3",
            "标题4","标题5","标题6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        chart = (LineChart) findViewById(R.id.chart);

        initAxis();
        initData();
    }

    private void initData() {
        LineData data = new LineData();
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            list.add(new BarEntry(i, new Random().nextInt(200)));
        }
        LineDataSet set = new LineDataSet(list, "数据");

        data.addDataSet(set);
        chart.setData(data);
        chart.invalidate();
    }

    private void initAxis() {
        XAxis xAxis = chart.getXAxis();
        chart.getAxisRight().setEnabled(false);
        chart.setDescription(null);
        xAxis.setLabelCount(titles.length);
        xAxis.setAxisMinimum(0);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return titles[(int) value];
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);

        xAxis.setLabelRotationAngle(-70);
    }

    public void back(View view) {
        finish();
    }
}