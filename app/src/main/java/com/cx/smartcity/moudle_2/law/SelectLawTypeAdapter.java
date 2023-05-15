package com.cx.smartcity.moudle_2.law;

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
import com.cx.smartcity.bean.LawTypeBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class SelectLawTypeAdapter extends RecyclerView.Adapter<SelectLawTypeAdapter.MHolder> {
    private Context context;
    private List<LawTypeBean.RowsDTO> mdata;
    RetrofitUtil.OnRequest onRequest;

    public SelectLawTypeAdapter(Context context, List<LawTypeBean.RowsDTO> mdata, RetrofitUtil.OnRequest onRequest) {
        this.context = context;
        this.mdata = mdata;
        this.onRequest = onRequest;
    }

    public SelectLawTypeAdapter(Context context, List<LawTypeBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_law_type, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, final int position) {
        final LawTypeBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(position);
            }
        });

        final int end = position + getItemCount();
        if (mdata.get(end) != null) {
            final LawTypeBean.RowsDTO data2 = mdata.get(end);
            Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data2.getImgUrl())
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img2);
            holder.name2.setText(data2.getName());
            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click(end);
                }
            });
        }else {
            holder.img2.setVisibility(View.INVISIBLE);
        }
    }

    private void click(int pos) {
        onRequest.onRequest(pos + "");
    }

    @Override
    public int getItemCount() {
        return (mdata.size() + 1)/ 2;
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
