package com.ironhack.Character;

import com.ironhack.Interface.Attacker;

public class Warrior extends Character implements Attacker {
    // Properties
    private static final int minStamina = 10;
    private static final int minStr = 1;
    private int stamina;
    private int strength;

    // Constructor --> no habria que pasarle el ID ni el isAlive no??
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    // Methods -----------------------------

    // Attack
    @Override
    public int attack() {
        int attackValue = 0;
        if (getStamina() >= 5) {
            attackValue = strength;
            updateStamina(getStamina()-5);
            System.out.println(getName() + " mete un hachazo a su oponente y le deja del revés, quitándole " + attackValue +" puntos de vida");
        } else {
            attackValue = strength/2;
            updateStamina(getStamina()+1);
            System.out.println(getName() + " le pega un capón a su oponente y le quita " + attackValue + " puntos de vida");
        }
        return attackValue;
    }

    // Update stamina
    public void updateStamina(int stamina) {
        this.stamina= stamina;
    }

    // Getters & Setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(stamina, minStamina);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(strength, minStr);
    }
}
