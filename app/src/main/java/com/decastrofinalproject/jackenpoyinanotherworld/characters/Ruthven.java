package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Ruthven extends Characters {
    public Ruthven(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral3_human:R.drawable.demongeneral3_demon;
        this.charName = "Ruthven(Demon)(General)";
    }
}