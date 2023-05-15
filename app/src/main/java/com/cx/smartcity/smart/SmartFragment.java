package com.cx.smartcity.smart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.smart.community.ShequActivity;
import com.cx.smartcity.smart.environ.HuanbaoActivity;
import com.cx.smartcity.smart.model.KaimoActivity;
import com.cx.smartcity.smart.old.YanglaoActivity;
import com.cx.smartcity.smart.partisan.DangJianActivity;
import com.cx.smartcity.smart.produce.ZhizaoActivity;
import com.cx.smartcity.smart.relief.FupingActivity;

public class SmartFragment extends Fragment implements View.OnClickListener {
    private LinearLayout fuping;
    private LinearLayout kaimo;
    private LinearLayout dangjian;
    private LinearLayout huanbao;
    private LinearLayout shequ;
    private LinearLayout yanglao;
    private LinearLayout zhizao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fuping = (LinearLayout) view.findViewById(R.id.fuping);
        kaimo = (LinearLayout) view.findViewById(R.id.kaimo);
        dangjian = (LinearLayout) view.findViewById(R.id.dangjian);
        huanbao = (LinearLayout) view.findViewById(R.id.huanbao);
        shequ = (LinearLayout) view.findViewById(R.id.shequ);
        yanglao = (LinearLayout) view.findViewById(R.id.yanglao);
        zhizao = (LinearLayout) view.findViewById(R.id.zhizao);

        fuping.setOnClickListener(this);
        kaimo.setOnClickListener(this);
        dangjian.setOnClickListener(this);
        huanbao.setOnClickListener(this);
        shequ.setOnClickListener(this);
        yanglao.setOnClickListener(this);
        zhizao.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fuping:
                startActivity(new Intent(getContext(), FupingActivity.class));
                break;
            case R.id.kaimo:
                startActivity(new Intent(getContext(), KaimoActivity.class));
                break;
            case R.id.dangjian:
                startActivity(new Intent(getContext(), DangJianActivity.class));
                break;
            case R.id.huanbao:
                startActivity(new Intent(getContext(), HuanbaoActivity.class));
                break;
            case R.id.shequ:
                startActivity(new Intent(getContext(), ShequActivity.class));
                break;
            case R.id.yanglao:
                startActivity(new Intent(getContext(), YanglaoActivity.class));
                break;
            case R.id.zhizao:
                startActivity(new Intent(getContext(), ZhizaoActivity.class));
                break;
        }
    }
}