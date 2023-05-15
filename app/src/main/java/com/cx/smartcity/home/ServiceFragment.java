package com.cx.smartcity.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.ServiceBean;
import com.cx.smartcity.home.adap.ServiceAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ServiceFragment extends Fragment {
    private TabLayout tabLayout;
    private RecyclerView serviceRecyc;

    private List<ServiceBean.RowsDTO> mdata[] = new ArrayList[4];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        serviceRecyc = (RecyclerView) view.findViewById(R.id.service_recyc);

        initData();
        initTab();
    }

    private void initTab() {
        LinearLayout layout = (LinearLayout) tabLayout.getChildAt(0);
        layout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        layout.setDividerDrawable(new ColorDrawable(Color.GRAY));
        layout.setDividerPadding(20);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                serviceRecyc.setAdapter(new ServiceAdapter(getContext(), mdata[tab.getPosition()]));
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private void initData() {
        serviceRecyc.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mdata[1] = new ArrayList<>();
        mdata[2] = new ArrayList<>();
        mdata[3] = new ArrayList<>();
        RetrofitUtil.get("/prod-api/api/service/list", new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                mdata[0] = new Gson().fromJson(json, ServiceBean.class).getRows();
                loadMore();
                for (ServiceBean.RowsDTO row : mdata[0]) {
                    String serviceType = row.getServiceType();
                    if (serviceType.equals("车主服务")) {
                        mdata[1].add(row);
                    }else if (serviceType.equals("生活服务")) {
                        mdata[2].add(row);
                    } else if (serviceType.equals("便民服务")) {
                        mdata[3].add(row);
                    }
                }
                serviceRecyc.setAdapter(new ServiceAdapter(getContext(), mdata[0]));
            }
        });
    }

    private void loadMore() {
        ServiceBean.RowsDTO rowsDTO1 = new ServiceBean.RowsDTO();
        rowsDTO1.setServiceName("数字图书馆");
        rowsDTO1.setServiceType("生活服务");
        mdata[0].add(rowsDTO1);

        ServiceBean.RowsDTO rowsDTO2 = new ServiceBean.RowsDTO();
        rowsDTO2.setServiceName("政府服务热线");
        rowsDTO2.setServiceType("便民服务");
        mdata[0].add(rowsDTO2);

        ServiceBean.RowsDTO rowsDTO3 = new ServiceBean.RowsDTO();
        rowsDTO3.setServiceName("垃圾分类宝典");
        rowsDTO3.setServiceType("生活服务");
        mdata[0].add(rowsDTO3);


        ServiceBean.RowsDTO rowsDTO4 = new ServiceBean.RowsDTO();
        rowsDTO4.setServiceName("律师咨询");
        rowsDTO4.setServiceType("便民服务");
        mdata[0].add(rowsDTO4);

        ServiceBean.RowsDTO rowsDTO5 = new ServiceBean.RowsDTO();
        rowsDTO5.setServiceName("预约检车");
        rowsDTO5.setServiceType("车主服务");
        mdata[0].add(rowsDTO5);

        ServiceBean.RowsDTO rowsDTO6 = new ServiceBean.RowsDTO();
        rowsDTO6.setServiceName("厨房助手");
        rowsDTO6.setServiceType("生活服务");
        mdata[0].add(rowsDTO6);

        ServiceBean.RowsDTO rowsDTO7 = new ServiceBean.RowsDTO();
        rowsDTO7.setServiceName("志愿活动");
        rowsDTO7.setServiceType("生活服务");
        mdata[0].add(rowsDTO7);



    }
}