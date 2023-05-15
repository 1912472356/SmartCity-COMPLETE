package com.cx.smartcity.moudle_1.patient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.PatientBean;

import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MHolder> {
    private Context context;
    private List<PatientBean.RowsDTO> mdata;

    public PatientAdapter(Context context, List<PatientBean.RowsDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_patient, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        final PatientBean.RowsDTO data = mdata.get(position);
        holder.title.setText(data.getName());
        holder.content.setText("身份证号："+data.getCardId()+"\n手机号："+data.getTel());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DepartActivity.class));
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddPatietnActivity.class);
                intent.putExtra("data", data);
                context.startActivity(intent);
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
        private ImageView edit;


        public MHolder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
            edit = (ImageView) view.findViewById(R.id.edit);
        }
    }
}
