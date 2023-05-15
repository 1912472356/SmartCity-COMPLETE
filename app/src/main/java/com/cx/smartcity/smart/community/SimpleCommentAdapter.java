package com.cx.smartcity.smart.community;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.ShequYoulingBean;

import java.util.List;

public class SimpleCommentAdapter extends RecyclerView.Adapter<SimpleCommentAdapter.MHolder> {
    private Context context;
    private List<ShequYoulingBean.SimpleCommentBean> mdata;

    public SimpleCommentAdapter(Context context, List<ShequYoulingBean.SimpleCommentBean> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_simple_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        ShequYoulingBean.SimpleCommentBean data = mdata.get(position);
        holder.name.setText(data.getName()+ "：");
        holder.content.setText(data.getContent());
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
