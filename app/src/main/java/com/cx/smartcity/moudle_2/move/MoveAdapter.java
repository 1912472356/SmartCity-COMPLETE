package com.cx.smartcity.moudle_2.move;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.MoveBean;
import java.util.List;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MHolder> {
    private Context context;
    private List<MoveBean.DataDTO.StepListDTO> mdata;

    public MoveAdapter(Context context, List<MoveBean.DataDTO.StepListDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_move, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        MoveBean.DataDTO.StepListDTO data = mdata.get(position);
        holder.name.setText(data.getStateName());
        holder.timeAddress.setText(data.getEventAt()+"  "+data.getAddressAt());
        if (position == 0) {
            holder.upLine.setVisibility(View.INVISIBLE);
            holder.img.setImageResource(R.mipmap.move_ppoint);
        }else if(position == mdata.size()-1){
            holder.downLine.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private View upLine;
        private ImageView img;
        private View downLine;
        private TextView name;
        private TextView timeAddress;

        public MHolder(@NonNull View view) {
            super(view);
            upLine = (View) view.findViewById(R.id.up_line);
            img = (ImageView) view.findViewById(R.id.view);
            downLine = (View) view.findViewById(R.id.down_line);
            name = (TextView) view.findViewById(R.id.name);
            timeAddress = (TextView) view.findViewById(R.id.time_address);
        }
    }
}
