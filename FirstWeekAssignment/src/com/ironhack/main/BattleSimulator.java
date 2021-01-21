package com.ironhack.main;

import com.ironhack.Character.Character;

public class BattleSimulator {
    private Party party1;
    private Party party2;
    private final Graveyard graveyard;

    public BattleSimulator() {
        this(new Graveyard());
    }

    public BattleSimulator(Party party1, Party party2, Graveyard graveyard) {
        this.party1 = party1;
        this.party2 = party2;
        this.graveyard = graveyard;
    }

    public BattleSimulator(Graveyard graveyard) {
        this.graveyard = graveyard;
        party1 = new Party();
        party2 = new Party();
    }

    public BattleSimulator(Party party1, Party party2) {
        this();
        this.party1 = party1;
        this.party2 = party2;
    }

    public void fullBattle(){
        while (party1.hasCharacters() && party2.hasCharacters()) {
            duel();
        }
    }

    public void duel(Character character1, Character character2){
        System.out.println();
        System.out.println("Duelo entre " + character1.getName() + " y " + character2.getName());
        while (character1.getIsAlive() && character2.getIsAlive()){
            character1.attack(character2);
            character2.attack(character1);
        }
        burryTheDead(party1, character1);
        burryTheDead(party2, character2);
    }

    public void duel(int index1, int index2){
        duel(party1.getCharacter(index1),
                party2.getCharacter(index2));
    }

    public void duel(){
        duel(party1.getCharacter(),
                party2.getCharacter());
    }

    private void burryTheDead(Party party, Character character) {
        if (!character.getIsAlive()) {
            System.out.println(character.getName() + " ha muerto y va a ser enterrado");
            graveyard.addCharacterToGraveyard(character);
            party.removeCharacter(character);
        }
    }

    public Party getParty1() {
        return party1;
    }

    public Party getParty2() {
        return party2;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }
}
