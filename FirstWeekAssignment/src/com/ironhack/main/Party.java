package com.ironhack.main;

import java.util.*;

// FIESTAAAA
public class Party {
    private List<Character> npcs;

    //Generate random party size between 0 and 10
    Random random = new Random();
    private int randomPartySize = (random.nextInt(10)) + 1;

    // Constructor con número de miembros de party que hace party random

    //Constructor vacío full random
    public Party() {
        List<Character> npcs = createRandomParty();
    }

    // Constructor con arraylist de miembros

    // static crear party desde el menú

    // send to graveyard (index, graveyard)

    // export this party

    // static que importe y devuelva la party o Contructor que importe

    // getRandom() y get(index)
    public List<Character> createRandomParty() {
       int innerParty = getRandomPartySize();
       for(int i = innerParty; i > 0; i--){
           i % 2 == 0 ? npcs.add(generateRandomWizard) : npcs.add(generateRandomWarrior);
       }
       return npcs;
    }

    public int getRandomPartySize() {
        return randomPartySize;
    }

    public List<Character> getNpcs() {
        return npcs;
    }
}

