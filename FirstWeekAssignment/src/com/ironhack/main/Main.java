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
        showMainMenu();
    }

    public static void showMainMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============\n");
        System.out.println("1- Crear personajes y equipos manualmente");
        System.out.println("2- Crear equipos enteros aleatoriamente");
        System.out.println("3- Importar un equipo desde un archivo .csv");
        System.out.println("4- Exportar equipo existente a un archivo .csv");
        System.out.println("5- Mostrar equipos si ya existen");
        System.out.println("6- Ver personajes muertos");
        System.out.println("7- ¡Guerra entre los equipos!\n");

        while (option < 1 || option > 8){
            System.out.println("Elige una opción válida con el teclado:");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }

        switch (option){
            case 1:
                showCreateMenu();
                break;
            case 2:
                showRandomMenu();
                break;
            case 3:
                showImportMenu();
                break;
            case 4:
                showExportMenu();
                break;
            case 5:
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
                showMainMenu();
                break;
            case 6:
                System.out.println(battleSimulator.getGraveyard());
                showMainMenu();
                break;
            case 7:
                showWarMenu();
                break;
        }
    }

    public static void showCreateMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("            Crear personajes\n");
        System.out.println("1- Crear personaje para el equipo 1");
        System.out.println("2- Crear personaje para el equipo 2");
        System.out.println("3- Atrás\n");

        while (option < 1 || option > 3){
            System.out.println("Elige una opción válida con el teclado");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }
        switch (option){
            case 3:
                showMainMenu();
                break;
            default:
                inputDataForCharacters(option);
                break;
        }
    }
    public static void showRandomMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;
        Random random = new Random();
        int numeroRandom = random.nextInt(15)+1;

        System.out.println("============ Patapasillo war ============");
        System.out.println("       Generar equipo aleatorio\n");
        System.out.println("1- Generar equipo 1");
        System.out.println("2- Generar equipo 2");
        System.out.println("3- Atrás\n");

        while (option < 1 || option > 3){
            System.out.println("Elige una opción válida con el teclado");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }
        switch (option){
            case 1:
                party1 = new Party(numeroRandom);
                break;
            case 2:
                party2 = new Party(numeroRandom);
                break;
            case 3:
                showMainMenu();
                break;
        }
        System.out.println("El equipo " + option + " ha sido generado con " + numeroRandom + " miembros. Pulsa intro para continuar.");
        scanOption.nextLine();
        showRandomMenu();

    }
    public static void showImportMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("            Importar equipos\n");
        System.out.println("1- Importar equipo 1");
        System.out.println("2- Importar equipo 2");
        System.out.println("3- Atrás\n");

        while (option < 1 || option > 3){
            System.out.println("Elige una opción válida con el teclado");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }
        switch (option){
            case 1:
                party1 = new Party();
                party1.importCSV();
                break;
            case 2:
                party2 = new Party();
                party2.importCSV();
                break;
            case 3:
                showMainMenu();
                break;
        }
        System.out.println("El equipo " + option + " ha sido importado desde el archivo .csv. Pulsa intro para continuar.");
        scanOption.nextLine();
        showImportMenu();
    }
    public static void showExportMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("            Exportar equipos\n");
        System.out.println("1- Exportar equipo 1");
        System.out.println("2- Exportar equipo 2");
        System.out.println("3- Atrás\n");

        while (option < 1 || option > 3){
            System.out.println("Elige una opción válida con el teclado");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }
        switch (option){
            case 1:
                if (party1 != null) {
                    party1.exportCSV();
                    System.out.println("El equipo " + option + " ha sido exportado al archivo .csv. Pulsa intro para continuar.");
                } else {
                    System.out.println("El equipo " + option + " aún está vacío. No se puede exportar. Pulsa intro para continuar.");
                }
                break;
            case 2:
                if (party2 != null) {
                    party2.exportCSV();
                    System.out.println("El equipo " + option + " ha sido exportado al archivo .csv. Pulsa intro para continuar.");
                } else {
                    System.out.println("El equipo " + option + " aún está vacío. No se puede exportar. Pulsa intro para continuar.");
                }
                break;
            case 3:
                showMainMenu();
                break;

        }
        scanOption.nextLine();
        showExportMenu();
    }
    public static void showWarMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option = 0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("               ¡Batalla!\n");
        System.out.println("1- Elegir combatientes a mano");
        System.out.println("2- Batalla completa automática");
        System.out.println("3- Atrás\n");

        while (option < 1 || option > 3) {
            System.out.println("Elige una opción válida con el teclado");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }
        switch (option) {
            case 1:
                System.out.println("Todavía no implementado.");
                showWarMenu();
                break;
            case 2:
                BattleSimulator bs = new BattleSimulator(party1, party2, battleSimulator.getGraveyard());
                bs.fullBattle();
                showMainMenu();
                break;
            case 3:
                showMainMenu();
                break;
        }
    }
    public static void inputDataForCharacters(int partyNumber) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean whileBreaker = false;
        String charType = "";
        String charName = "";
        int charHP = 0;
        int charStamina = 0;
        int charStrength = 0;
        int charMana = 0;
        int charIntelligence = 0;
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
        System.out.println(charName + " ha sido creado e incluído en el equipo " + partyNumber + ". Pulsa intro para continuar.");
        scanner.nextLine();
        showCreateMenu();


    }
}