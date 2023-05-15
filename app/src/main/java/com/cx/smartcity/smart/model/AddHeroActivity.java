package com.cx.smartcity.smart.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.KaimoGongyiBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AddHeroActivity extends AppCompatActivity {

    private EditText name;
    private EditText content;
    private ImageView img;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hero);
        name = (EditText) findViewById(R.id.name);
        content = (EditText) findViewById(R.id.content);
        img = (ImageView) findViewById(R.id.img);

        iniHead();
    }

    private void iniHead() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    }else  startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
                }else startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
        }else Toast.makeText(this, "暂无权限", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri, null, null, null, null, null);
            cursor.moveToFirst();
            path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            Glide.with(AddHeroActivity.this).load(BitmapFactory.decodeFile(path))
                    .error(R.mipmap.user_head).transform(new CenterCrop()).into(img);

        }
    }
    public void back(View view) {
        finish();
    }

    public void save(View view) {

        Type type = new TypeToken<List<KaimoGongyiBean>>() {
        }.getType();
        List<KaimoGongyiBean> list = new Gson().fromJson(SPUtil.get(SPUtil.KAIMO_NEAR_HERO), type);
        list.add(new KaimoGongyiBean(name.getText().toString(), content.getText().toString(), path));
        Toast.makeText(this, "事迹发布成功", Toast.LENGTH_SHORT).show();
        SPUtil.put(SPUtil.KAIMO_NEAR_HERO, new Gson().toJson(list));
        finish();
    }
}