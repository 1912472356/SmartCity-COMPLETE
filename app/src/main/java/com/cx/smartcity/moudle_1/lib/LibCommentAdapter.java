package com.cx.smartcity.moudle_1.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.LibCommentBean;
import com.cx.smartcity.util.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class LibCommentAdapter extends RecyclerView.Adapter<LibCommentAdapter.MHolder> {
    private Context context;
    private List<LibCommentBean.DataDTO> mdata;

    public LibCommentAdapter(Context context, List<LibCommentBean.DataDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_lib_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, final int position) {
        final LibCommentBean.DataDTO data = mdata.get(position);
        holder.name.setText(data.getUserName()+"：");
        holder.content.setText(data.getContent());
        holder.like.setText(data.getUserId()+"人点赞");
        if (data.isMyLikeState()){
            holder.likeBtn.setVisibility(View.GONE);
        }else {
            holder.likeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HashMap<Object, Object> map = new HashMap<>();
                    map.put("commentId", data.getId());
                    map.put("like", true);
                    RetrofitUtil.post("/prod-api/api/digital-library/library-comment/like", map, new RetrofitUtil.OnRequest() {
                        @Override
                        public void onRequest(String json) {
                            try {
                                JSONObject obj = new JSONObject(json);
                                if (obj.getInt("code") == 200) {
                                    Toast.makeText(context, "点赞成功", Toast.LENGTH_SHORT).show();
                                    data.setUserId(data.getUserId() + 1);
                                    notifyItemChanged(position);
                                }else {
                                    Toast.makeText(context, "点赞失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView content;
        private Button likeBtn;
        private TextView like;
        public MHolder(@NonNull View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            content = (TextView) view.findViewById(R.id.content);
            likeBtn = (Button) view.findViewById(R.id.like_btn);
            like = (TextView) view.findViewById(R.id.like);
        }
    }
}
