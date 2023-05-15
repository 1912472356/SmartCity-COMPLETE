package com.cx.smartcity.moudle_1.love;

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
import com.cx.smartcity.bean.LoveBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class LoveRecommandAdapter extends RecyclerView.Adapter<LoveRecommandAdapter.MHolder> {
    private Context context;
    private List<LoveBean.RowsDTO> mdata;

    public LoveRecommandAdapter(Context context, List<LoveBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_love_recommand, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final LoveBean.RowsDTO data = mdata.get(position);
        holder.name.setText(data.getName());
        holder.content.setText("发布组织："+data.getAuthor());
        holder.donate.setText(data.getDonateCount()+"人已捐助，共捐助"+data.getMoneyNow()+"元");
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoveDetailActivity.class);
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
        private TextView content;
        private TextView donate;
        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            donate = (TextView) view.findViewById(R.id.donate);

        }
    }
}
