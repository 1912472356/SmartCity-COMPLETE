package com.cx.smartcity.moudle_2.bus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BusSizeBean;

import java.util.List;

public class BusSiteAdapter extends RecyclerView.Adapter<BusSiteAdapter.MHolder> {
    private Context context;
    private List<BusSizeBean.RowsDTO> mdata;

    public BusSiteAdapter(Context context, List<BusSizeBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_site, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        BusSizeBean.RowsDTO data = mdata.get(position);
        holder.name.setText(data.getName());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView name;

        public MHolder(@NonNull View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
