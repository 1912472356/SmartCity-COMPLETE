package com.cx.smartcity.person;

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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class PersonMsgActivity extends AppCompatActivity {
    private ImageView userHead;
    private EditText name;
    private Spinner sex;
    private EditText phone;
    private boolean flag;
    private String path;
    private String phonenumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_msg);
        initView();
    }

    private void initView() {

        userHead = (ImageView) findViewById(R.id.user_head);
        name = (EditText) findViewById(R.id.name);
        sex = (Spinner) findViewById(R.id.sex);
        phone = (EditText) findViewById(R.id.phone);

        initMsg();
        iniHead();
    }

    private void iniHead() {
        userHead.setOnClickListener(new View.OnClickListener() {
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
        Glide.with(PersonMsgActivity.this).load(BitmapFactory.decodeFile(path))
                .error(R.mipmap.user_head).transform(new CircleCrop()).into(userHead);

        }
    }

    private void initMsg() {
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                UserBean.UserDTO user = new Gson().fromJson(json, UserBean.class).getUser();
                if (SPUtil.get(SPUtil.USER_HEAD) == null) {
                    Glide.with(PersonMsgActivity.this).load(SPUtil.get(SPUtil.HTTP) + user.getAvatar())
                            .error(R.mipmap.user_head).transform(new CircleCrop()).into(userHead);
                }else {
                    Glide.with(PersonMsgActivity.this).load(BitmapFactory.decodeFile(SPUtil.get(SPUtil.USER_HEAD)))
                            .error(R.mipmap.user_head).transform(new CircleCrop()).into(userHead);
                }
                name.setText(user.getNickName());
                sex.setSelection(Integer.parseInt(user.getSex()));
                phone.setText(user.getPhonenumber().substring(0, 7) + "****");
                phonenumber = user.getPhonenumber();
                phone.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        flag = true;
                    }

                    @Override
                    public void afterTextChanged(Editable editable) { }
                });
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void save(View view) {
        if (flag && phone.getText().toString().contains("*")) {
            Toast.makeText(this, "手机号码格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("nickName", name.getText().toString());
        map.put("sex", sex.getSelectedItemPosition());
        map.put("phonenumber", flag ? phone.getText().toString() : phonenumber);
        RetrofitUtil.put("/prod-api/api/common/user", map, new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                try {
                    JSONObject obj = new JSONObject(json);
                    if (obj.getInt("code") == 200) {
                        Toast.makeText(PersonMsgActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                        if (path != null) {
                            SPUtil.put(SPUtil.USER_HEAD, path);
                        }
                        finish();
                    }else {
                        Toast.makeText(PersonMsgActivity.this, "保存失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}