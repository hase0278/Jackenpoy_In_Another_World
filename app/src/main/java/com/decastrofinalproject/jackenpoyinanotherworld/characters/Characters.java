package com.decastrofinalproject.jackenpoyinanotherworld.characters;

public class Characters implements Character{
    protected int hp;
    protected int characterImg;
    protected int dmg;
    protected int multiplier;
    protected String charName;

    public void setHp(int hp){
        this.hp = hp;
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
        return dmg * multiplier;
    }

    @Override
    public String getName() {
        return charName;
    }
}
