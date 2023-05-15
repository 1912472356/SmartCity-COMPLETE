package com.cx.smartcity.person;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.OrderBean;

public class OrderDetailActivity extends AppCompatActivity {
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        content = (TextView) findViewById(R.id.content);

        OrderBean.RowsDTO data = (OrderBean.RowsDTO) getIntent().getSerializableExtra("data");
        content.setText("订单号："+data.getOrderNo()
                +"\n订单价格：￥"+data.getAmount()+"元"
                +"\n商家："+data.getName()
                +"\n订单类型："+data.getOrderTypeName()
                +"\n订单创建日期："+data.getCreateTime()
                +"\n订单状态："+data.getOrderStatus());
    }

    public void back(View view) {
        finish();
    }
}