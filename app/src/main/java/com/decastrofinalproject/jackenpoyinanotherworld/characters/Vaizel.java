package com.decastrofinalproject.jackenpoyinanotherworld.characters;

import com.decastrofinalproject.jackenpoyinanotherworld.R;

public class Vaizel extends Characters {
   public Vaizel(String side){
       this.characterImg = side.equals("human")?R.drawable.vaizel_human:R.drawable.vaizel_demon;
       this.charName = "Vaizel(Beastman)(General)";
   }
}
