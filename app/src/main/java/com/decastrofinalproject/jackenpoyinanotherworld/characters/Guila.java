package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Guila extends Characters {
    public Guila(String side){
        this.characterImg = side.equals("human")?R.drawable.guila_humans:R.drawable.guila_demons;
        this.charName = "Guila(Human)(General)";
    }
}