package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;

public class NoticeActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        int id = getIntent().getIntExtra("id", 11);
        title = (TextView) findViewById(R.id.title);

        if (id % 2 == 0) {
            title.setText("物业通知-" + (id/2 + 1));
        }
    }

    public void back(View view) {
        finish();
    }
}