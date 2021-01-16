package com.ironhack.main;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println();
        System.out.println("Elige una opción escribiendo el número:");
        System.out.println();
        System.out.println("1- Crear personajes y equipos manualmente");
        System.out.println("2- Crear equipos enteros aleatoriamente");
        System.out.println("3- Importar un equipo desde un archivo .csv");
        System.out.println("4- Exportar equipo existente a un archivo .csv");
        System.out.println("5- Ver personajes muertos");
        System.out.println("6- ¡Guerra entre los equipos!");

        while (option < 1 || option > 7){
            option = scanOption.nextInt();
            scanOption.nextLine();
        }

        switch (option){
            case 1:
                showCreateMenu();
                break;
            case 2:
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showMainMenu();
                break;
            case 3:
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showMainMenu();
                break;
            case 4:
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showMainMenu();
                break;
            case 5:
                // llamar al método pertinente ¿(showGraveyard)?
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showMainMenu();
                break;
            case 6:
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showMainMenu();
                break;
        }
    }

    public static void showCreateMenu(){
        Scanner scanOption = new Scanner(System.in);
        int option=0;

        System.out.println("============ Patapasillo war ============");
        System.out.println("            Crear personajes");
        System.out.println("Elige una opción escribiendo el número:");
        System.out.println();
        System.out.println("1- Crear personaje manualmente");
        System.out.println("2- Modificar personaje creado");
        System.out.println("3- Mover un personaje creado de un equipo a otro");
        System.out.println("4- Atrás");

        while (option < 1 || option > 4){
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
                // llamar al método pertinente
                System.out.println("Todavía no implementado");  // Esta línea y la siguiente se borrarán cuando tengamos el método al que llamar.
                showCreateMenu();
                break;
            case 4:
                showMainMenu();
                break;
        }
    }
    public static void inputDataForCharacters(){
        Scanner scanner = new Scanner(System.in);
        boolean whileBreaker = false;
        String charType = "";
        String charName = "";
        int charHP = 0;
        int charStamina = 0;
        int charStrength = 0;
        int charMana = 0;
        int charIntelligence = 0;

        System.out.println("Elige el tipo de personaje (Warrior / Wizard)");
        while (!whileBreaker){
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
                System.out.println("Fuerza: " + charStrength);

                break;
            case "Wizard":
                System.out.println("Elige el maná de " + charName + ":");
                charMana = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Elige la inteligencia de " + charName + ":");
                charIntelligence = scanner.nextInt();

                // AQUÍ LLAMARÍAMOS AL CONSTRUCTOR CON ESTOS PARÁMETROS EN VEZ DE IMPRIMIR
                System.out.println("Tu personaje es:");
                System.out.println("Tipo: " + charType);
                System.out.println("Nombre: " + charName);
                System.out.println("Vida: " + charHP);
                System.out.println("Maná: " + charMana);
                System.out.println("Fuerza: " + charIntelligence);



                break;
        }


    }
}