package com.decastrofinalproject.jackenpoyinanotherworld.characters;

public class Characters {
    protected int hp;
    protected int characterImg;
    protected int dmg;
    protected int multiplier;

    public void setHp(int hp){
        this.hp = hp;
    }
    public void setCharacterImg(int characterImg){
        this.characterImg = characterImg;
    }
    public void setDmg(int dmg){
        this.dmg = dmg;
    }
    public void setMultiplier(int multiplier){
        this.multiplier = multiplier;
    }

    public int getHp() {
        return hp;
    }

    public int getCharacterImg() {
        return characterImg;
    }

    public int getDmg() {
        return dmg;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
