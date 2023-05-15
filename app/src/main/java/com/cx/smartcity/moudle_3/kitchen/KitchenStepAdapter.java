package com.cx.smartcity.moudle_3.kitchen;

import android.content.Context;
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
import com.cx.smartcity.bean.KitchenDetailBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class KitchenStepAdapter extends RecyclerView.Adapter<KitchenStepAdapter.MHolder> {
    private Context context;
    private List<KitchenDetailBean.DataDTO.StepListDTO> mdata;

    public KitchenStepAdapter(Context context, List<KitchenDetailBean.DataDTO.StepListDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_kitchen_step, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        KitchenDetailBean.DataDTO.StepListDTO data = mdata.get(position);
        holder.sort.setText("第 "+data.getSort()+" 步");
        holder.name.setText(data.getContent());
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView sort;
        private ImageView img;
        private TextView name;


        public MHolder(@NonNull View view) {
            super(view);
            sort = (TextView) view.findViewById(R.id.sort);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
