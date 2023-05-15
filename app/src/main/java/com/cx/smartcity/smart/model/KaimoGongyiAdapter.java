package com.cx.smartcity.smart.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.KaimoGongyiBean;

import java.util.List;

public class KaimoGongyiAdapter extends RecyclerView.Adapter<KaimoGongyiAdapter.MHolder> {
    private Context context;
    private List<KaimoGongyiBean> mdata;
    private boolean flag = false;

    public KaimoGongyiAdapter(Context context, List<KaimoGongyiBean> mdata, boolean flag) {
        this.context = context;
        this.mdata = mdata;
        this.flag = flag;
    }

    public KaimoGongyiAdapter(Context context, List<KaimoGongyiBean> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_kaimo_gongyi, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        KaimoGongyiBean data = mdata.get(position);
        holder.name.setText(data.getName());
        holder.content.setText(data.getContent());
        if (data.getPath() != null) {
            Glide.with(context).load(BitmapFactory.decodeFile(data.getPath()))
                                    .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        }else {
            holder.img.setVisibility(View.GONE);
        }

        if (flag){
            holder.btn.setVisibility(View.GONE);
        }
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "报名成功", Toast.LENGTH_SHORT).show();
                holder.btn.setClickable(false);
                holder.btn.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC);
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
        private Button btn;
        private TextView content;

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            btn = (Button) view.findViewById(R.id.btn);
            content = (TextView) view.findViewById(R.id.content);
        }
    }
}

