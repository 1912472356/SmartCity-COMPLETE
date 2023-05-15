package com.cx.smartcity.moudle_1.post;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.PostBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MHolder> {
    private Context context;
    private List<PostBean.RowsDTO> mdata;

    public PostAdapter(Context context, List<PostBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        final PostBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getCoverImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getName());
        holder.bed.setText("剩余床位：男|"+data.getBedsCountBoy()+"  女|"+data.getBedsCountGirl());
        holder.address.setText(data.getAddress());
        holder.desc.setText(data.getIntroduce());
        holder.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.desc.getVisibility() == View.GONE) {
                    holder.showImg.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                    holder.showTxt.setText("隐藏介绍");
                    holder.desc.setVisibility(View.VISIBLE);
                }else {
                    holder.showImg.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                    holder.showTxt.setText("显示介绍");
                    holder.desc.setVisibility(View.GONE);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PostDetailActivity.class);
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
        private TextView bed;
        private TextView address;
        private TextView desc;
        private LinearLayout showBtn;
        private ImageView showImg;
        private TextView showTxt;

        public MHolder(@NonNull View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            bed = (TextView) view.findViewById(R.id.bed);
            address = (TextView) view.findViewById(R.id.address);
            desc = (TextView) view.findViewById(R.id.desc);
            showBtn = (LinearLayout) view.findViewById(R.id.show_btn);
            showImg = (ImageView) view.findViewById(R.id.show_img);
            showTxt = (TextView) view.findViewById(R.id.show_txt);

        }
    }
}
