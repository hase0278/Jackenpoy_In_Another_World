package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Matrona extends Characters{
    public Matrona(String side){
        this.characterImg = side.equals("human")?R.drawable.matrona_human:R.drawable.matrona_demon;
        this.charName = "Matrona(Giant)";
    }
}
