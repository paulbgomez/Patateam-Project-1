package com.ironhack.Character;

import java.util.Random;

public class Warrior extends Character /*implements Attacker*/{

    private static final int WARRIOR_HP_MIN = 100;
    private static final int WARRIOR_HP_MAX = 200;
    private static final int WARRIOR_STAMINA_MIN = 10;
    private static final int WARRIOR_STAMINA_MAX = 50;
    private static final int WARRIOR_STRENGTH_MIN = 1;
    private static final int WARRIOR_STRENGTH_MAX = 10;

    // Properties
    private static final int minStamina = 10;
    private static final int minStr = 1;
    private int stamina;
    private int strength;

    // Constructor
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }


    // Methods -----------------------------

    // Attack
    public void attack(Character character) {
        int attackValue;
        if (getStamina() >= 5) {
            attackValue = getStrength();
            updateStamina(getStamina()-5);
            System.out.println(getName() + " mete un hachazo a " + character.getName() + " y le deja del revés, quitándole " + attackValue +" puntos de vida");
        } else {
            attackValue = getStrength()/2;
            updateStamina(getStamina()+1);
            System.out.println(getName() + " le pega un capón a " + character.getName() + " y le quita " + attackValue + " puntos de vida");
        }
        character.decreaseHp(attackValue);
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

    public int getFirstParameter() {
        return getStamina();
    }

    public String getFirstParameterName() {
        return "Resistencia";
    }

    public int getSecondParameter() {
        return getStrength();
    }
    public String getSecondParameterName() {
        return "Fuerza";
    }

    public String getCharacterType() {
        return CHARACTER_WARRIOR;
    }

    public static Warrior createRandomCharacter() {

        Random random = new Random();

        String name = getRandomName();

        int hp = random.nextInt(WARRIOR_HP_MAX - WARRIOR_HP_MIN + 1) + WARRIOR_HP_MIN;
        int stamina = random.nextInt(WARRIOR_STAMINA_MAX - WARRIOR_STAMINA_MIN + 1) + WARRIOR_STAMINA_MIN;
        int strength = random.nextInt(WARRIOR_STRENGTH_MAX - WARRIOR_STRENGTH_MIN + 1) + WARRIOR_STRENGTH_MIN;
        return new Warrior(name, hp, stamina, strength);
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "Name=" + this.getName() +
                ", Health Points=" + this.getHp() +
                ", Stamina=" + stamina +
                ", Strength=" + strength +
                '}';
    }
}
