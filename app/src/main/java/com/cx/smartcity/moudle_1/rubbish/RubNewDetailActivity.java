package com.cx.smartcity.moudle_1.rubbish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.RubNewsDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class RubNewDetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView author;
    private TextView date;
    private TextView desc;
    private EditText searchEt;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rub_new_detail);

        title = (TextView) findViewById(R.id.title);
        author = (TextView) findViewById(R.id.author);
        date = (TextView) findViewById(R.id.date);
        desc = (TextView) findViewById(R.id.desc);
        searchEt = (EditText) findViewById(R.id.search_et);
        img = (ImageView) findViewById(R.id.img);


        int id = getIntent().getIntExtra("id", 11);
        RetrofitUtil.get("/prod-api/api/garbage-classification/news/"+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                RubNewsDetailBean.DataDTO data = new Gson().fromJson(json, RubNewsDetailBean.class).getData();

                title.setText(data.getTitle());
                date.setText(data.getCreateTime()+"发布");
                Glide.with(RubNewDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                        .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(img);
                author.setText(data.getAuthor());
                desc.setText(Html.fromHtml(data.getContent()));
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void comment(View view) {
        searchEt.setText("");
        Toast.makeText(this, "匿名评论成功", Toast.LENGTH_SHORT).show();
    }
}