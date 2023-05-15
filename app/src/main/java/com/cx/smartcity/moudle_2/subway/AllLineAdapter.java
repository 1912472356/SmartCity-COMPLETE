package com.cx.smartcity.moudle_2.subway;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cx.smartcity.R;
import com.cx.smartcity.bean.AllLineaBean;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AllLineAdapter extends RecyclerView.Adapter<AllLineAdapter.MHolder> {
    private Context context;
    private List<AllLineaBean.DataDTO> mdata;

    public AllLineAdapter(Context context, List<AllLineaBean.DataDTO> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MHolder(LayoutInflater.from(context).inflate(R.layout.item_all_line, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        AllLineaBean.DataDTO data = mdata.get(position);
        holder.name.setText(data.getLineName());
        holder.myview.setBackgroundColor(Color.parseColor("#"+getColor()));
    }

    Set<String> set = new HashSet();
    private String getColor() {
        String res = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int nextInt = random.nextInt(16);
            if(nextInt <10){
                res += nextInt;
            }else {
                res += (char)('A' + nextInt-10);
            }
        }
        while (set.contains(res)) {
            res = getColor();
        }
        set.add(res);
        return res;
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class MHolder extends RecyclerView.ViewHolder{
        private View myview;
        private TextView name;

        public MHolder(@NonNull View view) {
            super(view);

            myview = (View) view.findViewById(R.id.view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
