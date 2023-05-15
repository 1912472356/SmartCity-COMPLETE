package com.cx.smartcity.moudle_1.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.EventCommentBean;

import java.util.List;

public class EventCommentAdapter extends RecyclerView.Adapter<EventCommentAdapter.MHolder> {
    private Context context;
    private List<EventCommentBean.RowsDTO> mdata;

    public EventCommentAdapter(Context context, List<EventCommentBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_event_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        EventCommentBean.RowsDTO data = mdata.get(position);
        holder.name.setText(data.getUserName());
        holder.date.setText(data.getCommentTime()+"评论");
        holder.content.setText(data.getContent());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView date;
        private TextView content;

        public MHolder(@NonNull View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            date = (TextView) view.findViewById(R.id.date);
            content = (TextView) view.findViewById(R.id.content);

        }
    }
}
