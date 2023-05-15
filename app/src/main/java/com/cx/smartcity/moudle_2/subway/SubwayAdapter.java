package com.cx.smartcity.moudle_2.subway;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.util.RetrofitUtil;

import java.util.List;

public class SubwayAdapter extends RecyclerView.Adapter<SubwayAdapter.MHolder> {
    private Context context;
    private List<String> mdata;
    private List<String> titles;
    RetrofitUtil.OnRequest onRequest;

    public SubwayAdapter(Context context, List<String> mdata, List<String> titles) {
        this.context = context;
        this.mdata = mdata;
        this.titles = titles;
    }

    public SubwayAdapter(Context context, List<String> mdata, List<String> titles, RetrofitUtil.OnRequest onRequest) {
        this.context = context;
        this.mdata = mdata;
        this.titles = titles;
        this.onRequest = onRequest;
    }

    public SubwayAdapter(Context context, List<String> mdata, RetrofitUtil.OnRequest onRequest) {
        this.context = context;
        this.mdata = mdata;
        this.onRequest = onRequest;
    }

    public SubwayAdapter(Context context, List<String> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_subway, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, final int position) {
        if (titles == null) {
            holder.title.setVisibility(View.GONE);
        }else {
            holder.title.setText(titles.get(position));
        }
        if (mdata == null) {
            holder.content.setVisibility(View.GONE);
        }else {
            String data = mdata.get(position);
            if (data.contains("<b>")) {
                holder.content.setText(Html.fromHtml(data));
            }else {
                holder.content.setText(data);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRequest != null) {
                    onRequest.onRequest(position+"");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mdata != null) {
            return mdata.size();
        }
        return titles.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;

        public MHolder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);

        }
    }
}

