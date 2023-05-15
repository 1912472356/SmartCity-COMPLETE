package com.cx.smartcity.smart.old;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.YanglaoBean;

public class YanglaoDetaActivity extends AppCompatActivity {
    private TextView name;
    private ImageView img;
    private TextView content;
    private Button comment;
    private Button subBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yanglao_deta);

        name = (TextView) findViewById(R.id.name);
        img = (ImageView) findViewById(R.id.img);
        content = (TextView) findViewById(R.id.content);
        comment = (Button) findViewById(R.id.comment);
        subBtn = (Button) findViewById(R.id.sub_btn);

        YanglaoBean data = (YanglaoBean) getIntent().getSerializableExtra("data");

        name.setText(data.getName());
        content.setText(data.getContent());
        Glide.with(YanglaoDetaActivity.this).load(data.getImg())
                .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new YanglaoCommentDialog(YanglaoDetaActivity.this).show();
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YanglaoDetaActivity.this, "预约成功", Toast.LENGTH_SHORT).show();
                subBtn.setClickable(false);
                subBtn.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC);
            }
        });

    }

    public void back(View view) {
        finish();
    }
}