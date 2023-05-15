package com.cx.smartcity.smart.community;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.BannerBean;
import com.cx.smartcity.bean.ShequYoulingBean;
import com.cx.smartcity.util.SPUtil;
import com.google.gson.Gson;

import java.util.List;

public class ShequYoulingAdapter extends RecyclerView.Adapter<ShequYoulingAdapter.MHolder> {
    private Context context;
    private List<ShequYoulingBean> mdata;

    public ShequYoulingAdapter(Context context, List<ShequYoulingBean> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_shequ_youling, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, int position) {
        final ShequYoulingBean data = mdata.get(position);
        holder.date.setText(data.getDate()+"发布");
        holder.content.setText(data.getContent());
        if(data.getImg() != null) {
            Glide.with(context).load(BitmapFactory.decodeFile(data.getImg()))
                    .error(R.mipmap.resource).transform(new CenterCrop()).into(holder.img);
        }else {
            holder.img.setVisibility(View.GONE);
        }

        holder.simpleCommentRecyc.setLayoutManager(new LinearLayoutManager(context));
        holder.simpleCommentRecyc.setAdapter(new SimpleCommentAdapter(context, data.getCommentList()));

        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = holder.commentEt.getText().toString();
                holder.commentEt.setText("");
                data.getCommentList().add(new ShequYoulingBean.SimpleCommentBean("留言用户", s));
                SPUtil.put(SPUtil.SHEQU_YOULING, new Gson().toJson(mdata));
                Toast.makeText(context, "留言成功", Toast.LENGTH_SHORT).show();
                holder.simpleCommentRecyc.setAdapter(new SimpleCommentAdapter(context, data.getCommentList()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView date;
        private TextView content;
        private ImageView img;
        private RecyclerView simpleCommentRecyc;
        private EditText commentEt;
        private Button commentBtn;

        public MHolder(@NonNull View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            content = (TextView) view.findViewById(R.id.content);
            img = (ImageView) view.findViewById(R.id.img);
            simpleCommentRecyc = (RecyclerView) view.findViewById(R.id.simple_comment_recyc);
            commentEt = (EditText) view.findViewById(R.id.comment_et);
            commentBtn = (Button) view.findViewById(R.id.comment_btn);

        }
    }
}

