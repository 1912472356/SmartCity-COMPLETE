package com.cx.smartcity.moudle_1.gover;

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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.AppealTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddAppealActivity extends AppCompatActivity {
    private LinearLayout typeLinear;
    private Spinner type;
    private EditText title;
    private EditText content;
    private ImageView img;
    private EditText undertake;
    private int id;
    private List<AppealTypeBean.RowsDTO> list;
    private String path = "/profile/abc.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);

        typeLinear = (LinearLayout) findViewById(R.id.type_linear);
        type = (Spinner) findViewById(R.id.type);
        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        img = (ImageView) findViewById(R.id.img);
        undertake = (EditText) findViewById(R.id.undertake);

        id = getIntent().getIntExtra("id", -1);
        if(id != -1){
            typeLinear.setVisibility(View.GONE);
        }

        initImg();
        RetrofitUtil.get("/prod-api/api/gov-service-hotline/appeal-category/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list = new Gson().fromJson(json, AppealTypeBean.class).getRows();
                List<String> arr = new ArrayList<>();
                for (AppealTypeBean.RowsDTO row : list) {
                    arr.add(row.getName());
                }
                type.setAdapter(new ArrayAdapter<String>(AddAppealActivity.this, R.layout.support_simple_spinner_dropdown_item, arr));
            }
        });
    }

    private void initImg() {

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
            Glide.with(AddAppealActivity.this).load(BitmapFactory.decodeFile(path))
                    .error(R.mipmap.user_head).transform(new CenterCrop(), new RoundedCorners(10)).into(img);

        }
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("appealCategoryId", id == -1 ? list.get(type.getSelectedItemPosition()).getId() : id);
        map.put("title", title.getText().toString());
        map.put("content", content.getText().toString());
        map.put("undertaker", undertake.getText().toString());
        map.put("imgUrl", path);
        RetrofitUtil.post("/prod-api/api/gov-service-hotline/appeal", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(AddAppealActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(AddAppealActivity.this, "提交失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}