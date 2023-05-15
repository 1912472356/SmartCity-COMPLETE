package com.cx.smartcity.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MHolder> {
    private Context context;
    private List<String> mdata;

    RetrofitUtil.OnRequest onRequest;

    public ListAdapter(Context context, List<String> mdata, RetrofitUtil.OnRequest onRequest) {
        this.context = context;
        this.mdata = mdata;
        this.onRequest = onRequest;
    }

    public ListAdapter(Context context, List<String> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, final int position) {
        String data = mdata.get(position);
        TextView tv = (TextView) holder.itemView;
        tv.setText(data);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRequest != null) {
                    onRequest.onRequest(position + "");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{

        public MHolder(@NonNull View view) {
            super(view);

        }
    }
}
