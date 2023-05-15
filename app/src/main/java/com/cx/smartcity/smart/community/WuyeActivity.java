package com.cx.smartcity.smart.community;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.person.FeedbackActivity;

public class WuyeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wuye);
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        startActivity(new Intent(this, FeedbackActivity.class));
    }
}