package com.cx.smartcity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.NewsDetailBean;
import com.cx.smartcity.bean.VolunNewsDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class NewsDetailActivity extends AppCompatActivity {
    private TextView name;
    private ImageView img;
    private TextView content;
    private TextView comment;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        int id = getIntent().getIntExtra("id", 11);
        int type = getIntent().getIntExtra("type", 0);

        name = (TextView) findViewById(R.id.name);
        img = (ImageView) findViewById(R.id.img);
        content = (TextView) findViewById(R.id.content);
        comment = (TextView) findViewById(R.id.comment);
        date = (TextView) findViewById(R.id.date);

        if(type == 0) {
            RetrofitUtil.get("/prod-api/press/press/" + id, new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    NewsDetailBean.DataDTO data = new Gson().fromJson(json, NewsDetailBean.class).getData();
                    name.setText(data.getTitle());
                    Glide.with(NewsDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + data.getCover())
                            .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
                    content.setText(Html.fromHtml(data.getContent()));
                    comment.setText(data.getCommentNum() + "条评论");
                    date.setText(data.getPublishDate() + "发布");
                }
            });
        }else {
            RetrofitUtil.get("/prod-api/api/volunteer-service/news/"+id, new RetrofitUtil.OnRequest() {
                @Override
                public void onRequest(String json) {
                    VolunNewsDetailBean.DataDTO data = new Gson().fromJson(json, VolunNewsDetailBean.class).getData();

                    name.setText(data.getTitle());
                    Glide.with(NewsDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                            .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
                    content.setText(Html.fromHtml(data.getContent()));
                    comment.setVisibility(View.GONE);
                    date.setText(data.getCreateTime() + "发布");
                }
            });
        }
    }

    public void back(View view) {
        finish();
    }
}