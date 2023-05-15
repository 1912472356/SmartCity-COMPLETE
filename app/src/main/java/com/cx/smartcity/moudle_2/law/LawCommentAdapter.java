package com.cx.smartcity.moudle_2.law;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.LawCommentBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class LawCommentAdapter extends RecyclerView.Adapter<LawCommentAdapter.MHolder> {
    private Context context;
    private List<LawCommentBean.RowsDTO> mdata;

    public LawCommentAdapter(Context context, List<LawCommentBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_law_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, final int position) {
        final LawCommentBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getFromUserAvatar())
                .error(R.mipmap.resource).transform(new CircleCrop()).into(holder.img);
        holder.name.setText(data.getFromUserName());
        holder.date.setText(data.getCreateTime() + "发布");
        holder.content.setText(data.getEvaluateContent());
        holder.likeCnt.setText(data.getLikeCount() + "");
        if (data.isMyLikeState()) {
            holder.likeImg.setColorFilter(Color.RED);
        } else {
            holder.likeImg.setColorFilter(Color.GRAY);
        }

        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, data.isMyLikeState() ? "取消成功" : "点赞成功", Toast.LENGTH_SHORT).show();
                data.setMyLikeState(!data.isMyLikeState());
                int idx=  data.isMyLikeState()?1:-1;
                data.setLikeCount(data.getLikeCount() + idx);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView date;
        private TextView content;
        private LinearLayout likeBtn;
        private ImageView likeImg;
        private TextView likeCnt;

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            date = (TextView) view.findViewById(R.id.date);
            content = (TextView) view.findViewById(R.id.content);
            likeBtn = (LinearLayout) view.findViewById(R.id.like_btn);
            likeImg = (ImageView) view.findViewById(R.id.like_img);
            likeCnt = (TextView) view.findViewById(R.id.like_cnt);


        }
    }
}
