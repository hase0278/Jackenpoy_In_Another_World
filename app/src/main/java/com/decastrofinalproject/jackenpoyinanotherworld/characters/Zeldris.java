package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Zeldris extends Characters {
    public Zeldris(String side){
        this.characterImg = side.equals("human")?R.drawable.zeldris_human:R.drawable.zeldris_demon;
        this.charName = "Zeldris(Demon)(Demon Lord)";
    }
}