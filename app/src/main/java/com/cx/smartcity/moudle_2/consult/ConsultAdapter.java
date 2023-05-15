package com.cx.smartcity.moudle_2.consult;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.ConsultBean;
import com.cx.smartcity.bean.LawDetailBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class ConsultAdapter extends RecyclerView.Adapter<ConsultAdapter.MHolder> {
    private Context context;
    private List<ConsultBean.RowsDTO> mdata;

    public ConsultAdapter(Context context, List<ConsultBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_consult, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        final ConsultBean.RowsDTO data = mdata.get(position);
        RetrofitUtil.get("/prod-api/api/lawyer-consultation/lawyer/"+data.getLawyerId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                LawDetailBean.DataDTO lawData = new Gson().fromJson(json, LawDetailBean.class).getData();
                Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + lawData.getAvatarUrl())
                        .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
            }
        });
        holder.name.setText(data.getLawyerName());
        holder.date.setText(data.getCreateTime()+"提交");
        if (data.getLegalExpertiseName() == null) {
            data.setLegalExpertiseName("未知");
        }
        holder.lawType.setText(data.getLegalExpertiseName().toString());
        holder.state.setText(data.getState().equals("0") ? "未受理":(data.getState().equals("1")?"受理中":"已完成"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ConsultDetaActivity.class);
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
        private ImageView img;
        private TextView name;
        private TextView date;
        private TextView lawType;
        private Button state;
        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            date = (TextView) view.findViewById(R.id.date);
            lawType = (TextView) view.findViewById(R.id.law_type);
            state = (Button) view.findViewById(R.id.state);

        }
    }
}
