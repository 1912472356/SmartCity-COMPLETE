package com.cx.smartcity.moudle_1.gover;

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
import com.cx.smartcity.bean.LoveTypeBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class AppealTypeAdapter extends RecyclerView.Adapter<AppealTypeAdapter.MHolder> {
    private Context context;
    private List<LoveTypeBean.DataDTO> mdata;


    public AppealTypeAdapter(Context context, List<LoveTypeBean.DataDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_appeal_type, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final LoveTypeBean.DataDTO data = mdata.get(position);

        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action(data);
            }
        });


        int end = position + (mdata.size() + 1) /2;
        if (mdata.get(end) == null){
            holder.img2.setVisibility(View.INVISIBLE);
        }else {
            final LoveTypeBean.DataDTO data2 = mdata.get(end);
            Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data2.getImgUrl())
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img2);
            holder.name2.setText(data2.getName());
            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    action(data2);
                }
            });
        }

    }

    private void action(LoveTypeBean.DataDTO data) {
        if (data.getName().equals("其他诉求")) {
            context.startActivity(new Intent(context, AddAppealActivity.class));
            return;
        }
        Intent intent = new Intent(context, AppealActivity.class);
        intent.putExtra("id", data.getId());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return (mdata.size() + 1)/2;
    }

    class MHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name;
        private ImageView img2;
        private TextView name2;

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            img2 = (ImageView) view.findViewById(R.id.img2);
            name2 = (TextView) view.findViewById(R.id.name2);

        }
    }
}
