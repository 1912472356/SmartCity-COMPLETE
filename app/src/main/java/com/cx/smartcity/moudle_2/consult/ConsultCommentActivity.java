package com.cx.smartcity.moudle_2.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cx.smartcity.R;

public class ConsultCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_comment);
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        Toast.makeText(this, "评价成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}