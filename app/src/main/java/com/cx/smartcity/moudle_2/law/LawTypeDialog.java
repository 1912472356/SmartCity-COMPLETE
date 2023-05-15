package com.cx.smartcity.moudle_2.law;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.LawTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

public class LawTypeDialog extends Dialog {
    private RecyclerView lawTypeRecyc;
    RetrofitUtil.OnRequest onRequest;
    RetrofitUtil.OnRequest onName;

    public LawTypeDialog(@NonNull Context context, RetrofitUtil.OnRequest onRequest, RetrofitUtil.OnRequest onName) {
        super(context);
        this.onRequest = onRequest;
        this.onName = onName;
    }


    public LawTypeDialog(@NonNull Context context, RetrofitUtil.OnRequest onRequest) {
        super(context);
        this.onRequest = onRequest;
    }


    public LawTypeDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_law_type);
        lawTypeRecyc = (RecyclerView) findViewById(R.id.law_type_recyc);


        lawTypeRecyc.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/legal-expertise/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                final List<LawTypeBean.RowsDTO> list = new Gson().fromJson(json, LawTypeBean.class).getRows();
                Collections.reverse(list);
                lawTypeRecyc.setAdapter(new SelectLawTypeAdapter(getContext(), list, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        onRequest.onRequest(list.get(Integer.parseInt(json)).getId() + "");
                        if (onName != null) {
                            onName.onRequest(list.get(Integer.parseInt(json)).getName());
                        }
                        cancel();
                    }
                }));
            }
        });

    }

    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams attr = window.getAttributes();
        attr.width = (int) (attr.width * 0.7);
        attr.gravity = Gravity.CENTER;
        window.setAttributes(attr);
    }
}
