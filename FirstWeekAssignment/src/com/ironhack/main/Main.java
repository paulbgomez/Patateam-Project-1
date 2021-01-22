package com.ironhack.main;

import com.ironhack.Character.Character;
import com.ironhack.Character.Warrior;
import com.ironhack.Character.Wizard;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static BattleSimulator battleSimulator = new BattleSimulator();
    static Party party1;
    static Party party2;

    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    public static void mainMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);

        printMainMenuOptions();
        String option = scanOption.nextLine();

        while (!option.equals("8")) {
            switch (option){
                case "1":
                    createMenu();
                    break;
                case "2":
                    randomMenu();
                    break;
                case "3":
                    importMenu();
                    break;
                case "4":
                    exportMenu();
                    break;
                case "5":
                    if (party1 == null){
                        System.out.println("Equipo 1 aún vacío");
                    } else {
                        System.out.println("Equipo 1: " + party1);
                    }
                    if (party2 == null){
                        System.out.println("Equipo 2 aún vacío");
                    } else {
                        System.out.println("Equipo 2: " + party2);
                    }
                    break;
                case "6":
                    System.out.println(battleSimulator.getGraveyard());
                    break;
                case "7":
                    warMenu();
                    break;
                case "1729":
                    System.out.println("Feliz viaje en taxi!!!");
                    break;
                default:
                    System.out.println("Elige una opción válida con el teclado:");
            }

            printMainMenuOptions();
            option = scanOption.nextLine();
        }
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
        Scanner scanOption = new Scanner(System.in);

        printCreateMenuOptions();
        String option = scanOption.nextLine();

        while (option.equals("1") || option.equals("2")){
            inputDataForCharacters(Integer.parseInt(option));
            printCreateMenuOptions();
            option = scanOption.nextLine();
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
        Scanner scanOption = new Scanner(System.in);
        Random random = new Random();
        int numeroRandom;

        printRandomMenuOptions();
        String option = scanOption.nextLine();

        while (!option.equals("3")){

            switch (option){
                case "1":
                    numeroRandom = random.nextInt(15) + 1;
                    party1 = new Party(numeroRandom);
                    System.out.println("El equipo " + option + " ha sido generado con " + numeroRandom + " miembros.");
                    break;
                case "2":
                    numeroRandom = random.nextInt(15) + 1;
                    party2 = new Party(numeroRandom);
                    System.out.println("El equipo " + option + " ha sido generado con " + numeroRandom + " miembros.");
                    break;
                default:
                    System.out.println("Elige una opción válida con el teclado");
            }

            printRandomMenuOptions();
            option = scanOption.nextLine();
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
        Scanner scanOption = new Scanner(System.in);

        printImportMenuOptions();
        String option = scanOption.nextLine();

        while (!option.equals("3")){
            switch (option){
                case "1":
                    party1 = new Party();
                    party1.importCSV();
                    System.out.println("El equipo " + option + " ha sido importado desde el archivo .csv.");
                    break;
                case "2":
                    party2 = new Party();
                    party2.importCSV();
                    System.out.println("El equipo " + option + " ha sido importado desde el archivo .csv.");
                    break;
                default:
                    System.out.println("Elige una opción válida con el teclado");
            }
            printImportMenuOptions();
            option = scanOption.nextLine();
        }
    }

    private static void printImportMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("            Importar equipos\n");
        System.out.println("1- Importar equipo 1");
        System.out.println("2- Importar equipo 2");
        System.out.println("3- Atrás\n");
    }

    public static void exportMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);

        printExportMenuOptions();
        String option = scanOption.nextLine();

        while (!option.equals("3")){

            switch (option) {
                case "1":
                    if (party1 != null) {
                        party1.exportCSV();
                        System.out.println("El equipo " + option + " ha sido exportado al archivo .csv. Pulsa intro para continuar.");
                    } else {
                        System.out.println("El equipo " + option + " aún está vacío. No se puede exportar. Pulsa intro para continuar.");
                    }
                    break;
                case "2":
                    if (party2 != null) {
                        party2.exportCSV();
                        System.out.println("El equipo " + option + " ha sido exportado al archivo .csv. Pulsa intro para continuar.");
                    } else {
                        System.out.println("El equipo " + option + " aún está vacío. No se puede exportar. Pulsa intro para continuar.");
                    }
                    break;
                default:
                    System.out.println("Elige una opción válida con el teclado");
            }

            printExportMenuOptions();
            option = scanOption.nextLine();
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
        Scanner scanOption = new Scanner(System.in);
        battleSimulator = new BattleSimulator(party1, party2, battleSimulator.getGraveyard());

        printWarMenuOptions();
        String option = scanOption.nextLine();

        while (!option.equals("3")) {

            switch (option) {
                case "1":
                    System.out.println("Elegir combatiente del equipo 1 para el duelo");
                    System.out.println("Número del 0 al " + (party1.getCharacterList().size() - 1));
                    int index1 = Integer.parseInt(scanOption.nextLine());
                    System.out.println("Elegir combatiente del equipo 2 para el duelo");
                    System.out.println("Número del 0 al " + (party2.getCharacterList().size() - 1));
                    int index2 = Integer.parseInt(scanOption.nextLine());
                    battleSimulator.duel(index1, index2);
                    break;
                case "2":
                    battleSimulator.fullBattle();
                    break;
                default:
                    System.out.println("Elige una opción válida con el teclado");
            }
            printWarMenuOptions();
            option = scanOption.nextLine();
        }

    }

    private static void printWarMenuOptions() {
        System.out.println("============ Patapasillo war ============");
        System.out.println("               ¡Batalla!\n");
        System.out.println("1- Elegir combatientes a mano");
        System.out.println("2- Batalla completa automática");
        System.out.println("3- Atrás\n");
    }

    public static void inputDataForCharacters(int partyNumber) {
        Scanner scanner = new Scanner(System.in);
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
            charType = scanner.nextLine();
            if (charType.equals("Warrior") || charType.equals("Wizard")){
                whileBreaker = true;
            }
        }
        System.out.println("Elige el nombre de tu " + charType + ":");
        charName = scanner.nextLine();
        System.out.println("Elige la vida de " + charName + ":");
        charHP = scanner.nextInt();
        scanner.nextLine();


        switch (charType){
            case "Warrior":
                System.out.println("Elige la resistencia de " + charName + ":");
                charStamina = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Elige la fuerza de " + charName + ":");
                charStrength = scanner.nextInt();
                character = new Warrior(charName,charHP,charStamina,charStrength);
                break;
            case "Wizard":
                System.out.println("Elige el maná de " + charName + ":");
                charMana = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Elige la inteligencia de " + charName + ":");
                charIntelligence = scanner.nextInt();
                character = new Wizard(charName,charHP,charMana,charIntelligence);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + charType);
        }
        switch (partyNumber){
            case 1:
                if (party1 == null) {
                    party1 = new Party();
                }
                party1.addCharacter(character);
                break;
            case 2:
                if (party2 == null) {
                    party2 = new Party();
                }
                party2.addCharacter(character);
                break;                
        }
        System.out.println(charName + " ha sido creado e incluído en el equipo " + partyNumber + ".");


    }
}