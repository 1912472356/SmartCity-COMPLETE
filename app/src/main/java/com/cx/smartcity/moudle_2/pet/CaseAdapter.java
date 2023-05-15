package com.cx.smartcity.moudle_2.pet;

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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.PetInquiryBean;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.MHolder> {
    private Context context;
    private List<PetInquiryBean.RowsDTO> mdata;

    public CaseAdapter(Context context, List<PetInquiryBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_pet_inquiry, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final PetInquiryBean.RowsDTO data = mdata.get(position);
        if (data.getDoctor() != null) {

            holder.name.setText(data.getDoctor().getName());
            Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getDoctor().getAvatar())
                    .error(R.mipmap.resource).transform(new CenterCrop(), new RoundedCorners(10)).into(holder.img);

        }
        holder.content.setText(data.getQuestion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InquiryDetailActivity.class);
                intent.putExtra("data", data);
                intent.putExtra("id", 1);
                context.startActivity(intent);
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
        private TextView content;

        public MHolder(@NonNull View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);

        }
    }
}
