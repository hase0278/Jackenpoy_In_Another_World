package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;
public class Elaine extends Characters{
    public Elaine(String side) {
        this.characterImg = side.equals("human")?R.drawable.elaine_human:R.drawable.elaine_demon;
        this.charName = "Elaine(Fairy)(General)";
    }
}
