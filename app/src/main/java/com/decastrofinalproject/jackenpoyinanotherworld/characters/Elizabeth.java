package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;
public class Elizabeth extends Characters{
    public Elizabeth(String side){
        this.characterImg = side.equals("human")?R.drawable.elizabeth_human:R.drawable.elizabeth_demon;
        this.charName = "Elizabeth(Celestial)(General)";
    }
}
