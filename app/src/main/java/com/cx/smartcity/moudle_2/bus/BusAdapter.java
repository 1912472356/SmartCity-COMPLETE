package com.cx.smartcity.moudle_2.bus;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BusBean;
import com.cx.smartcity.bean.BusSizeBean;
import com.cx.smartcity.util.ListAdapter;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.MHolder> {
    private Context context;
    private List<BusBean.RowsDTO> mdata;

    public BusAdapter(Context context, List<BusBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_bus, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        final BusBean.RowsDTO data = mdata.get(position);
        holder.title.setText(data.getName());
        holder.start.setText(data.getFirst());
        holder.end.setText(data.getEnd());
        holder.content.setText("运行时间：首班|"+data.getStartTime()+"，末班|"+data.getEndTime()
                +"\n票价："+data.getPrice()+"元"
                +"\n里程："+data.getMileage()+"Km");
        holder.sizeRecyc.setLayoutManager(new LinearLayoutManager(context));
        RetrofitUtil.get("/prod-api/api/bus/stop/list?linesId="+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                List<BusSizeBean.RowsDTO> list = new Gson().fromJson(json, BusSizeBean.class).getRows();
                List<String> arr = new ArrayList<>();
                for (BusSizeBean.RowsDTO row : list) {
                    arr.add(row.getName());
                }
                holder.sizeRecyc.setAdapter(new ListAdapter(context, arr));
            }
        });

        holder.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.sizeRecyc.getVisibility() == View.VISIBLE) {
                    holder.sizeRecyc.setVisibility(View.GONE);
                    holder.showImg.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    holder.showTv.setText("展开站点");
                }else {
                    holder.sizeRecyc.setVisibility(View.VISIBLE);
                    holder.showImg.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    holder.showTv.setText("收起站点");
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BusDetailActivity.class);
                intent.putExtra("data", data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView start;
        private TextView end;
        private TextView content;
        private RecyclerView sizeRecyc;
        private LinearLayout showBtn;
        private ImageView showImg;
        private TextView showTv;

        public MHolder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            start = (TextView) view.findViewById(R.id.start);
            end = (TextView) view.findViewById(R.id.end);
            content = (TextView) view.findViewById(R.id.content);
            sizeRecyc = (RecyclerView) view.findViewById(R.id.size_recyc);
            showBtn = (LinearLayout) view.findViewById(R.id.show_btn);
            showImg = (ImageView) view.findViewById(R.id.show_img);
            showTv = (TextView) view.findViewById(R.id.show_tv);

        }
    }
}
