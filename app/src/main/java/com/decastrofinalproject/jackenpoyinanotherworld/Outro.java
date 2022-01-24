package com.decastrofinalproject.jackenpoyinanotherworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.view.WindowManager;
import android.widget.Button;

public class Outro extends AppCompatActivity {
    private int[] storyContents;
    private int storyIndex = 0;
    SoundPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);

        ConstraintLayout layout = findViewById(R.id.introHome);
        SharedPreferenceAccessor sharedPreference = new SharedPreferenceAccessor(layout.getContext());
        String side = sharedPreference.getData("savedInfo", "side");
        if(side.equals("human")){
            storyContents = new int[]{R.drawable.human_end_story1, R.drawable.human_end_story2, R.drawable.end_storyend1, R.drawable.end_storyend2};
        }
        else{
            storyContents = new int[]{R.drawable.demon_end_story1, R.drawable.demon_end_story2, R.drawable.demon_end_story3, R.drawable.demon_end_story4, R.drawable.end_storyend1, R.drawable.end_storyend2};
        }
        layout.setBackgroundResource(storyContents[storyIndex]);
        player = new SoundPlayer(layout.getContext(), true, R.raw.drama);
        player.play();

        Button skip = findViewById(R.id.skip);
        skip.setOnClickListener(view -> {
            storyIndex = storyContents.length - 1;
            layout.setBackgroundResource(storyContents[storyIndex]);
            player.stop();
            player = new SoundPlayer(layout.getContext(), false, R.raw.youwin);
            player.play();
            AlertDiag.show(layout.getContext(), R.drawable.win, "You win", "Go home", (dialogInterface, i) -> {
                player.stop();
                sharedPreference.clearData("savedInfo");
                Intent home = new Intent(Outro.this, HomeActivity.class);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
            });
        });
        Button next = findViewById(R.id.next);
        next.setOnClickListener(view -> {
            if(storyIndex != storyContents.length - 1){
                storyIndex++;
                layout.setBackgroundResource(storyContents[storyIndex]);
            }
            else{
                storyIndex = storyContents.length - 1;
                layout.setBackgroundResource(storyContents[storyIndex]);
                player.stop();
                player = new SoundPlayer(layout.getContext(), false, R.raw.youwin);
                player.play();
                AlertDiag.show(layout.getContext(), R.drawable.win, "You win", "Go home", (dialogInterface, i) -> {
                    player.stop();
                    sharedPreference.clearData("savedInfo");
                    Intent home = new Intent(Outro.this, HomeActivity.class);
                    home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(home);
                });
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