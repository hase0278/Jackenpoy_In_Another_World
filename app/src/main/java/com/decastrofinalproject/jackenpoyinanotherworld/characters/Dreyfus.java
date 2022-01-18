package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Dreyfus extends Characters{
    public Dreyfus(String side){
        this.characterImg = side.equals("human")?R.drawable.dreyfus_human:R.drawable.dreyfus_demon;
        this.charName = "Dreyfus(Human)";
    }
}
