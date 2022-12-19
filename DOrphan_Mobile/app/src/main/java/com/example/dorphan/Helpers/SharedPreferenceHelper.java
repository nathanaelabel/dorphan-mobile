package com.example.dorphan.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceHelper {
    private static final String PREFS = "pref";
    private static SharedPreferenceHelper instance;
    private static SharedPreferences prefs;

    private SharedPreferenceHelper(Context context){
        prefs = PreferenceManager.getDefaultSharedPreferences(context);

    }

    public static SharedPreferenceHelper getInstance(Context context){
        if (instance == null){
            instance = new SharedPreferenceHelper(context);
        }
        return instance;
    }

    public static void saveAccessToken(String token){
        prefs.edit().putString(PREFS, token).apply();
    }

    public void saveRefreshToken(String token){
        prefs.edit().putString(PREFS, token).apply();
    }

    public static String getAccessToken(){
        return prefs.getString(PREFS, "");
    }

    public static void clearPref() {
        prefs.edit().clear().apply();
    }
}