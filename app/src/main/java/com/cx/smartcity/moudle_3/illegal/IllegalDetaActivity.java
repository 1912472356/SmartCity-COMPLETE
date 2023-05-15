package com.cx.smartcity.moudle_3.illegal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.IllegalBean;

public class IllegalDetaActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illegal_deta);
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);

        IllegalBean.RowsDTO data = (IllegalBean.RowsDTO) getIntent().getSerializableExtra("data");
        title.setText(data.getLicencePlate());
        content.setText("违法时间："+data.getBadTime()
                +"\n违法地点："+data.getIllegalSites()
                +"\n违法行为："+data.getTrafficOffence()
                +"\n通知书号："+data.getNoticeNo()
                +"\n违章记分："+data.getDeductMarks()
                +"分\n罚款金额："+data.getMoney()+"元"
                +"");
    }

    public void back(View view) {
        finish();
    }
}