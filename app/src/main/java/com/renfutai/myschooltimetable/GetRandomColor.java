package com.renfutai.myschooltimetable;

import java.util.Random;

public class GetRandomColor {
    private static int[] colors = new int[]{
            R.drawable.color_yuanhu, R.drawable.color_yuanhu1, R.drawable.color_yuanhu2, R.drawable.color_yuanhu3, R.drawable.color_yuanhu4,
            R.drawable.color_yuanhu5, R.drawable.color_yuanhu6, R.drawable.color_yuanhu7, R.drawable.color_yuanhu8, R.drawable.color_yuanhu9,
            R.drawable.color_yuanhu10, R.drawable.color_yuanhu11, R.drawable.color_yuanhu12, R.drawable.color_yuanhu13, R.drawable.color_yuanhu14,
            R.drawable.color_yuanhu15
    };


    //i代表数组大小
    public static int[] Random() {
        int i = 16;
        Random random = new Random();
        for (int j = 0; j < 20; j++) {
            int r1 = random.nextInt(i);
            int r2 = random.nextInt(i);
            int x = colors[r1];
            colors[r1] = colors[r2];
            colors[r2] = x;
        }
        colors[0]=R.drawable.color_yuanhu_hui;
        return colors;
    }

}
