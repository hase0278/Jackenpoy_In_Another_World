package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Mobs extends Characters{
    public Mobs(String side, int round){
        this.characterImg = side.equals("human")? R.drawable.demonmobs:R.drawable.humanmobs;
        this.charName = side.equals("human")? "Enemy soldier <num>(Demon)":"Enemy soldier <num>(Human)";
        setDmg(5);
        setMultiplier(round);
        setHp(50);
    }
}
