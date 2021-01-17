package com.ironhack.main;

import com.ironhack.Character.Warrior;
import com.ironhack.Character.Wizard;

import java.util.*;

// FIESTAAAA
public class Party {
    private static List<Object> partyTeam1 = new ArrayList<>();
    private static List<Object> partyTeam2 = new ArrayList<>();
    private static List<Object> graveYard = new ArrayList<>();


    //Generate random party size between 0 and 10
    private static Random randomNumber = new Random();
    private static int randomPartySize = (randomNumber.nextInt(10)) + 1;

    // Constructor con número de miembros de party que hace party random

    //Constructor vacío full random

    // Constructor con arraylist de miembros

    // static crear party desde el menú. Checkear si se puede añadir tanto warrior como wizard
    public static void addCharacter(Character newCharacter, List<Character> partyTeam) {
        partyTeam.add(newCharacter);
    }

    // send to graveyard (index, graveyard)

    // export this party

    // static que importe y devuelva la party o Contructor que importe

    // getRandom() y get(index)
    public static Object createRandomCharacter(){
        if(Math.random() > .5){
            int randomHp = 99 + (int) Math.ceil(Math.random() * 101);
            int randomStamina = 9 + (int) Math.ceil(Math.random() * 41);
            int randomStrength = (randomNumber.nextInt(10)) + 1;
            String randomName; //sacar de array nombres
            //llamar al metodo estatico de id
            Warrior randomWarrior = new Warrior(1, "Juan", randomHp, true, randomStamina, randomStrength);
            return randomWarrior;
        } else {
            int randomHp = 49 + (int) Math.ceil(Math.random() * 51);
            int randomMana = 9 + (int) Math.ceil(Math.random() * 41);
            int randomIntelligence = 1 + (int) Math.ceil(Math.random() * 49);
            String randomName;//sacar de array nombres
            //llamar al metodo estatico de id
            Wizard randomWizard = new Wizard(1, "Juan", randomHp, true, randomMana, randomIntelligence);
            return randomWizard;
        }
    }

    public static void createRandomParty(int selectedListFromMenu) {
        if(selectedListFromMenu == 1){
            for(int i = 0; i <= randomPartySize; i++){
                partyTeam1.add(createRandomCharacter());
            }
        } else {
            for(int i = 0; i <= randomPartySize; i++){
                partyTeam2.add(createRandomCharacter());
            }
        }
    }


}

