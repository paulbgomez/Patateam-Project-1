package com.ironhack.main;

import com.ironhack.Character.Character;
import com.ironhack.Character.Warrior;
import com.ironhack.Character.Wizard;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.ironhack.Character.Character.SUFFIX;


public class Party {

    private final List<Character> characterList;

    public Party() {
        characterList = new ArrayList<>();
    }

    public Party(int size){
        this();
        Random random = new Random();
        List<String> nameList = new ArrayList<>();
        for(int i=0; i<size; i++){
            Character character;
            if (random.nextBoolean()){
                character = Warrior.createRandomCharacter();
            } else {
                character = Wizard.createRandomCharacter();
            }
            while (nameList.contains(character.getName())){
                character.setName(character.getName()+SUFFIX);
            }
            nameList.add(character.getName());
            addCharacter(character);
        }
    }

    public boolean hasCharacters() {
        return characterList.size() > 0;
    }

    public void addCharacter(Character character) {
        characterList.add(character);
    }

    public void removeCharacter(Character character) {
        characterList.remove(character);
    }

    public Character getCharacter(int index) {
        return characterList.get(index);
    }

    public Character getCharacter() {
        Random random = new Random();
        return getCharacter(random.nextInt(characterList.size()));
    }

    public Character selectCharacterByID(int id) {
        for(Character character: characterList) {
            if (character.getId() == id)
                return character;
        }
        return null;
    }

    // exportar a CSV
    public void exportCSV() throws IOException {
        FileWriter fileWriter = new FileWriter("Heroes.csv", false);
        for(Character character: characterList)
            fileWriter.write(character.toCSV() + "\n");
        fileWriter.close();
    }

    // importar desde CSV
    public void importCSV() throws IOException {
        characterList.clear();
        File file = new File("Heroes.csv");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
            addCharacter(Character.fromCSV(scanner.nextLine()));
        scanner.close();
    }


    public List<Character> getCharacterList() {
        return characterList;
    }


    @Override
    public String toString() {
        return "\n" + characterList.stream()
                .map(Character::showCharacter)
                .collect(Collectors.joining("\n"));

//        String charactersPerLine="\n";
//
//        for (Character character : characterList){
//            charactersPerLine += character.showCharacter() + "\n";
//        }
//
//        return charactersPerLine;
    }
}

