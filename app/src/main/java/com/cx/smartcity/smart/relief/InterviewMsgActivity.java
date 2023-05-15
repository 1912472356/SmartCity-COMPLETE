package com.cx.smartcity.smart.relief;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.cx.smartcity.R;

public class InterviewMsgActivity extends AppCompatActivity {
    private EditText date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_msg);
        date = (EditText) findViewById(R.id.date);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(InterviewMsgActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date.setText(i+"-"+(i1+1)+"-"+i2);
                    }
                }, 2022, 12, 1).show();
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();

        finish();
    }
}