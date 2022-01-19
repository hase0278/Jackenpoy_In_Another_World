package com.decastrofinalproject.jackenpoyinanotherworld;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer {
    private MediaPlayer mPlayer;
    public SoundPlayer(Context context, boolean isLooped, int music_id){
        mPlayer = MediaPlayer.create(context, music_id);
        mPlayer.setLooping(isLooped);
    }
    public void play(){
        mPlayer.start();
    }
    public void stop(){
        mPlayer.stop();
    }
    public void pause(){
        mPlayer.pause();
    }
}
