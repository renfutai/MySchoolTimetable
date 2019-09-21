package com.renfutai.myschooltimetable;

import java.text.SimpleDateFormat;
import java.util.Date;

//时间开始时间 1566748800000
//测试用的开始时间为 1566144000000
//一天 86400000 毫秒
public class MyTime {

    private static long beginTime = 1566748800000l;
    private static boolean tiqian = false;

    private static int gettianshu() {
        long nowTime = System.currentTimeMillis();
        long tianshu = (nowTime - beginTime) / 86400000;
        int itianshu = (int) tianshu;
        if (itianshu % 7 > 4) {
            tiqian = true;
            itianshu += 7;
        }
        return itianshu;
    }

    public static int getzhoushu() {
        int itianshu = MyTime.gettianshu();
        return itianshu / 7 + 1;
    }

    public static String getriqi() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return simpleDateFormat.format(date);
    }

    //此处可以继续性能优化
    public static String getdangqianriqi(int j) {
        String[] strings = new String[5];
        long[] longs = new long[5];
        long zhoushu = MyTime.getzhoushu();
        long kaishishijian = beginTime + (zhoushu - 1) * 7 * 86400000;
        for (int i = 0; i < 5; i++) {
            longs[i] = kaishishijian + i * 86400000;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        Date date = new Date();
        for (int i = 0; i < 5; i++) {
            date.setTime(longs[i]);
            strings[i] = simpleDateFormat.format(date);
        }
        return strings[j];
    }

    public static int getzhouji() {
        int i = MyTime.gettianshu();
        return i % 7;
    }

    public static boolean getTiqian() {
        //刷新数据
        MyTime.gettianshu();
        return tiqian;
    }
}
