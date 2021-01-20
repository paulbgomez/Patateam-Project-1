package com.ironhack.main;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import static com.ironhack.main.Party.*;

public class Main {
    static Graveyard graveyard = new Graveyard();
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

                showMainMenu();
                break;
            case 5:
                System.out.println(party1);
                System.out.println(party2);
                showMainMenu();
                break;
            case 6:
                System.out.println(graveyard);
                showMainMenu();
                break;
            case 7:
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showMainMenu();
                break;
        }
    }

    public static void showCreateMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("            Crear personajes\n");
        System.out.println("1- Crear personaje manualmente");
        System.out.println("2- Mostrar equipos creados");
        System.out.println("3- Atrás\n");

        while (option < 1 || option > 3){
            System.out.println("Elige una opción válida con el teclado");
            option = scanOption.nextInt();
            scanOption.nextLine();
        }
        switch (option){
            case 1:
                inputDataForCharacters();
                break;
            case 2:
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showCreateMenu();
                break;
            case 3:
                showMainMenu();
                break;
        }
    }
    public static void showRandomMenu() throws IOException {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("            Crear personajes\n");
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
                party1 = new Party(10);
                break;
            case 2:
                party2 = new Party(10);
                break;
            case 3:
                showMainMenu();
                break;
        }
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
                showCreateMenu();
                break;
            case 2:
                party2 = new Party();
                party2.importCSV();
                showCreateMenu();
                break;
        }
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
                party1.exportCSV();
                showCreateMenu();
                break;
            case 2:
                showCreateMenu();
                break;
        }
    }

    public static void inputDataForCharacters() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean whileBreaker = false;
        String charType = "";
        String charName = "";
        int charHP = 0;
        int charStamina = 0;
        int charStrength = 0;
        int charMana = 0;
        int charIntelligence = 0;
        int partyNumber = 0;

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

                // AQUÍ LLAMARÍAMOS AL CONSTRUCTOR CON ESTOS PARÁMETROS
                System.out.println("Tu personaje es:");
                System.out.println("Tipo: " + charType);
                System.out.println("Nombre: " + charName);
                System.out.println("Vida: " + charHP);
                System.out.println("Resistencia: " + charStamina);
                System.out.println("Fuerza: " + charStrength + "\n");

                break;
            case "Wizard":
                System.out.println("Elige el maná de " + charName + ":");
                charMana = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Elige la inteligencia de " + charName + ":");
                charIntelligence = scanner.nextInt();

                // AQUÍ LLAMARÍAMOS AL CONSTRUCTOR CON ESTOS PARÁMETROS
                System.out.println("Tu personaje es:");
                System.out.println("Tipo: " + charType);
                System.out.println("Nombre: " + charName);
                System.out.println("Vida: " + charHP);
                System.out.println("Maná: " + charMana);
                System.out.println("Inteligencia: " + charIntelligence + "\n");



                break;
        }
        while (partyNumber < 1 || partyNumber > 2){
            System.out.println("Elige en qué equipo quieres que participe (1 ó 2)");
            partyNumber = scanner.nextInt();
            scanner.nextLine();
        }
        showCreateMenu();


    }
}