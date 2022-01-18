package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Charlatan extends Characters {
    public Charlatan(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral6_human:R.drawable.demongeneral6_demon;
        this.charName = "Charlatan(Demon)";
    }
}