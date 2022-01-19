package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class LaBete extends Characters {
    public LaBete(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral10_demon:R.drawable.demongeneral10_human;
        this.charName = "La Bete(Demon)(General)";
    }
}