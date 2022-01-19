package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeActivity extends AppCompatActivity {
    SoundPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ExecutorService executor = Executors.newCachedThreadPool();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            player = new SoundPlayer(getApplicationContext(), true, R.raw.homesound);
            handler.post(() -> player.play());
        });
        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(getApplicationContext());
        if(!sharedPreference.doesKeyExist("savedInfo", "side")){
            Log.d("side", "side");
            sharedPreference.setData("savedInfo", "side", "human");
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
    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        player.play();
    }

}