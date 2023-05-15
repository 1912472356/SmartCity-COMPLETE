package com.cx.smartcity.moudle_1.house;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.HouseBean;
import com.cx.smartcity.util.SPUtil;

public class HouseDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView price;
    private TextView content;
    private TextView type;
    private TextView area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        content = (TextView) findViewById(R.id.content);
        type = (TextView) findViewById(R.id.type);
        area = (TextView) findViewById(R.id.area);

        HouseBean.RowsDTO data = (HouseBean.RowsDTO) getIntent().getSerializableExtra("data");

        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getPic())
                .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        name.setText(data.getSourceName());
        price.setText(data.getPrice());
        content.setText(data.getDescription());
        area.setText("房源面积："+data.getAreaSize()+"㎡");
        type.setText("房源类型："+data.getHouseType());

    }

    public void back(View view) {
        finish();
    }
}