package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class King extends Characters{
    public King(String side){
        this.characterImg = side.equals("human")?R.drawable.king_human:R.drawable.king_demon;
        this.charName = "King(Fairy)";
    }
}
