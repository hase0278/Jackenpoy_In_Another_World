package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SoundPlayer player = new SoundPlayer(getApplicationContext(), true, R.raw.homesound);
        player.play();
        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(getApplicationContext());
        if(!sharedPreference.doesKeyExist("savedInfo", "side")){
            Log.d("side", "side");
            sharedPreference.setData("savedInfo", "side", "humans");
            sharedPreference.setData("savedInfo", "round", "1");
        }
        LinearLayout home = findViewById(R.id.homeContainer);
        home.setOnClickListener(view -> {
            Intent round = new Intent(HomeActivity.this, Round.class);
            round.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            player.stop();
            startActivity(round);
        });
    }
}