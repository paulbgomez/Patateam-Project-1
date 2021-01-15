package com.ironhack.Character;

import com.ironhack.Interface.Attacker;

public class Wizard extends Character implements Attacker {
    private static final int minMana = 10;
    private static final int minInt = 1;
    private int mana;
    private int intelligence;

    public Wizard(int id, String name, int hp, boolean isAlive, int mana, int intelligence) {
        super(id, name, hp, isAlive);
        setMana(mana);
        setIntelligence(intelligence);
    }

    @Override
    public int attack(int element) {
        // TODO: ángel
        return 0;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(mana, minMana);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = Math.max(intelligence, minInt);
    }
}
