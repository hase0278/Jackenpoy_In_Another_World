package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Ares extends Characters {
    public Ares(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral2_demon:R.drawable.demongeneral2_human;
        this.charName = "Ares(Demon)(General)";
    }
}