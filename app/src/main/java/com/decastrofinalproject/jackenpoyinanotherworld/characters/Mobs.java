package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Mobs extends Characters{
    public Mobs(String side, int round){
        this.characterImg = side.equals("humans")? R.drawable.demonmobs:R.drawable.humanmobs;
        this.charName = side.equals("humans")? "Enemy soldier(Demon)":"Enemy soldier(Human)";
        setDmg(5);
        setMultiplier(round);
        setHp(50);
    }
}
