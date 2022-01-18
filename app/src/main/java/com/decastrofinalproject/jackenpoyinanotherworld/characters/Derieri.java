package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Derieri extends Characters {
    public Derieri(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral8_human:R.drawable.demongeneral8_demon;
    }
}