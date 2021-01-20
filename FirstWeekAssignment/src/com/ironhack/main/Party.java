package com.ironhack.main;

import com.ironhack.Character.Character;
import com.ironhack.Character.Warrior;
import com.ironhack.Character.Wizard;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static com.ironhack.Character.Character.SUFFIX;


public class Party {
//    private static List<Object> partyTeam1 = new ArrayList<>();
//    private static List<Object> partyTeam2 = new ArrayList<>();
//    private static List<Object> graveYard = new ArrayList<>();
    private final List<Character> characterList;

    //Headers and separators for the CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String LINE_SEPARATOR = "\n";
    private static final String HEADER = "id,Type,Name,hp,First attribute,Second attribute";

    //Generate random party size between 0 and 10
    private static Random randomNumber = new Random();
    private static int randomPartySize = (randomNumber.nextInt(10)) + 1;


    // Constructor con número de miembros de party que hace party random

    //Constructor vacío
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
            if (nameList.contains(character.getName())){
                nameList.add(character.getName()+SUFFIX);
                character.setName(character.getName()+SUFFIX);
            } else {
                nameList.add(character.getName());
            }
            addCharacter(character);
        }
    }
    // Constructor con arraylist de miembros

    // static crear party desde el menú. Checkear si se puede añadir tanto warrior como wizard
//    public static void addCharacter(Character newCharacter, List<Object> partyTeam) {
//        partyTeam.add(newCharacter);
//    }

    public boolean hasCharacters() {
        return characterList.size() > 0;
    }

    public void addCharacter(Character character) {
        characterList.add(character);
    }

    private void removeCharacter(Character character) {
        characterList.remove(character);
    }

    private Character selectCharacter(int index) {
        Character character = characterList.get(index);
        removeCharacter(character);
        return character;
    }

    public Character selectCharacter() {
        Random random = new Random();
        return selectCharacter(random.nextInt(characterList.size()));
    }

    public Character selectCharacterByID(int id) {
        for(Character character: characterList) {
            if (character.getId() == id)
                return character;
        }
        return null;
    }

    // send to graveyard (index, graveyard)
//    public static void sendToGraveyard(Object deadCharacter, List<Object> party){
//        for (Object myObj: party) {
//            if(myObj.equals(deadCharacter)){
//                party.remove(myObj);
//                graveYard.add(myObj);
//            }
//        }
//    }

    // export this party
//    public static void exportHeroesAsCSV() {
//        List empList = new ArrayList();
//        FileWriter exportedCSV = null;
//        try {
//            exportedCSV = new FileWriter("Heroes.csv");
//
//            //Adding the header
//            exportedCSV.append(HEADER);
//            //New Line after the header
//            exportedCSV.append(LINE_SEPARATOR);
//
//            //Iterate the empList
//            Iterator it = empList.iterator();
//            while (it.hasNext()) {
//                Character e = (Character) it.next();
//                exportedCSV.append(String.valueOf(e.//Method to get the id or generate it
//                        ));
//                exportedCSV.append(COMMA_DELIMITER);
//                exportedCSV.append(e.//Method for the type);
//                );
//                exportedCSV.append(COMMA_DELIMITER);
//                exportedCSV.append(e.//Method for the name);
//                );
//                exportedCSV.append(COMMA_DELIMITER);
//                exportedCSV.append(String.valueOf(e.//Method to get hp
//                        ));
//                exportedCSV.append(LINE_SEPARATOR);
//                exportedCSV.append(String.valueOf(e.//Method to get first att
//                ));
//                exportedCSV.append(COMMA_DELIMITER);
//                exportedCSV.append(String.valueOf(e.//Method to get second att
//                ));
//                exportedCSV.append(LINE_SEPARATOR);
//            }
//            System.out.println("Write to CSV file Succeeded!!!");
//        } catch (Exception ee) {
//            ee.printStackTrace();
//        } finally {
//            try {
//                exportedCSV.close();
//            } catch (IOException ie) {
//                System.out.println("Error occured while closing the CSV");
//                ie.printStackTrace();
//            }
//        }
//    }

    // importar desde CSV
    public void exportCSV() throws IOException {
        FileWriter fileWriter = new FileWriter("Heroes.csv", false);
        for(Character character: characterList)
            fileWriter.write(character.toCSV() + "\n");
        fileWriter.close();
    }

    // exportar a CSV
    public void importCSV() throws IOException {
        characterList.clear();
        File file = new File("Heroes.csv");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
            addCharacter(Character.fromCSV(scanner.nextLine()));
        scanner.close();
    }


    // static que importe y devuelva la party o Contructor que importe

    // getRandom() y get(index)
//    public static Object createRandomCharacter(){
//        if(Math.random() > .5){
//            int randomHp = 99 + (int) Math.ceil(Math.random() * 101);
//            int randomStamina = 9 + (int) Math.ceil(Math.random() * 41);
//            int randomStrength = (randomNumber.nextInt(10)) + 1;
//            String randomName; //sacar de array nombres
//            //llamar al metodo estatico de id
//            Warrior randomWarrior = new Warrior(1, "Juan", randomHp, true, randomStamina, randomStrength);
//            return randomWarrior;
//        } else {
//            int randomHp = 49 + (int) Math.ceil(Math.random() * 51);
//            int randomMana = 9 + (int) Math.ceil(Math.random() * 41);
//            int randomIntelligence = 1 + (int) Math.ceil(Math.random() * 49);
//            String randomName;//sacar de array nombres
//            //llamar al metodo estatico de id
//            Wizard randomWizard = new Wizard(1, "Juan", randomHp, true, randomMana, randomIntelligence);
//            return randomWizard;
//        }
//    }
//
//    public static void createRandomParty(int selectedListFromMenu) {
//        if(selectedListFromMenu == 1){
//            for(int i = 0; i <= randomPartySize; i++){
//                partyTeam1.add(createRandomCharacter());
//            }
//        } else {
//            for(int i = 0; i <= randomPartySize; i++){
//                partyTeam2.add(createRandomCharacter());
//            }
//        }
//    }


}

