package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Hendrickson extends Characters{
    public Hendrickson(String side){
        this.characterImg = side.equals("human")?R.drawable.hendrickson_human:R.drawable.hendrickson_demon;
        this.charName = "Hendrickson(Human)";
    }
}
