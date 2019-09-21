package com.renfutai.myschooltimetable.SetStatusBar;

import android.app.Activity;

public class Set {
    //colorID为状态栏背景颜色,dark 为字体是否为黑色
    public static void set(Activity activity, int colorID,boolean dark) {

        OtherWork.transparencyBar(activity);
        OtherWork.setStatusBarColor(activity, colorID);
        if (WhatModel.isMIUI()) {
            SetStatusBarText.MIUISetStatusBarLightMode(activity, dark);
        } else if (WhatModel.isFlymeV4OrAbove()) {
            SetStatusBarText.setFlymeLightStatusBar(activity, dark);
        } else {
            SetStatusBarText.setAndroidNativeLightStatusBar(activity, dark);
        }
    }
}
