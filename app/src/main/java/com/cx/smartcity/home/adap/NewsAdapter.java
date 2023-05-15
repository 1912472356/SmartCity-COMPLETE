package com.cx.smartcity.home.adap;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.NewsBean;
import com.cx.smartcity.home.NewsDetailActivity;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MHolder> {
    private Context context;
    private List<NewsBean.RowsDTO> mdata;

    public NewsAdapter(Context context, List<NewsBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final NewsBean.RowsDTO data = mdata.get(position);
        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getCover())
                                .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getTitle());
        holder.content.setText(Html.fromHtml(data.getContent()));
        holder.comment.setText(data.getCommentNum()+"条评论");
        holder.date.setText(data.getPublishDate()+"发布");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
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
        private ImageView img;
        private TextView name;
        private TextView content;
        private TextView comment;
        private TextView date;

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            comment = (TextView) view.findViewById(R.id.comment);
            date = (TextView) view.findViewById(R.id.date);

        }
    }
}

