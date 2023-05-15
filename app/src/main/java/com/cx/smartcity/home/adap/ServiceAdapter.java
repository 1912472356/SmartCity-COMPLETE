package com.cx.smartcity.home.adap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.cx.smartcity.MainActivity;
import com.cx.smartcity.R;
import com.cx.smartcity.bean.ServiceBean;
import com.cx.smartcity.moudle_1.event.EventActivity;
import com.cx.smartcity.moudle_1.gover.GoverActivity;
import com.cx.smartcity.moudle_1.house.HouseActivity;
import com.cx.smartcity.moudle_1.lib.LibraryActivity;
import com.cx.smartcity.moudle_1.love.LoveActivity;
import com.cx.smartcity.moudle_1.park.ParkActivity;
import com.cx.smartcity.moudle_1.patient.HospitalActivity;
import com.cx.smartcity.moudle_1.post.PostActivity;
import com.cx.smartcity.moudle_1.rubbish.RubActivity;
import com.cx.smartcity.moudle_2.bus.BusActivity;
import com.cx.smartcity.moudle_2.law.LawerActivity;
import com.cx.smartcity.moudle_2.move.MoveActivity;
import com.cx.smartcity.moudle_2.movie.MovieActivity;
import com.cx.smartcity.moudle_2.pet.PetActivity;
import com.cx.smartcity.moudle_2.sub_car.SubCarActivity;
import com.cx.smartcity.moudle_2.subway.SubwayActivity;
import com.cx.smartcity.moudle_2.volunteer.VolunActivity;
import com.cx.smartcity.moudle_3.illegal.IllegalActivity;
import com.cx.smartcity.moudle_3.kitchen.KitchenActivity;
import com.cx.smartcity.moudle_3.pay.CallQueryActivity;
import com.cx.smartcity.moudle_3.work.WorkActivity;
import com.cx.smartcity.util.SPUtil;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MHolder> {
    private Context context;
    private List<ServiceBean.RowsDTO> mdata;
    private boolean flag;

    public ServiceAdapter(Context context, List<ServiceBean.RowsDTO> mdata, boolean flag) {
        this.context = context;
        this.mdata = mdata;
        this.flag = flag;
    }

    public ServiceAdapter(Context context, List<ServiceBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_service, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final ServiceBean.RowsDTO data = mdata.get(position);
        if (flag && position == mdata.size()-1) {
            holder.img.setImageResource(R.mipmap.more);
            holder.img.setColorFilter(Color.BLACK);
            holder.name.setText("更多服务");
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((MainActivity)context).ser();
                }
            });
            return;
        }

        Glide.with(context).load(SPUtil.get(SPUtil.HTTP) + data.getImgUrl())
                                .error(R.mipmap.more3).transform(new CenterCrop()).into(holder.img);
        holder.name.setText(data.getServiceName());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serviceName = data.getServiceName();
                // moudle_1
                if (serviceName.equals("停哪儿")) {
                    context.startActivity(new Intent(context, ParkActivity.class));
                }else if (serviceName.equals("数字图书馆")) {
                    context.startActivity(new Intent(context, LibraryActivity.class));
                }else if (serviceName.equals("青年驿站")) {
                    context.startActivity(new Intent(context, PostActivity.class));
                }else if (serviceName.equals("活动管理")) {
                    context.startActivity(new Intent(context, EventActivity.class));
                }else if (serviceName.equals("爱心捐赠")) {
                    context.startActivity(new Intent(context, LoveActivity.class));
                }else if (serviceName.equals("政府服务热线")) {
                    context.startActivity(new Intent(context, GoverActivity.class));
                }else if (serviceName.equals("找房子")) {
                    context.startActivity(new Intent(context, HouseActivity.class));
                }else if (serviceName.equals("门诊预约")) {
                    context.startActivity(new Intent(context, HospitalActivity.class));
                }else if (serviceName.equals("垃圾分类宝典")) {
                    context.startActivity(new Intent(context, RubActivity.class));
                }

                // moudle_2
                else if (serviceName.equals("律师咨询")) {
                    context.startActivity(new Intent(context, LawerActivity.class));
                }else if (serviceName.equals("智慧巴士")) {
                    context.startActivity(new Intent(context, BusActivity.class));
                }else if (serviceName.equals("预约检车")) {
                    context.startActivity(new Intent(context, SubCarActivity.class));
                }else if (serviceName.equals("看电影")) {
                    context.startActivity(new Intent(context, MovieActivity.class));
                }else if (serviceName.equals("志愿活动")) {
                    context.startActivity(new Intent(context, VolunActivity.class));
                }else if (serviceName.equals("宠物医院")) {
                    context.startActivity(new Intent(context, PetActivity.class));
                }else if (serviceName.equals("城市地铁")) {
                    context.startActivity(new Intent(context, SubwayActivity.class));
                }else if (serviceName.equals("物流查询")) {
                    context.startActivity(new Intent(context, MoveActivity.class));
                }

                // moudle_3
                else if (serviceName.equals("智慧交管")) {
                    context.startActivity(new Intent(context, IllegalActivity.class));
                }else if (serviceName.equals("生活缴费")) {
                    context.startActivity(new Intent(context, CallQueryActivity.class));
                }else if (serviceName.equals("找工作")) {
                    context.startActivity(new Intent(context, WorkActivity.class));
                }else if (serviceName.equals("厨房助手")) {
                    context.startActivity(new Intent(context, KitchenActivity.class));
                }
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

        public MHolder(@NonNull View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            name = (TextView) view.findViewById(R.id.name);

        }
    }
}
