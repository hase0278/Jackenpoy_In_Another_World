package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Escanor extends Characters {
    public Escanor(String side){
        this.characterImg = side.equals("human")?R.drawable.escanor_human:R.drawable.escanor_demon;
    }
}
