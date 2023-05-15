package com.cx.smartcity.moudle_2.movie;

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
import com.cx.smartcity.bean.MovieBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MHolder> {
    private Context context;
    private List<MovieBean.RowsDTO> mdata;

    public MovieAdapter(Context context, List<MovieBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final MovieBean.RowsDTO data = mdata.get(position);
        holder.name.setText(data.getName());
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getCover())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.content.setText("时长："+data.getDuration()+"分钟");
        holder.date.setText(data.getPlayDate()+"上映");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetaActivity.class);
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
        private TextView date;
        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            date = (TextView) view.findViewById(R.id.date);
        }
    }
}
