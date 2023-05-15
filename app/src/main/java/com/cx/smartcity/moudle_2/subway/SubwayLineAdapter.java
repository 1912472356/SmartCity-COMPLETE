package com.cx.smartcity.moudle_2.subway;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.SubwayLineBean;
import com.cx.smartcity.bean.SubwayLineBean.DataDTO.MetroStepListDTO;
import java.util.List;

public class SubwayLineAdapter extends RecyclerView.Adapter<SubwayLineAdapter.MHolder> {
    private Context context;
    private List<SubwayLineBean.DataDTO.MetroStepListDTO> mdata;
    String currentName;

    public SubwayLineAdapter(Context context, List<MetroStepListDTO> mdata, String currentName) {
        this.context = context;
        this.mdata = mdata;
        this.currentName = currentName;
    }

    public SubwayLineAdapter(Context context, List<SubwayLineBean.DataDTO.MetroStepListDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_subway_line, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        SubwayLineBean.DataDTO.MetroStepListDTO data = mdata.get(position);
        holder.name.setText(data.getName());
        if(currentName.equals(data.getName())){
            holder.myview.setColorFilter(Color.RED);
            holder.name.setTextSize(18);
        }else {
            holder.myview.setColorFilter(Color.parseColor("#0277BD"));
            holder.name.setTextSize(16);
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private ImageView myview;
        private TextView name;


        public MHolder(@NonNull View view) {
            super(view);
            myview = (ImageView) view.findViewById(R.id.view);
            name = (TextView) view.findViewById(R.id.name);

        }
    }
}
