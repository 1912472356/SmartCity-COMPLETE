package com.cx.smartcity.moudle_2.law;

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
import com.cx.smartcity.bean.LawBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class LawAdapter extends RecyclerView.Adapter<LawAdapter.MHolder> {
    private Context context;
    private List<LawBean.RowsDTO> mdata;

    public LawAdapter(Context context, List<LawBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_law, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final LawBean.RowsDTO data = mdata.get(position);
        holder.haoping.setText(data.getFavorableRate()+"%好评");
        holder.name.setText(data.getName());
        int year = Math.min("2022".compareTo(data.getWorkStartAt()),1);
        holder.content.setText("从业"+year+"年，"+data.getServiceTimes()+"人咨询过");
        holder.lawType.setText(data.getLegalExpertiseName());
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getAvatarUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.consultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LawDetailActivity.class);
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
        private TextView haoping;
        private TextView name;
        private TextView content;
        private TextView lawType;
        private Button consultBtn;
        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            haoping = (TextView) view.findViewById(R.id.haoping);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            lawType = (TextView) view.findViewById(R.id.law_type);
            consultBtn = (Button) view.findViewById(R.id.consult_btn);

        }
    }
}
