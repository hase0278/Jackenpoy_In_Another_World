package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Cain extends Characters {
    public Cain(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral1_human:R.drawable.demongeneral1_demon;
        this.charName = "Cain(Demon)(General)";
    }
}