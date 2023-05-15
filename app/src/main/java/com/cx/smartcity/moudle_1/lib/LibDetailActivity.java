package com.cx.smartcity.moudle_1.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.LibDetailBean;
import com.cx.smartcity.bean.LibraryBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class LibDetailActivity extends AppCompatActivity {
    private ImageView img;
    private TextView name;
    private TextView address;
    private TextView content;

    private ScaleGestureDetector detector;
    private float scale = 1.0f;
    private LibraryBean.RowsDTO data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_detail);

        img = (ImageView) findViewById(R.id.img);
        name = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        content = (TextView) findViewById(R.id.content);

        data = (LibraryBean.RowsDTO) getIntent().getSerializableExtra("data");
        RetrofitUtil.get("/prod-api/api/digital-library/library/"+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                LibDetailBean.DataDTO libData = new Gson().fromJson(json, LibDetailBean.class).getData();
                Glide.with(LibDetailActivity.this).load(SPUtil.get(SPUtil.HTTP) + libData.getMapUrl())
                        .error(R.mipmap.resource).transform(new CenterCrop()).into(img);
                name.setText(libData.getName());
                address.setText(libData.getAddress());
                content.setText("营业时间："+libData.getBusinessHours()
                        +"\n营业状态："+(libData.getBusinessState().equals("0") ?"未营业":"已营业")
                        +"\n图书馆介绍："+libData.getDescription());
            }
        });

        initscale();
    }

    private void initscale() {
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

        detector = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float factor = scaleGestureDetector.getScaleFactor();
                if (factor > 1) {
                    factor = 1.05f;
                }else if(factor<1) {
                    factor = 0.95f;
                }
                if (factor * scale> 6) {
                    factor = 6.0f/scale;
                }else if(factor * scale < 0.2f){
                    factor = 0.2f / scale;
                }

                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                img.setImageMatrix(matrix);
                scale *= factor;
                return false;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void comment(View view) {
        Intent intent = new Intent(this, LibCommentActivity.class);
        intent.putExtra("id",data.getId());
        startActivity(intent);
    }
}