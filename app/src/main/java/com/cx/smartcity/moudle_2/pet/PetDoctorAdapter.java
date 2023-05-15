package com.cx.smartcity.moudle_2.pet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.PetDoctorBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class PetDoctorAdapter extends RecyclerView.Adapter<PetDoctorAdapter.MHolder> {
    private Context context;
    private List<PetDoctorBean.RowsDTO> mdata;

    public PetDoctorAdapter(Context context, List<PetDoctorBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_pet_inquiry, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final PetDoctorBean.RowsDTO data = mdata.get(position);
        holder.name.setText(data.getName()+"（"+data.getJobName()+"）");
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getAvatar())
                                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(holder.img);
        holder.content.setText("执业编号："+data.getPracticeNo()+"\n从业"+data.getWorkingYears()+"年，"+data.getGoodAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PetInquiryActivity.class);
                intent.putExtra("data",new Gson().toJson(data));
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
        private TextView content;

        public MHolder(@NonNull View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);

        }
    }
}
