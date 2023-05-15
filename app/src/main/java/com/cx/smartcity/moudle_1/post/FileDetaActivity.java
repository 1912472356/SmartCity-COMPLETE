package com.cx.smartcity.moudle_1.post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.FileDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

public class FileDetaActivity extends AppCompatActivity {
    private TextView name;
    private TextView author;
    private TextView date;
    private TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_deta);
        int id = getIntent().getIntExtra("id", 11);

        name = (TextView) findViewById(R.id.name);
        author = (TextView) findViewById(R.id.author);
        date = (TextView) findViewById(R.id.date);
        content = (TextView) findViewById(R.id.content);

        RetrofitUtil.get("/prod-api/api/youth-inn/talent-policy/"+id, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                FileDetailBean.DataDTO data = new Gson().fromJson(json, FileDetailBean.class).getData();
                name.setText(data.getTitle());
                author.setText(data.getAuthor());
                date.setText(data.getCreateTime()+"发布");
                content.setText(Html.fromHtml(data.getContent()));
            }
        });
    }

    public void back(View view) {
        finish();
    }
}