package com.cx.smartcity.moudle_1.park;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ParkBean;

public class ParkDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_detail);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);

        ParkBean.RowsDTO data = (ParkBean.RowsDTO) getIntent().getSerializableExtra("data");
        title.setText(data.getParkName());
        content.setText("地址："+data.getAddress()
                +"\n距离："+data.getDistance()+"米"
                +"\n是否对外开放："+(data.getOpen().equals("Y") ? "对外开放":"不对外开放")
                +"\n每小时"+data.getRates()+"元，最高"+data.getPriceCaps()+"元／天：");
    }

    public void back(View view) {
        finish();
    }
}