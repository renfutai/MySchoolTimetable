package com.renfutai.myschooltimetable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;

public class RiQIGridAdapter extends RecyclerView.Adapter<RiQIGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public RiQIGridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RiQIGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.riqiitem, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RiQIGridAdapter.LinearViewHolder holder, int position) {
        holder.textView1.setText(GetData.getxingqi(position));
        holder.textView2.setText(MyTime.getdangqianriqi(position));
        int i=R.color.colorGray;
        if (position == MyTime.getzhouji()) {
            Resources resources= mContext.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.yuanhulite);
            holder.textView1.setBackground(drawable);
        }
        holder.itemView.setOnClickListener(view -> mListener.onClick(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView1, textView2;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.xingqi);
            textView2 = itemView.findViewById(R.id.yuefen);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
