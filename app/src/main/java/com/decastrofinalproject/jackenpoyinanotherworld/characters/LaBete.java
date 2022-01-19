package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class LaBete extends Characters {
    public LaBete(String side){
        this.characterImg = side.equals("human")?R.drawable.demongeneral10_human:R.drawable.demongeneral10_demon;
        this.charName = "La Bete(Demon)(General/Right hand men of demon lord)";
    }
}