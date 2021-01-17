package com.ironhack.Character;

import com.ironhack.Interface.Attacker;

public class Wizard extends Character implements Attacker {
    // Properties
    private static final int minMana = 10;
    private static final int minInt = 1;
    private int mana;
    private int intelligence;

    // Constructor --> no habria que pasarle el ID ni el isAlive no??
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    // Methods ----------------------------

    // Attack
    @Override
    public int attack() {
        int attackValue = 0;
        if (getMana() >= 5) {
            attackValue = intelligence;
            updateMana(getMana()-5);
            System.out.println(getName() + " chamusca a su oponente y le quita" + attackValue + "puntos de vida");
        } else {
            attackValue = 2;
            updateMana(getMana()+1);
            System.out.println(getName() + " acaricia con su varita a su oponente y le quita " + attackValue + " puntos de vida de la verguenza ajena que da");
        }
        return attackValue;
    }

    // Update Mana
    public void updateMana(int mana) {
        this.mana = mana;
    }

    // Getters & Setters
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
