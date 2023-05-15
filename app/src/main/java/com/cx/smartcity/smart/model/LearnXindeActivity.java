package com.cx.smartcity.smart.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;

public class LearnXindeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_xinde);
    }

    public void back(View view) {
        finish();
    }
}