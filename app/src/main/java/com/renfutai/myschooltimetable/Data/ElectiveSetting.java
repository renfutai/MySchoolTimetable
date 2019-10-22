package com.renfutai.myschooltimetable.Data;

import android.content.SharedPreferences;
import android.util.Log;

public class ElectiveSetting {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public ElectiveSetting(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
        mEditor = mSharedPreferences.edit();
    }

    public boolean get(int i) {
        return mSharedPreferences.getBoolean(String.valueOf(i), true);
    }

    public void set(int i) {
        if (mSharedPreferences.getBoolean(String.valueOf(i), true)) {
            mEditor.putBoolean(String.valueOf(i), false);
        } else {
            mEditor.putBoolean(String.valueOf(i), true);
        }
        mEditor.apply();
        Log.d("rft", String.valueOf(mSharedPreferences.getBoolean(String.valueOf(i), true)));
    }
}
