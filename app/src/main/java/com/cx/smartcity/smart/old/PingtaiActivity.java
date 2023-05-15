package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;

public class PingtaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pingtai);
    }

    public void back(View view) {
        finish();
    }
}