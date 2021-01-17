package com.ironhack.Character;

public abstract class Character {
    // Properties
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;

    // Constructor
    public Character(String name, int hp) {
        setId();
        setName(name);
        setHp(hp);
        setAlive(true); // va asi?
    }

    // Methods --------------------------

    // Update Hp ??????????????? no se si se puede poner asi
    public void updateHp (int attackValue) {
        setHp(getHp()-attackValue);
        if (getHp() <= 0) {
            setAlive(false);
        }
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId() {
        int count = 1;
        this.id = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
    // no se si esto iria asi
    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }
}
