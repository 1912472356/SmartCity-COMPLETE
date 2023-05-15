package com.cx.smartcity.moudle_2.volunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.VolunBean;

public class VolunDetaActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volun_deta);
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        desc = (TextView) findViewById(R.id.desc);

        VolunBean.RowsDTO data = (VolunBean.RowsDTO) getIntent().getSerializableExtra("data");
        title.setText(data.getTitle());
        content.setText("承办单位："+data.getUndertaker()+"\n活动开始时间："+data.getStartAt()+"\n人员要求："+data.getRequireText()+"\n活动简介："+data.getTitle());
        desc.setText("工作内容："+data.getDetail());

    }

    public void back(View view) {
        finish();
    }
}