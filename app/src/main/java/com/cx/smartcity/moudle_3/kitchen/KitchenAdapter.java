package com.cx.smartcity.moudle_3.kitchen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.KitchenBean;
import com.cx.smartcity.util.RetrofitUtil;
import com.cx.smartcity.util.SPUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class KitchenAdapter extends RecyclerView.Adapter<KitchenAdapter.MHolder> {
    private Context context;
    private List<KitchenBean.RowsDTO> mdata;

    public KitchenAdapter(Context context, List<KitchenBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_kitchen, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, final int position) {
        final KitchenBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(holder.img);
        holder.name.setText(data.getName());
        holder.collect.setText(data.getCollectionCount()+"人已收藏");
        holder.likeCnt.setText(data.getLikeCount() + "");
        if (data.isMyLikeState()) {
            holder.likeImg.setColorFilter(Color.RED);
        }else {
            holder.likeImg.setColorFilter(Color.GRAY);
        }
        holder.likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Object, Object> map = new HashMap<>();
                map.put("dishesId", data.getId());
                map.put("newState", !data.isMyLikeState());
                RetrofitUtil.post("/prod-api/api/kitchen-helper/dishes-like", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                data.setMyLikeState(!data.isMyLikeState());
                                int idx = data.isMyLikeState() ? 1 :-1;
                                data.setLikeCount(data.getLikeCount() + idx);
                                notifyItemChanged(position);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, KitchenDetaActivity.class);
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
        private TextView collect;
        private LinearLayout likeBtn;
        private ImageView likeImg;
        private TextView likeCnt;

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            collect = (TextView) view.findViewById(R.id.collect);
            likeBtn = (LinearLayout) view.findViewById(R.id.like_btn);
            likeImg = (ImageView) view.findViewById(R.id.like_img);
            likeCnt = (TextView) view.findViewById(R.id.like_cnt);
        }
    }
}
