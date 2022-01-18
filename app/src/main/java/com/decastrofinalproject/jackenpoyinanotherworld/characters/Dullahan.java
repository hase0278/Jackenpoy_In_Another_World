package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Dullahan extends Characters {
    public Dullahan(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral4_human:R.drawable.demongeneral4_demon;
        this.charName = "Dullahan(Demon)";
    }
}