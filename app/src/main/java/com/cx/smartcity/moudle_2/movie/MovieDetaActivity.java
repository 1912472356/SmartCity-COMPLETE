package com.cx.smartcity.moudle_2.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.MovieBean;
import com.cx.smartcity.util.SPUtil;

public class MovieDetaActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView score;
    private TextView content;
    private TextView date;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_deta);
        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        score = (TextView) findViewById(R.id.score);
        content = (TextView) findViewById(R.id.content);
        date = (TextView) findViewById(R.id.date);

        desc = (TextView) findViewById(R.id.desc);


        MovieBean.RowsDTO data = (MovieBean.RowsDTO) getIntent().getSerializableExtra("data");
        desc.setText(Html.fromHtml(data.getIntroduction()));

        name.setText(data.getName());
        score.setText(data.getScore()+"分");
        Glide.with(this).load(SPUtil.get(SPUtil.HTTP) + data.getCover())
                .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        content.setText("电影时长"+data.getDuration()+"分钟，"+data.getLikeNum()+"人想看");
        date.setText(data.getPlayDate()+"上映");
    }

    public void back(View view) {
        finish();
    }
}