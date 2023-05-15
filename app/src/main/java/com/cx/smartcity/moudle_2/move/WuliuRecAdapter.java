package com.cx.smartcity.moudle_2.move;

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
import com.cx.smartcity.R;
import com.cx.smartcity.bean.WuliuBean;
import com.cx.smartcity.moudle_2.pet.PetDoctorActivity;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class WuliuRecAdapter extends RecyclerView.Adapter<WuliuRecAdapter.MHolder> {
    private Context context;
    private List<WuliuBean.DataDTO> mdata;

    public WuliuRecAdapter(Context context, List<WuliuBean.DataDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_service, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final WuliuBean.DataDTO data = mdata.get(position);

        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WuliuDetailActivity.class);
                intent.putExtra("id", data.getId());
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

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);

        }
    }
}
