package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeActivity extends AppCompatActivity {
    SoundPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ExecutorService executor = Executors.newCachedThreadPool();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            player = new SoundPlayer(getApplicationContext(), true, R.raw.homesound);
            handler.post(() -> player.play());
        });
        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(getApplicationContext());
        if(!sharedPreference.doesKeyExist("savedInfo", "side")){
            sharedPreference.setData("savedInfo", "side", "human");
            sharedPreference.setData("savedInfo", "round", "1");
            sharedPreference.setData("savedInfo", "revive", "0");
            sharedPreference.setData("savedInfo", "allegianceStats", "no");
            sharedPreference.setData("savedInfo", "introPlayed", "no");
        }
        LinearLayout home = findViewById(R.id.homeContainer);
        home.setOnClickListener(view -> {
            if(sharedPreference.getData("savedInfo", "introPlayed").equals("no")){
                Intent intro = new Intent(HomeActivity.this, Intro.class);
                intro.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                player.stop();
                startActivity(intro);
                finish();
            }
            else
            {
                Intent round = new Intent(HomeActivity.this, Round.class);
                round.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                player.stop();
                startActivity(round);
                this.finish();
            }
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