package com.cx.smartcity.moudle_1.post;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.AreaFileBean;
import java.util.List;

public class AreaFileAdapter extends RecyclerView.Adapter<AreaFileAdapter.MHolder> {
    private Context context;
    private List<AreaFileBean.DataDTO> mdata;

    public AreaFileAdapter(Context context, List<AreaFileBean.DataDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_area_file, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final AreaFileBean.DataDTO data = mdata.get(position);
        holder.name.setText(data.getTitle());
        holder.content.setText(data.getCreateTime()+"发布");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FileDetaActivity.class);
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
        private TextView name;
        private TextView content;

        public MHolder(@NonNull View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);

        }
    }
}
