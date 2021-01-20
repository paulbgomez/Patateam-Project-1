package com.ironhack.main;

import com.ironhack.Character.Character;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {
    private final List<Character> graveyardList;

    public Graveyard() {
        graveyardList = new ArrayList<>();
    }

    public void addCharacterToGraveyard(Character character) {
        graveyardList.add(character);
    }

    @Override
    public String toString() {
        if(getGraveyardList().size() == 0){
            return "+++ The Graveyard is empty +++";
        } else {
            String graveyardDeaths = "The Graveyard is filled with the souls of \n";
            for (int i = 0; i < getGraveyardList().size(); i++) {
                graveyardDeaths += getGraveyardList().get(i).getName() + ", a brave " + getGraveyardList().get(i).getCharacterType();
            }
            return graveyardDeaths;
        }
    }

    public List<Character> getGraveyardList() {
        return graveyardList;
    }
}
