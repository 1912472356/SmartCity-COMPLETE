package com.cx.smartcity.moudle_1.gover;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.AppealBean;
import com.cx.smartcity.util.SPUtil;

public class AppealDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView content;
    private TextView date;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeal_detail);
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        content = (TextView) findViewById(R.id.content);
        date = (TextView) findViewById(R.id.date);
        desc = (TextView) findViewById(R.id.desc);


        AppealBean.RowsDTO data = (AppealBean.RowsDTO) getIntent().getSerializableExtra("data");
        if (data.getImgUrl().contains("/prod-api") ||data.getImgUrl().contains("/dev-api") || data.getImgUrl().contains("/profile")) {
            Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        }else {
            Glide.with(this).load(BitmapFactory.decodeFile(data.getImgUrl()))
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        }
        name.setText(data.getTitle());
        date.setText(data.getCreateTime() + "提交");
        desc.setText("诉求内容：" + data.getContent());
        content.setText("承办单位：" + data.getUndertaker()
                + "\n反馈处理状态：" + (data.getState().equals("0") ? "未完结" : "已完结")
                + "\n处理结果：" + data.getDetailResult());
    }

    public void back(View view) {
        finish();
    }
}