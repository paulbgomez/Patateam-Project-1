package com.ironhack.Character;

import com.ironhack.Interface.Attacker;
import com.ironhack.main.Party;

import java.util.Random;

public abstract class Character implements Attacker {

    public final static String CHARACTER_WARRIOR = "Warrior";
    public final static String CHARACTER_WIZARD = "Wizard";

    private static final String[] CHARACTER_NAMES = {
            "Aphior","Ulineth","Stratorn","Aqirax","Idroviar","Ondodalf","Egavius","Ogeqihr","Qrubarin","Izudor",
            "Enior","Uzirnas","Manoran","Anitarish","Iqill","Odesorin","Udegreth","Sheveus","Usiprix","Uzelyn",
            "Raharad","Ozahl","Troronin","Erune","Kribin","Irodalf","Oxium","Irhan","Iveprix","Oligast"
    };
    public static final String SUFFIX = "_Jr";

    // Properties
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;

    // referencia al equipo al que pertenece
    private Party party;

    // para generar IDs únicos
    private static int idGenerator = 0;

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
            setHp(0);
            setAlive(false);
        }
    }


    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setId() {
//        int count = 1;
//        this.id = count;
//        count++;
        // el ID tiene que ser único entre todos los Character
        this.id = generateId();
    }

    public static int generateId() {
        return idGenerator++;
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

    public abstract void attack(Character character);

    public String toCSV() {

        String csvString =
                getId() + ", " +
                getName() + ", " +
                getCharacterType() + ", " +
                getHp() + ", " +
                getFirstParameter() + ", " +
                getSecondParameter();

        return csvString;
    }

    public static Character fromCSV(String csvString) {
        String[] values = csvString.split(", ");
        int id = Integer.parseInt(values[0]);
        String name = values[1];
        String characterType = values[2];
        int hp = Integer.parseInt(values[3]);
        int firstParameter = Integer.parseInt(values[4]);
        int secondParameter = Integer.parseInt(values[5]);

        switch (characterType) {
            case CHARACTER_WARRIOR:
                return new Warrior(id, name, hp, firstParameter, secondParameter);
            case CHARACTER_WIZARD:
                return new Wizard(id, name, hp, firstParameter, secondParameter);
            default:
                return null;
        }
    }

    public abstract int getFirstParameter();
    public abstract int getSecondParameter();
    public abstract String getCharacterType();

    public abstract Character createRandomCharacter();

    protected String getRandomName() {
        Random random = new Random();
        return CHARACTER_NAMES[random.nextInt(CHARACTER_NAMES.length)];
    }
}
