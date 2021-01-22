package com.ironhack.main;

import com.ironhack.Character.Character;
import com.ironhack.Character.Warrior;
import com.ironhack.Character.Wizard;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    // TODO: cambiar esto pa sólo acceder a las partys a partir del battleSimulator
    static BattleSimulator battleSimulator = new BattleSimulator();
    static Party party1 = new Party();
    static Party party2 = new Party();

    // TODO: mostrar el número de miembros siempre que sea relevante
    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    public static void mainMenu() throws IOException {

        printMainMenuOptions();
        String option = sc.nextLine();

        while (!option.equals("8")) {
            switch (option) {
                case "1" -> createMenu();
                case "2" -> randomMenu();
                case "3" -> importMenu();
                case "4" -> exportMenu();
                case "5" -> printParties();
                case "6" -> System.out.println(battleSimulator.getGraveyard());
                case "7" -> warMenu();
                case "1729" -> System.out.println("Feliz viaje en taxi!!!");
                default -> System.out.println("Elige una opción válida con el teclado:");
            }
            printMainMenuOptions();
            option = sc.nextLine();
        }
    }

    private static void printParties() {
        System.out.println("Equipo 1:\n" + party1);
        System.out.println("Equipo 2:\n" + party2);
    }

    private static void printMainMenuOptions() {
        System.out.println("============ Patapasillo war ============\n");
        System.out.println("1- Crear personajes y equipos manualmente");
        System.out.println("2- Crear equipos enteros aleatoriamente");
        System.out.println("3- Importar un equipo desde un archivo .csv");
        System.out.println("4- Exportar equipo existente a un archivo .csv");
        System.out.println("5- Mostrar equipos si ya existen");
        System.out.println("6- Ver personajes muertos");
        System.out.println("7- ¡Guerra entre los equipos!");
        System.out.println("8- Mandar esto a tomar por culo :)\n");
    }

    public static void createMenu() {
        printCreateMenuOptions();
        String option = sc.nextLine();

        while (option.equals("1") || option.equals("2")){
            inputDataForCharacters(Integer.parseInt(option));
            printCreateMenuOptions();
            option = sc.nextLine();
        }
    }

    private static void printCreateMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("            Crear personajes\n");
        System.out.println("1- Crear personaje para el equipo 1");
        System.out.println("2- Crear personaje para el equipo 2");
        System.out.println("3- Atrás\n");
    }

    public static void randomMenu(){
        Random random = new Random();
        int numeroRandom;

        printRandomMenuOptions();
        String option = sc.nextLine();

        while (!option.equals("3")){

            switch (option) {
                case "1" -> {
                    numeroRandom = random.nextInt(15) + 1;
                    party1 = new Party(numeroRandom);
                    System.out.println("El equipo " + option + " ha sido generado con " + numeroRandom + " miembros.");
                }
                case "2" -> {
                    numeroRandom = random.nextInt(15) + 1;
                    party2 = new Party(numeroRandom);
                    System.out.println("El equipo " + option + " ha sido generado con " + numeroRandom + " miembros.");
                }
                default -> System.out.println("Elige una opción válida con el teclado");
            }

            printRandomMenuOptions();
            option = sc.nextLine();
        }

    }

    private static void printRandomMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("       Generar equipo aleatorio\n");
        System.out.println("1- Generar equipo 1");
        System.out.println("2- Generar equipo 2");
        System.out.println("3- Atrás\n");
    }

    public static void importMenu() throws IOException {

        printImportMenuOptions();
        String option = sc.nextLine();

        while (!option.equals("3")){
            switch (option) {
                case "1" -> {
                    party1 = new Party();
                    party1.importCSV();
                    System.out.println("El equipo " + option + " ha sido importado desde el archivo .csv.");
                }
                case "2" -> {
                    party2 = new Party();
                    party2.importCSV();
                    System.out.println("El equipo " + option + " ha sido importado desde el archivo .csv.");
                }
                default -> System.out.println("Elige una opción válida con el teclado");
            }
            printImportMenuOptions();
            option = sc.nextLine();
        }
    }

    private static void printImportMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("            Importar equipos\n");
        System.out.println("1- Importar equipo 1");
        System.out.println("2- Importar equipo 2");
        System.out.println("3- Atrás\n");
    }

    // TODO: decidir si una party vacía se puede exportar y poner if si no
    public static void exportMenu() throws IOException {

        printExportMenuOptions();
        String option = sc.nextLine();

        while (!option.equals("3")){

            switch (option) {
                case "1" -> {
                    party1.exportCSV();
                    System.out.println("El equipo " + option + " ha sido exportado al archivo .csv.");
                }
                case "2" -> {
                    party2.exportCSV();
                    System.out.println("El equipo " + option + " ha sido exportado al archivo .csv.");
                }
                default -> System.out.println("Elige una opción válida con el teclado");
            }

            printExportMenuOptions();
            option = sc.nextLine();
        }
    }

    private static void printExportMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("            Exportar equipos\n");
        System.out.println("1- Exportar equipo 1");
        System.out.println("2- Exportar equipo 2");
        System.out.println("3- Atrás\n");
    }

    public static void warMenu() {
        battleSimulator = new BattleSimulator(party1, party2, battleSimulator.getGraveyard());

        String option = "valor pa que no pete";

        while (!option.equals("3")) {
            if (battleSimulator.getParty1().hasCharacters() && battleSimulator.getParty2().hasCharacters()){
                printWarMenuOptions();
                option = sc.nextLine();
            } else {
                System.out.println("Al menos un equipo está vacío, volviendo al menú principal...");
                option = "3";
            }

            switch (option) {
                case "1" -> duelMenu();
                case "2" -> battleSimulator.fullBattle();
                case "3" -> System.out.println();
                default -> System.out.println("Elige una opción válida con el teclado");
            }
        }

    }

    private static void duelMenu() {
        System.out.println("Elegir combatiente del equipo 1 para el duelo");
        System.out.println("Número del 0 al " + (party1.getCharacterList().size() - 1));
        int index1 = Integer.parseInt(sc.nextLine());
        System.out.println("Elegir combatiente del equipo 2 para el duelo");
        System.out.println("Número del 0 al " + (party2.getCharacterList().size() - 1));
        int index2 = Integer.parseInt(sc.nextLine());
        battleSimulator.duel(index1, index2);
    }

    private static void printWarMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("               ¡Batalla!\n");
        System.out.println("1- Elegir combatientes a mano");
        System.out.println("2- Batalla completa automática");
        System.out.println("3- Atrás\n");
    }

    public static void inputDataForCharacters(int partyNumber) {
        boolean whileBreaker = false;
        String charType = "";
        String charName;
        int charHP;
        int charStamina;
        int charStrength;
        int charMana;
        int charIntelligence;
        Character character;

        while (!whileBreaker){
            System.out.println("Elige el tipo de personaje (Warrior / Wizard):");
            charType = sc.nextLine();
            if (charType.equals("Warrior") || charType.equals("Wizard")){
                whileBreaker = true;
            }
        }
        System.out.println("Elige el nombre de tu " + charType + ":");
        charName = sc.nextLine();
        System.out.println("Elige la vida de " + charName + ":");
        charHP = sc.nextInt();
        sc.nextLine();


        switch (charType) {
            case "Warrior" -> {
                System.out.println("Elige la resistencia de " + charName + ":");
                charStamina = sc.nextInt();
                sc.nextLine();
                System.out.println("Elige la fuerza de " + charName + ":");
                charStrength = sc.nextInt();
                character = new Warrior(charName, charHP, charStamina, charStrength);
            }
            case "Wizard" -> {
                System.out.println("Elige el maná de " + charName + ":");
                charMana = sc.nextInt();
                sc.nextLine();
                System.out.println("Elige la inteligencia de " + charName + ":");
                charIntelligence = sc.nextInt();
                character = new Wizard(charName, charHP, charMana, charIntelligence);
            }
            default -> throw new IllegalStateException("Unexpected value: " + charType);
        }
        switch (partyNumber) {
            case 1 -> party1.addCharacter(character);
            case 2 -> party2.addCharacter(character);
        }
        System.out.println(charName + " ha sido creado e incluído en el equipo " + partyNumber + ".");


    }
}