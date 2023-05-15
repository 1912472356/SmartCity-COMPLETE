package com.cx.smartcity.moudle_1.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;

public class SubResultActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_result);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);

        title.setText(getIntent().getStringExtra("title"));
        content.setText(getIntent().getStringExtra("content"));
    }

    public void back(View view) {
        finish();
    }

    public void home(View view) {
        startActivity(new Intent(this, HospitalActivity.class));
        finish();
    }
}