package com.cx.smartcity.smart.relief;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.FupingBean;

public class FupingDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView content;
    private TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuping_detail);

        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        date = (TextView) findViewById(R.id.date);

        FupingBean data = (FupingBean) getIntent().getSerializableExtra("data");

        if (data.getImg() == null) {
            if (data.getPath() == null) {
                img.setVisibility(View.GONE);
            }else {
                Glide.with(this).load(BitmapFactory.decodeFile(data.getPath()))
                        .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
            }
        }else{
            Glide.with(this).load(data.getImg())
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        }
        name.setText(data.getTitle());
        content.setText(data.getContent());
        date.setText(data.getDate()+"发布");

    }

    public void back(View view) {
        finish();
    }
}