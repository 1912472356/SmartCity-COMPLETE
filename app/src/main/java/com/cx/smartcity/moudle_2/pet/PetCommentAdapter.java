package com.cx.smartcity.moudle_2.pet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.PetCommentBean;

import java.util.List;

public class PetCommentAdapter extends RecyclerView.Adapter<PetCommentAdapter.MHolder> {
    private Context context;
    private List<PetCommentBean.RowsDTO> mdata;

    public PetCommentAdapter(Context context, List<PetCommentBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_pet_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        PetCommentBean.RowsDTO data = mdata.get(position);
        holder.name.setText(data.getFromRole().equals("0") ?"问诊人追问：":"宠物医生回复：");
        holder.content.setText(data.getContent());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
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
