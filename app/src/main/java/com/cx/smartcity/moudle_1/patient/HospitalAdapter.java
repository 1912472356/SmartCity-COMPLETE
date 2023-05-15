package com.cx.smartcity.moudle_1.patient;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.HospitalBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.MHolder> {
    private Context context;
    private List<HospitalBean.RowsDTO> mdata;

    public HospitalAdapter(Context context, List<HospitalBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_hospital, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final HospitalBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(20)).into(holder.img);
        holder.name.setText(data.getHospitalName());
        holder.starList.removeAllViews();
        for (int i = 0; i < data.getLevel(); i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.ic_baseline_star_fill);
            imageView.setColorFilter(Color.YELLOW);
            holder.starList.addView(imageView);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HospitalDetailActivity.class);
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
        private LinearLayout starList;

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            starList = (LinearLayout) view.findViewById(R.id.star_list);

        }
    }
}

