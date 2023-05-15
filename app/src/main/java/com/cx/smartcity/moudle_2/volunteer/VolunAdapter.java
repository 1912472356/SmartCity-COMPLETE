package com.cx.smartcity.moudle_2.volunteer;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.VolunBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class VolunAdapter extends RecyclerView.Adapter<VolunAdapter.MHolder> {
    private Context context;
    private List<VolunBean.RowsDTO> mdata;
    private int state;
    RetrofitUtil.OnRequest onRequest;

    public VolunAdapter(Context context, List<VolunBean.RowsDTO> mdata, int state, RetrofitUtil.OnRequest onRequest) {
        this.context = context;
        this.mdata = mdata;
        this.state = state;
        this.onRequest = onRequest;
    }

    public VolunAdapter(Context context, List<VolunBean.RowsDTO> mdata, int state) {
        this.context = context;
        this.mdata = mdata;
        this.state = state;
    }

    public VolunAdapter(Context context, List<VolunBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_volun, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, final int position) {
        final VolunBean.RowsDTO data = mdata.get(position);
        holder.title.setText(data.getTitle());
        holder.content.setText("承办单位："+data.getUndertaker()+"\n活动开始时间："+data.getStartAt()+"\n人员要求："+data.getRequireText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VolunDetaActivity.class);
                intent.putExtra("data", data);
                context.startActivity(intent);
            }
        });

        if (state == 0){
            holder.signBtn.setText("取消报名");
        }else if(state == -1){
            holder.signBtn.setText("报名");
        }else {
            holder.signBtn.setVisibility(View.GONE);
        }
        holder.signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Object, Object> map = new HashMap<>();
                map.put("activityId", data.getId());
                map.put("newState", state == 0 ? false :true);
                RetrofitUtil.post("/prod-api/api/volunteer-service/register", map, new RetrofitUtil.OnRequest() {
                    @Override
                    public void onRequest(String json) {
                        try {
                            JSONObject obj = new JSONObject(json);
                            if (obj.getInt("code") == 200) {
                                Toast.makeText(context, (state == 0 ? "已取消":"报名成功"), Toast.LENGTH_SHORT).show();
                                onRequest.onRequest(position + "");
                            }else {
                                Toast.makeText(context, (state == 0 ? "取消":"报名")+"失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private Button signBtn;

        public MHolder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);

            signBtn = (Button) view.findViewById(R.id.sign_btn);

        }
    }
}

