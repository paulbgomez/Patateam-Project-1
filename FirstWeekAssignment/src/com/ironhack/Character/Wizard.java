package com.ironhack.Character;

import java.util.Random;

public class Wizard extends Character /*implements Attacker */{

    private static final int WIZARD_HP_MIN = 50;
    private static final int WIZARD_HP_MAX = 100;
    private static final int WIZARD_MANA_MIN = 10;
    private static final int WIZARD_MANA_MAX = 50;
    private static final int WIZARD_INTELLIGENCE_MIN = 1;
    private static final int WIZARD_INTELLIGENCE_MAX = 50;

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
    public void attack(Character character) {
        int attackValue;
        if (getMana() >= 5) {
            attackValue = intelligence;
            updateMana(getMana()-5);
            System.out.println(getName() + " chamusca a " + character.getName() + " y le quita " + attackValue + " puntos de vida");
        } else {
            attackValue = 2;
            updateMana(getMana()+1);
            System.out.println(getName() + " acaricia con su varita a " + character.getName() + " y le quita " + attackValue + " puntos de vida de la verguenza ajena que da");
        }
        character.decreaseHp(attackValue);
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

    public int getFirstParameter() {
        return getMana();
    }

    public String getFirstParameterName() {
        return "Maná";
    }

    public int getSecondParameter() {
        return getIntelligence();
    }
    public String getSecondParameterName() {
        return "Inteligencia";
    }

    public String getCharacterType() {
        return CHARACTER_WIZARD;
    }

    public static Wizard createRandomCharacter() {

        Random random = new Random();

        String name = getRandomName();

        // isWizard
        int hp = random.nextInt(WIZARD_HP_MAX - WIZARD_HP_MIN + 1) + WIZARD_HP_MIN;
        int mana = random.nextInt(WIZARD_MANA_MAX - WIZARD_MANA_MIN + 1) + WIZARD_MANA_MIN;
        int intelligence = random.nextInt(WIZARD_INTELLIGENCE_MAX - WIZARD_INTELLIGENCE_MIN + 1) + WIZARD_INTELLIGENCE_MIN;

        return new Wizard(name, hp, mana, intelligence);
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "Name=" + this.getName() +
                ", Health Points=" + this.getHp() +
                ", Mana=" + mana +
                ", Intelligence=" + intelligence +
                '}';
    }
}
