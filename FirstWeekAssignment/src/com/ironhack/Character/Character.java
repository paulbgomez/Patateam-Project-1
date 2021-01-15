package com.ironhack.Character;

public abstract class Character {
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(int id, String name, int hp, boolean isAlive) {
        setId(id);
        setName(name);
        setHp(hp);
        setAlive(isAlive);
    }

    // perder vida

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
