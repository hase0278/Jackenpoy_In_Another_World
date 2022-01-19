package com.decastrofinalproject.jackenpoyinanotherworld.characters;

public class CharacterRoles {
    private Characters[] enemyGenerals;
    private Characters enemyLeader;
    private Characters[] allyGenerals;
    private Characters allyLeader;

    public CharacterRoles(String side) {
        enemyLeader = side.equals("human")?new Zeldris(side):new Ludociel(side);
        allyLeader = side.equals("human")?new Ludociel(side):new Zeldris(side);
        enemyGenerals = side.equals("human")?new Characters[]{new Cain(side), new Dullahan(side), new Shisandan(), new Ares(side), new Charlatan(side), new Ruthven(side), new Derieri(side), new Merlin(side), new Igzdukyz(side), new LaBete(side)}: new Characters[]{new Guila(side), new Dreyfus(side), new Hendrickson(side), new Matrona(side), new Dianne(side), new King(side), new Elaine(side), new Vaizel(side), new Elizabeth(side), new Escanor(side)};
        allyGenerals = side.equals("human")?new Characters[]{new Guila(side), new Dreyfus(side), new Hendrickson(side), new Matrona(side), new Dianne(side), new King(side), new Elaine(side), new Vaizel(side), new Elizabeth(side), new Escanor(side)}: new Characters[]{new Cain(side), new Dullahan(side), new Shisandan(), new Ares(side), new Charlatan(side), new Ruthven(side), new Derieri(side), new Merlin(side), new Igzdukyz(side), new LaBete(side)};
    }

    public Characters[] getAllyGenerals(){
        return allyGenerals;
    }

    public Characters[] getEnemyGenerals(){
        return enemyGenerals;
    }

    public Characters getEnemyGeneralForThisRound(int round){
        enemyGenerals[round - 1].setHp(100 * round);
        enemyGenerals[round - 1].setDmg(50);
        enemyGenerals[round - 1].setMultiplier(round);
        return enemyGenerals[round - 1];
    }

    public Characters getEnemyLeader(){
        enemyLeader.setDmg(1000);
        enemyLeader.setMultiplier(1);
        enemyLeader.setHp(2000);
        return enemyLeader;
    }

    public Characters getAllyLeader(){
        return allyLeader;
    }
}
