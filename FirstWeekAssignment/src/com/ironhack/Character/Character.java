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
            "Raharad","Ozahl","Troronin","Erune","Kribin","Irodalf","Oxium","Irhan","Iveprix","Oligast",
            "Gwen LightBolt", "Harald Ulmer", "Mordecai el Nigromante", "Kendra la Trituradora", "Tentáculo Púrpura",
            "Minerva Garra de Cuervo", "Feanwyn SlashHammer", "El Barón Rojo", "Lorelei Susurramentes", "LeChuck",
            "Hittokiri Battousai", "Hanzo Hasashi", "Lord Gilmoure", "Riddles", "Magnus de la Tormenta",
            "Circe ShapeShifter", "Sir Isaac Manzana Pesada", "Altaïr Mirada Certera", "Úrsula de los ocho brazos",
            "Tycho Visión Penetrante", "Deckard Caín", "Mara la de la Vara", "Malfurion Tempestira",
            "Fidda Cabello de Plata", "Grom el Terrible", "Lilith", "Lisbeth", "Sir Graham", "Amanra del Cetro Dorado",
            "Allen de la Sombra Gris", "Nymphadora", "Erwin WaveBreaker", "Erestor Puño de Hierro", "Leonardo",
            "Donatello", "Raphael", "Michelangello", "Splinter", "Shredder", "Raiden", "Heisenberg el Indeciso",
            "El Mago Blanco", "Morgana", "Eyra Rompehuesos", "Sigrid Ojos Gélidos", "Vilhelm el Atroz",
            "Bjorn Zarpa de Oso", "Stephen el Rey Halcón", "Natasha Lanza Brasas", "Grimmwolf", "StarKiller",
            "Pirata Feo", "Olwen de las Nieves", "Finn", "Jake", "Amaterasu", "Atreus", "Sybil Snake",
            "Kaylee la Luciérnaga", "Rubik RompeCabezas", "Elentari", "Gweon Barba Cana", "Tarian StormShield",
            "Kyla Lanzaveloz", "Zelda", "Roy Mustang", "Wulfric el Pecas", "Lady Vulture", "Ragnar Lothbrook",
            "Esteban Trabajos fundador de la Manzana", "Guillermo Puertas fundador de la Ventana", "Patata",
            "Fray Perico", "Calcetín", "El guerrillero Martín", "El Pirata Garrapata"
    };
    public static final String SUFFIX = " Jr.";

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
        setAlive(true);
    }

    // Methods --------------------------


    public abstract void attack(Character character);

    // Update Hp --> Falta llamar al metodo sendtograveyard??
    public void decreaseHp (int attackValue) {
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
    public String showCharacter() {

        String characterAttributesListed =
                "ID-" + getId() +
                        " Tipo: " + getCharacterType()
                        + " | Nombre: " + getName() +
                        " | Vida: " + getHp() +
                        " | " + getFirstParameterName() + ": " + getFirstParameter() +
                        " | " + getSecondParameterName() + ": " + getSecondParameter();

        return characterAttributesListed;
    }

    public static Character fromCSV(String csvString) {
        String[] values = csvString.split(", ");
        int id = Integer.parseInt(values[0]);
        String name = values[1];
        String characterType = values[2];
        int hp = Integer.parseInt(values[3]);
        int firstParameter = Integer.parseInt(values[4]);
        int secondParameter = Integer.parseInt(values[5]);

        return switch (characterType) {
            case CHARACTER_WARRIOR -> new Warrior(id, name, hp, firstParameter, secondParameter);
            case CHARACTER_WIZARD -> new Wizard(id, name, hp, firstParameter, secondParameter);
            default -> null;
        };
    }

    public abstract int getFirstParameter();
    public abstract String getFirstParameterName();
    public abstract int getSecondParameter();
    public abstract String getSecondParameterName();
    public abstract String getCharacterType();

//    public abstract static Character createRandomCharacter();

    protected static String getRandomName() {
        Random random = new Random();
        return CHARACTER_NAMES[random.nextInt(CHARACTER_NAMES.length)];
    }
}
