package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;

public class TuiguangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuiguang);
    }

    public void back(View view) {
        finish();
    }
}