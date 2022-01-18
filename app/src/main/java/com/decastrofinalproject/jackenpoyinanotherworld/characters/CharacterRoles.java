package com.decastrofinalproject.jackenpoyinanotherworld.characters;

public class CharacterRoles {
    private Character[] enemyGenerals;
    private Character enemyLeader;
    private Character[] allyGenerals;
    private Character allyLeader;

    public CharacterRoles(String side) {
        enemyLeader = side.equals("humans")?new Zeldris(side):new Ludociel(side);
        allyLeader = side.equals("humans")?new Ludociel(side):new Zeldris(side);
        enemyGenerals = side.equals("humans")?new Character[]{new Cain(side), new Dullahan(side), new Shisandan(), new Ares(side), new Charlatan(side), new Ruthven(side), new Derieri(side), new Merlin(side), new Igzdukyz(side), new LaBete(side)}: new Character[]{new Guila(side), new Dreyfus(side), new Hendrickson(side), new Matrona(side), new Dianne(side), new King(side), new Elaine(side), new Vaizel(side), new Elizabeth(side), new Escanor(side)};
        allyGenerals = side.equals("humans")?new Character[]{new Guila(side), new Dreyfus(side), new Hendrickson(side), new Matrona(side), new Dianne(side), new King(side), new Elaine(side), new Vaizel(side), new Elizabeth(side), new Escanor(side)}: new Character[]{new Cain(side), new Dullahan(side), new Shisandan(), new Ares(side), new Charlatan(side), new Ruthven(side), new Derieri(side), new Merlin(side), new Igzdukyz(side), new LaBete(side)};
    }

    public Character[] getAllyGenerals(){
        return allyGenerals;
    }

    public Character[] getEnemyGenerals(){
        return enemyGenerals;
    }

    public Character getEnemyGeneralForThisRound(int round){
        return enemyGenerals[round - 1];
    }

    public Character getEnemyLeader(){
        return enemyLeader;
    }

    public Character getAllyLeader(){
        return allyLeader;
    }
}
