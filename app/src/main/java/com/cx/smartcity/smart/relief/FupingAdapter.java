package com.cx.smartcity.smart.relief;

import android.content.Context;
import android.content.Intent;
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.FupingBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class FupingAdapter extends RecyclerView.Adapter<FupingAdapter.MHolder> {
    private Context context;
    private List<FupingBean> mdata;
    boolean flag;

    public FupingAdapter(Context context, List<FupingBean> mdata, boolean flag) {
        this.context = context;
        this.mdata = mdata;
        this.flag = flag;
    }

    public FupingAdapter(Context context, List<FupingBean> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_fuping, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        final FupingBean data = mdata.get(position);
        holder.name.setText(data.getTitle());
        holder.content.setText(data.getContent());
        holder.date.setText(data.getDate()+"发布");

        if(!flag){
            holder.likeBtn.setVisibility(View.GONE);
        }
        if (data.getImg() == null) {
            if (data.getPath() == null) {
                holder.img.setVisibility(View.GONE);
            }else {
                Glide.with(context).load(BitmapFactory.decodeFile(data.getPath()))
                                        .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
            }
        }else{
            Glide.with(context).load(data.getImg())
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        }
        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点赞成功", Toast.LENGTH_SHORT).show();
                holder.likeBtn.setClickable(false);
                holder.likeBtn.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FupingDetailActivity.class);
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
        private Button likeBtn;
        public MHolder(@NonNull View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            date = (TextView) view.findViewById(R.id.date);
            likeBtn = (Button) view.findViewById(R.id.like_btn);


        }
    }
}
