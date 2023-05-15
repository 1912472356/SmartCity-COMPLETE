package com.cx.smartcity.moudle_1.love;

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
import com.cx.smartcity.bean.LoveBean;
import com.cx.smartcity.bean.LoveDetailBean;
import com.cx.smartcity.guide.LoginActivity;
import com.cx.smartcity.util.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class LoveAdapter extends RecyclerView.Adapter<LoveAdapter.MHolder> {
    private Context context;
    private List<LoveBean.RowsDTO> mdata;

    public LoveAdapter(Context context, List<LoveBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_love, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MHolder holder, final int position) {
        final LoveBean.RowsDTO data = mdata.get(position);
        RetrofitUtil.get("/prod-api/api/public-welfare/public-welfare-activity/"+data.getId(), new RetrofitUtil.OnRequest() {
            @Override
            public void onRequest(String json) {
                LoveDetailBean.DataDTO lovedata = new Gson().fromJson(json, LoveDetailBean.class).getData();

                holder.title.setText(lovedata.getName());
                holder.desc.setText(Html.fromHtml(lovedata.getDescription()));
                holder.content.setText("项目类型："+lovedata.getType().getName()
                        +"\n公益类别："+lovedata.getType().getName()
                        +"\n发布人："+lovedata.getAuthor()
                        +"\n项目时间："+lovedata.getActivityAt());
                holder.donate.setText(data.getDonateCount()+"人已捐助，共捐助"+data.getMoneyNow()+"元");
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, LoveDetailActivity.class);
                        intent.putExtra("data", data);
                        context.startActivity(intent);
                    }
                });
                holder.donateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new DonateDialog(context, new RetrofitUtil.OnRequest() {
                            @Override
                            public void onRequest(final String money) {
                                HashMap<Object, Object> map = new HashMap<>();
                                map.put("activityId", data.getId());
                                map.put("donateMoney", Integer.parseInt(money));
                                RetrofitUtil.post("/prod-api/api/public-welfare/donate-record", map, new RetrofitUtil.OnRequest() {
                                    @Override
                                    public void onRequest(String json) {
                                        try {
                                            JSONObject obj = new JSONObject(json);
                                            if (obj.getInt("code") == 200) {
                                                data.setMoneyNow(data.getMoneyNow() + Integer.parseInt(money));
                                                notifyItemChanged(position);
                                            }else {
                                                Toast.makeText(context, "捐助失败："+obj.getString("msg"), Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        }).show();
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
        private TextView donate;
        private TextView desc;
        private Button donateBtn;

        public MHolder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
            donate = (TextView) view.findViewById(R.id.donate);
            desc = (TextView) view.findViewById(R.id.desc);
            donateBtn = (Button) view.findViewById(R.id.donate_btn);

        }
    }
}
