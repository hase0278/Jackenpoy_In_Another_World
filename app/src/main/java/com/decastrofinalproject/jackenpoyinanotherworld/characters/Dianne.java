package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;
public class Dianne extends Characters{
    public Dianne(String side){
        this.characterImg = side.equals("human")?R.drawable.diane_human:R.drawable.diane_demon;
        this.charName = "Dianne(Giant)";
    }
}
