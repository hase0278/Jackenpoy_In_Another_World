package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Merlin extends Characters {
    public Merlin(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral7_human:R.drawable.demongeneral7_demon;
        this.charName = "Merlin(Demon)(General)";
    }
}