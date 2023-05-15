package com.cx.smartcity.data;

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

public class DataFragment extends Fragment implements View.OnClickListener {
    private LinearLayout bar;
    private LinearLayout line;
    private LinearLayout pie;
    private LinearLayout circle;
    private LinearLayout horBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    private void initView(View view) {
        bar = (LinearLayout) view.findViewById(R.id.bar);
        line = (LinearLayout) view.findViewById(R.id.line);
        pie = (LinearLayout) view.findViewById(R.id.pie);
        circle = (LinearLayout) view.findViewById(R.id.circle);
        horBar = (LinearLayout) view.findViewById(R.id.hor_bar);

        bar.setOnClickListener(this);
        line.setOnClickListener(this);
        pie.setOnClickListener(this);
        circle.setOnClickListener(this);
        horBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bar:
                startActivity(new Intent(getContext(), BarActivity.class));
                break;
            case R.id.line:
                startActivity(new Intent(getContext(), LineActivity.class));
                break;
            case R.id.pie:
                startActivity(new Intent(getContext(), PieActivity.class));
                break;
            case R.id.circle:
                startActivity(new Intent(getContext(), CircleActivity.class));
                break;
            case R.id.hor_bar:
                startActivity(new Intent(getContext(), HorBarActivity.class));
                break;
        }
    }
}