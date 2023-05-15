package com.cx.smartcity.moudle_2.law;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.LawTypeBean;
import com.cx.smartcity.moudle_1.event.EventActivity;
import com.cx.smartcity.moudle_1.gover.GoverActivity;
import com.cx.smartcity.moudle_1.house.HouseActivity;
import com.cx.smartcity.moudle_1.lib.LibraryActivity;
import com.cx.smartcity.moudle_1.love.LoveActivity;
import com.cx.smartcity.moudle_1.park.ParkActivity;
import com.cx.smartcity.moudle_1.patient.HospitalActivity;
import com.cx.smartcity.moudle_1.post.PostActivity;
import com.cx.smartcity.moudle_1.rubbish.RubActivity;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class LawTypeAdapter extends RecyclerView.Adapter<LawTypeAdapter.MHolder> {
    private Context context;
    private List<LawTypeBean.RowsDTO> mdata;
    private boolean flag;

    public LawTypeAdapter(Context context, List<LawTypeBean.RowsDTO> mdata, boolean flag) {
        this.context = context;
        this.mdata = mdata;
        this.flag = flag;
    }

    public LawTypeAdapter(Context context, List<LawTypeBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_law_type, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final LawTypeBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(data);
            }
        });

        int end = position + getItemCount();
        if (mdata.get(end) != null) {
            final LawTypeBean.RowsDTO data2 = mdata.get(end);
            Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data2.getImgUrl())
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img2);
            holder.name2.setText(data2.getName());
            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click(data2);
                }
            });
        }else {
            holder.img2.setVisibility(View.INVISIBLE);
        }
    }

    private void click(LawTypeBean.RowsDTO data) {
        Intent intent = null;
        if (flag) {
            intent = new Intent(context, LawListActivity.class);
        }else {
            intent = new Intent(context, LawTypeActivity.class);
        }
        intent.putExtra("id", data.getId());
        context.startActivity(intent);
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
