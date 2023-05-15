package com.cx.smartcity.smart.produce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.R;

public class FacEmployActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac_employ);
    }

    public void back(View view) {
        finish();
    }
}