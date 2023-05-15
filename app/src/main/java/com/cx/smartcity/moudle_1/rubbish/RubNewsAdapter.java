package com.cx.smartcity.moudle_1.rubbish;

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
import com.cx.smartcity.bean.RubNewsBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class RubNewsAdapter extends RecyclerView.Adapter<RubNewsAdapter.MHolder> {
    private Context context;
    private List<RubNewsBean.RowsDTO> mdata;

    public RubNewsAdapter(Context context, List<RubNewsBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_rub_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final RubNewsBean.RowsDTO data = mdata.get(position);
        holder.title.setText(data.getTitle());
        holder.date.setText(data.getCreateTime()+"发布");
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RubNewDetailActivity.class);
                intent.putExtra("id",data.getId());
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
        private TextView date;
        private ImageView img;
        public MHolder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            img = (ImageView) view.findViewById(R.id.img);

        }
    }
}
