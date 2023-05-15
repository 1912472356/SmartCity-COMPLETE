package com.cx.smartcity.person;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.UserBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

public class PersonFragment extends Fragment implements View.OnClickListener {
    private ImageView userHead;
    private TextView name;
    private LinearLayout personMsg;
    private LinearLayout modifyPwd;
    private LinearLayout order;
    private LinearLayout feedBack;
    private Button outLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        initMsg();
    }

    private void initMsg() {
        RetrofitUtil.get("/prod-api/api/common/user/getInfo", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                UserBean.UserDTO user = new Gson().fromJson(json, UserBean.class).getUser();
                if (SPUtil.get(SPUtil.USER_HEAD) == null) {
                    Glide.with(getContext()).load(SPUtil.get(SPUtil.HTTP) + user.getAvatar())
                                            .error(R.mipmap.user_head).transform(new CircleCrop()).into(userHead);
                }else {
                    Glide.with(getContext()).load(BitmapFactory.decodeFile(SPUtil.get(SPUtil.USER_HEAD)))
                            .error(R.mipmap.user_head).transform(new CircleCrop()).into(userHead);
                }
                name.setText(user.getNickName());
            }
        });
    }

    private void initView(View view) {
        userHead = (ImageView) view.findViewById(R.id.user_head);
        name = (TextView) view.findViewById(R.id.name);
        personMsg = (LinearLayout) view.findViewById(R.id.person_msg);
        modifyPwd = (LinearLayout) view.findViewById(R.id.modify_pwd);
        order = (LinearLayout) view.findViewById(R.id.order);
        feedBack = (LinearLayout) view.findViewById(R.id.feed_back);
        outLogin = (Button) view.findViewById(R.id.out_login);

        personMsg.setOnClickListener(this);
        modifyPwd.setOnClickListener(this);
        order.setOnClickListener(this);
        feedBack.setOnClickListener(this);
        
        outLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SPUtil.put(SPUtil.TOKEN, null);
                Toast.makeText(getContext(), "退出成功，请重新登录", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.person_msg:
                startActivity(new Intent(getContext(), PersonMsgActivity.class));
                break;
            case R.id.modify_pwd:
                startActivity(new Intent(getContext(), ModifyPwdActivity.class));
                break;
            case R.id.order:
                startActivity(new Intent(getContext(), OrderActivity.class));
                break;
            case R.id.feed_back:
                startActivity(new Intent(getContext(), FeedbackActivity.class));
                break;
        }
    }
}