package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(getApplicationContext());
        if(!sharedPreference.doesKeyExist("savedInfo", "side")){
            Log.d("side", "side");
            sharedPreference.setData("savedInfo", "side", "humans");
            sharedPreference.setData("savedInfo", "round", "1");
        }
    }
}