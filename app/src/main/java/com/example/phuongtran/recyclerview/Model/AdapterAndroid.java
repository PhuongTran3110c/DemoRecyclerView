package com.example.phuongtran.recyclerview.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phuongtran.recyclerview.R;

import java.util.List;

public class AdapterAndroid extends RecyclerView.Adapter<AdapterAndroid.ViewHolder>{
    private List<AndroidDetail> list;

    public AdapterAndroid(List<AndroidDetail> list){
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvVer.setText(list.get(position).getVer());
        holder.tvApi.setText(list.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvVer, tvApi;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView)itemView.findViewById(R.id.name);
            tvVer = (TextView)itemView.findViewById(R.id.ver);
            tvApi = (TextView)itemView.findViewById(R.id.api);
        }
    }
}
