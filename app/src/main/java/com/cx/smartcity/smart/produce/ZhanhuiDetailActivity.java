package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;

public class ZhanhuiDetailActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhanhui_detail);
        title = (TextView) findViewById(R.id.title);

        String name = getIntent().getStringExtra("name");
        title.setText(name);
    }

    public void back(View view) {
        finish();
    }
}