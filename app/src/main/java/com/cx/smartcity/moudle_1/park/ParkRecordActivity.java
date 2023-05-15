package com.cx.smartcity.moudle_1.park;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.ParkRecordBean;
import com.cx.smartcity.util.CommonAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ParkRecordActivity extends AppCompatActivity {
    private EditText entryDate;
    private EditText outDate;
    private RecyclerView recordRecyc;
    private Button moreBtn;

    int size = 5;
    private List<ParkRecordBean.RowsDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_record);
        entryDate = (EditText) findViewById(R.id.entry_date);
        outDate = (EditText) findViewById(R.id.out_date);
        recordRecyc = (RecyclerView) findViewById(R.id.record_recyc);
        moreBtn = (Button) findViewById(R.id.more_btn);

        recordRecyc.setLayoutManager(new LinearLayoutManager(this));
        loadData();

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                size += 5;
                moreRecord();
            }
        });
        entryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(entryDate);
            }
        });
        outDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate(outDate);
            }
        });
    }

    private void setDate(final EditText da) {
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(final DatePicker datePicker, final int year, final int month, final int day) {
                new TimePickerDialog(ParkRecordActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        da.setText(year+"-"+(month + 1) + "-"+day+" "+i+":"+i1);
                    }
                }, 12, 0,true).show();
            }
        }, 2022, 1, 1).show();
    }


    private void loadData() {
        RetrofitUtil.get("/prod-api/api/park/lot/record/list?entryTime="+entryDate.getText().toString()+"&outTime="+outDate.getText().toString(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                list = new Gson().fromJson(json, ParkRecordBean.class).getRows().subList(0, 40);
                moreRecord();
            }
        });
    }

    private void moreRecord() {
        List<String> arr = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<ParkRecordBean.RowsDTO> dtos = list.subList(0, Math.min(size, list.size()));
        for (ParkRecordBean.RowsDTO row : dtos) {
            titles.add(row.getPlateNumber());
            arr.add("收费金额：￥"+row.getMonetary()+"元"
                    +"\n入场时间："+row.getEntryTime()
                    +"\n出场时间："+row.getOutTime()
                    +"\n停车场名称："+row.getParkName()
            );
        }
        if (list.size() <= size)
            moreBtn.setVisibility(View.GONE);
        else moreBtn.setVisibility(View.VISIBLE);
        recordRecyc.setAdapter(new CommonAdapter(ParkRecordActivity.this, arr, titles));
    }

    public void back(View view) {
        finish();
    }

    public void query(View view) {
        size = 5;
        loadData();
    }
}