package com.decastrofinalproject.jackenpoyinanotherworld;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceAccessor {
    private final Context context;
    public SharedPreferenceAccessor(Context context){
        this.context = context;
    }
    public void setData(String preferenceName, String key, String value){
        SharedPreferences prefs = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getData(String preferenceName, String key){
        SharedPreferences prefs = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return prefs.getString(key,"");
    }
    public boolean doesKeyExist(String preferenceName, String key){
        SharedPreferences prefs = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return prefs.contains(key);
    }
    public void clearData(String preferenceName){
        SharedPreferences prefs = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit().clear();
        editor.apply();
    }
}