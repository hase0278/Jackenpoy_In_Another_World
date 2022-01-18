package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class You extends Characters{
    public You(String side, int round){
        this.characterImg = R.drawable.mainchar;
        this.charName = "You";
        setDmg(50);
        setMultiplier(round);
        setHp(1000);
    }
}