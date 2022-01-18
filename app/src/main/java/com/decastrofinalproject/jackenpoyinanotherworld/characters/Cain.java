package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Cain extends Characters {
    public Cain(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral10_human:R.drawable.demongeneral10_demon;
    }
}