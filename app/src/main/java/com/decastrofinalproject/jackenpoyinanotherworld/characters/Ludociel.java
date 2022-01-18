package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;
public class Ludociel extends Characters{
    public Ludociel(String side){
        this.characterImg = side.equals("human")?R.drawable.ludociel_human:R.drawable.ludociel_demon;
        this.charName = "Ludociel(Celestial)(Leader)";
    }
}
