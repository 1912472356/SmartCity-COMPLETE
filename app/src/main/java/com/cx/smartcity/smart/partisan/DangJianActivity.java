package com.cx.smartcity.smart.partisan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.person.FeedbackActivity;
import com.cx.smartcity.person.PersonMsgActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DangJianActivity extends AppCompatActivity implements View.OnClickListener {
    private Banner banner;
    private LinearLayout dynamic;
    private LinearLayout learn;
    private LinearLayout event;
    private LinearLayout feed;
    private LinearLayout suishou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_jian);
        banner = (Banner) findViewById(R.id.banner);
        dynamic = (LinearLayout) findViewById(R.id.dynamic);
        learn = (LinearLayout) findViewById(R.id.learn);
        event = (LinearLayout) findViewById(R.id.event);
        feed = (LinearLayout) findViewById(R.id.feed);
        suishou = (LinearLayout) findViewById(R.id.suishou);

        initBanner();

        dynamic.setOnClickListener(this);
        learn.setOnClickListener(this);
        event.setOnClickListener(this);
        feed.setOnClickListener(this);
        suishou.setOnClickListener(this);
    }

    private void initBanner() {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setImageResource((Integer) o);
            }
        });
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.dangjian_banner1);
        list.add(R.mipmap.dangjian_banner2);
        list.add(R.mipmap.dangjian_banner3);
        list.add(R.mipmap.dangjian_banner4);
        banner.setImages(list);
        banner.start();
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dynamic:
                startActivity(new Intent(this, DynamicActivity.class));
                break;
            case R.id.learn:
                startActivity(new Intent(this, DangjianXuexiActivity.class));
                break;
            case R.id.event:
                startActivity(new Intent(this, DangjianHuodongActivity.class));
                break;
            case R.id.feed:
                startActivity(new Intent(this, FeedbackActivity.class));
                break;
            case R.id.suishou:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
                    }else  startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1);
                }else startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1);
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 1);
        }else Toast.makeText(this, "暂无权限", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "拍照上传成功", Toast.LENGTH_SHORT).show();
        }
    }

}