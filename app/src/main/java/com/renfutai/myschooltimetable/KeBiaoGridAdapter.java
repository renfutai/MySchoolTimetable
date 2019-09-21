package com.renfutai.myschooltimetable;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KeBiaoGridAdapter extends RecyclerView.Adapter<KeBiaoGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;
    private int[] colors = GetRandomColor.Random();
    private int danshuangzhou = MyTime.getzhoushu() % 2;

    public KeBiaoGridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public KeBiaoGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.kebiaoitem, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull KeBiaoGridAdapter.LinearViewHolder holder, int position) {
        int color = colors[GetData.colorSettings[position]];
        holder.textView.setText(GetData.getzhuti(position));
        holder.textView.setBackground(mContext.getDrawable(color));
        //设置透明度
        holder.textView.setAlpha(0.7f);
        if (danshuangzhou == GetData.danshuangzhou[position]) {
            holder.textView.setBackground(mContext.getDrawable(R.drawable.color_yuanhu_hui));
            holder.textView.setTextColor(Color.WHITE);
        }
        if (R.drawable.color_yuanhu_hui != color) {
            holder.itemView.setOnClickListener(view -> mListener.onClick(position));
        }
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recycler_lli_text);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
