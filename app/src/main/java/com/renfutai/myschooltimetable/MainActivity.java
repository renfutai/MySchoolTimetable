package com.renfutai.myschooltimetable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.renfutai.myschooltimetable.Data.ElectiveSetting;
import com.renfutai.myschooltimetable.Data.GetData;
import com.renfutai.myschooltimetable.SetStatusBar.Set;

public class MainActivity extends Activity {

    private TextView textView;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView0;
    private SharedPreferences sharedPreferences;
    private ElectiveSetting electiveSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Set.set(MainActivity.this, R.color.colorWhite, true);
        //获取SharedPreferences
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        electiveSetting = new ElectiveSetting(sharedPreferences);

        setBiaoTi();
        setDaRiQi();
        setDaKeBiao();
    }

    private void setBiaoTi() {
        textView = findViewById(R.id.am_tv);
        Log.d("mytable", " " + MyTime.getTiqian());
        if (MyTime.getTiqian()) {
            textView.setText("第" + (MyTime.getzhoushu() - 1) + "周");
            Log.d("mytable", "if " + MyTime.getTiqian());
            TextView textView1;
            textView1 = findViewById(R.id.am_tv1);
            textView1.setText("提前显示第" + MyTime.getzhoushu() + "周课表");
        } else {
            textView.setText("第" + MyTime.getzhoushu() + "周");
            Log.d("mytable", "else " + MyTime.getTiqian());
        }
    }


    private void setDaKeBiao() {
        recyclerView = findViewById(R.id.dakebiao);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 5));
        recyclerView.addItemDecoration(new MyDecoration());
        recyclerView.setAdapter(new KeBiaoGridAdapter(MainActivity.this, pos ->
                Toast.makeText(MainActivity.this, GetData.getdianji(pos), Toast.LENGTH_SHORT).show(),electiveSetting
        ));
    }

    private void setDaRiQi() {
        recyclerView0 = findViewById(R.id.dariqi);
        recyclerView0.setLayoutManager(new GridLayoutManager(MainActivity.this, 5));
        recyclerView0.addItemDecoration(new MyDecoration());
        recyclerView0.setAdapter(new RiQIGridAdapter(MainActivity.this, pos ->
                Toast.makeText(MainActivity.this, "当前时间：" + MyTime.getriqi(), Toast.LENGTH_SHORT).show()
        ));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int i = getResources().getDimensionPixelOffset(R.dimen.dividerHeight);
            outRect.set(i, 0, i, i);
        }
    }

}
