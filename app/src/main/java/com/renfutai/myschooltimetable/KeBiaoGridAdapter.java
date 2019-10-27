package com.renfutai.myschooltimetable;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.renfutai.myschooltimetable.Data.ElectiveSetting;
import com.renfutai.myschooltimetable.Data.GetData;

import org.json.JSONException;
import org.json.JSONObject;

public class KeBiaoGridAdapter extends RecyclerView.Adapter<KeBiaoGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;
    private int[] colors = GetRandomColor.Random();
    private int danshuangzhou = MyTime.getzhoushu() % 2;
    private ElectiveSetting electiveSetting;

    public KeBiaoGridAdapter(Context context, OnItemClickListener listener, ElectiveSetting electiveSetting) {
        this.mContext = context;
        this.mListener = listener;
        this.electiveSetting = electiveSetting;
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
        if (danshuangzhou == GetData.danshuangzhou[position] || !(electiveSetting.get(position))) {
            holder.textView.setBackground(mContext.getDrawable(R.drawable.color_yuanhu_hui));
            holder.textView.setTextColor(Color.WHITE);
        } else {
            holder.textView.setBackground(mContext.getDrawable(color));
        }
        //设置透明度
        holder.textView.setAlpha(0.7f);

        //设置点击事件
        //选修课的特殊考虑
        if (position > 14 && R.drawable.color_yuanhu_hui != color) {
            holder.textView.setOnClickListener(view -> {
                electiveSetting.set(position);
                this.notifyItemChanged(position);
            });
        } else if (R.drawable.color_yuanhu_hui != color) {
            holder.textView.setOnClickListener(view -> mListener.onClick(position));
        } else if (R.drawable.color_yuanhu_hui == color) {
            holder.textView.setOnClickListener(view -> myToast());
        }

    }

    private void myToast() {
        OkGo.<String>get("https://v1.hitokoto.cn/")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject((String) response.body());
                            String s = jsonObject.optString("hitokoto");
                            String s1 = jsonObject.optString("from");
                            Toast.makeText(mContext, (s + "  ———— " + s1), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
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
