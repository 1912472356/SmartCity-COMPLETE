package com.cx.smartcity.smart.old;

import android.content.Context;
import android.content.Intent;
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
import com.cx.smartcity.bean.YanglaoBean;

import java.util.List;

public class YanglaoAdapter extends RecyclerView.Adapter<YanglaoAdapter.MHolder> {
    private Context context;
    private List<YanglaoBean> mdata;

    public YanglaoAdapter(Context context, List<YanglaoBean> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_yanglao, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        final YanglaoBean data = mdata.get(position);
        holder.name.setText(data.getName());
        holder.content.setText(data.getContent());
        Glide.with(context).load(data.getImg())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new YanglaoCommentDialog(context).show();
            }
        });

        holder.subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "预约成功", Toast.LENGTH_SHORT).show();
                holder.subBtn.setClickable(false);
                holder.subBtn.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, YanglaoDetaActivity.class);
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
        private Button comment;
        private Button subBtn;
        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            comment = (Button) view.findViewById(R.id.comment);
            subBtn = (Button) view.findViewById(R.id.sub_btn);

        }
    }
}

