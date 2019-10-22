package com.renfutai.myschooltimetable.Data;

public class GetData {
    private static String[] kebiao = new String[]
            {"计算机网络", "软件项目管理", "单片机", "软件项目管理(单)", "编译原理",
                    "软件体系结构", "面向对象", "软件体系结构(单)", "计算机网络", "软件工程",
                    "软件工程", "编译原理", "面向对象(双)", "", "单片机(单)",
                    "编译原理实验", "计算机网络实验", "", "", "软件工程实验",
                    "", "", "形式政策@4C405", "", ""};

    private static String[] xingqi = new String[]{
            "周一", "周二", "周三", "周四", "周五"
    };

    private static String[] dianji = new String[]{
            "教室@10C525,教师:李元振", "教室@10C529,教师:许丽莉", "教室@10C525,教师:杨吉宏", "教室@10C125,教师:许丽莉", "教室@10C424,教师:姜华",
            "教室@10C525,教师:凌海云", "教室@10C529,教师:赵阳", "教室@10C525,教师:凌海云", "教室@10C525,教师:李元振", "教室@10C424,教师:孙涛",
            "教室@10C525,教师:孙涛", "教室@10C121,教师:姜华", "教室@10C521,教师:赵阳", "", "教室@10C421,教师:杨吉宏",
            "", "", "", "", "",
            "", "", "", "", "",
    };


    public static int[] colorSettings = new int[]{
            1, 2, 3, 2, 4,
            5, 6, 5, 1, 7,
            7, 4, 6, 0, 3,
            9, 10, 0, 0, 11,
            0, 0, 8, 0, 0
    };

    public static int[] danshuangzhou = new int[]{
            3, 3, 3, 0, 3,
            3, 3, 0, 3, 3,
            3, 3, 3, 3, 0,
            3, 3, 3, 3, 3,
            3, 3, 3, 3, 3
    };


    public static String getzhuti(int i) {
        return kebiao[i];
    }

    public static String getxingqi(int i) {
        return xingqi[i];
    }

    public static String getdianji(int i) {
        return dianji[i];
    }
}
