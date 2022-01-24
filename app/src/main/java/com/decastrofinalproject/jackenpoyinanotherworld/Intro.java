package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Intro extends AppCompatActivity {
    private final int[] storyContents = {R.drawable.story_intro1, R.drawable.story_intro2, R.drawable.intro_story3, R.drawable.intro_story4, R.drawable.intro_story5, R.drawable.intro_story6, R.drawable.intro_story7};
    private int storyIndex = 0;
    SoundPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        ConstraintLayout layout = findViewById(R.id.introHome);
        layout.setBackgroundResource(storyContents[storyIndex]);
        player = new SoundPlayer(layout.getContext(), true, R.raw.isekaintro);
        player.play();
        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(layout.getContext());

        Button skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreference.setData("savedInfo", "introPlayed", "yes");
                Intent round = new Intent(Intro.this, Round.class);
                round.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                player.stop();
                startActivity(round);
                finish();
            }
        });
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(storyIndex != storyContents.length - 1){
                    storyIndex++;
                    layout.setBackgroundResource(storyContents[storyIndex]);
                }
                else{
                    sharedPreference.setData("savedInfo", "introPlayed", "yes");
                    Intent round = new Intent(Intro.this, Round.class);
                    round.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    player.stop();
                    startActivity(round);
                    finish();
                }
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