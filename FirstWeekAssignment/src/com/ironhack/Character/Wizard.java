package com.ironhack.Character;

import com.ironhack.Interface.Attacker;
import com.ironhack.Character.Character;

import java.util.ArrayList;
import java.util.List;
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

    // Constructor para la carga desde CSV
    public Wizard(int id, String name, int hp, int mana, int intelligence) {
        this(name, hp, mana, intelligence);
        setId(id);
    }

    // Methods ----------------------------

    // Attack
    public void attack(Character character) {
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
        //return attackValue;
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

    public int getSecondParameter() {
        return getIntelligence();
    }

    public String getCharacterType() {
        return CHARACTER_WIZARD;
    }

    public Wizard createRandomCharacter() {

        int id = Character.generateId();

        Random random = new Random();

        String name = getRandomName();

        // isWizard
        int hp = random.nextInt(WIZARD_HP_MAX - WIZARD_HP_MIN + 1) + WIZARD_HP_MIN;
        int mana = random.nextInt(WIZARD_MANA_MAX - WIZARD_MANA_MIN + 1) + WIZARD_MANA_MIN;
        int intelligence = random.nextInt(WIZARD_INTELLIGENCE_MAX - WIZARD_INTELLIGENCE_MIN + 1) + WIZARD_INTELLIGENCE_MIN;

        return new Wizard(id, name, hp, mana, intelligence);
    }

}
