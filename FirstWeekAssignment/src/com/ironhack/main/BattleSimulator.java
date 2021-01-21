package com.ironhack.main;

import com.ironhack.Character.Character;

public class BattleSimulator {
    private Party party1;
    private Party party2;
    private final Graveyard graveyard;

    public BattleSimulator(Party party1, Party party2) {
        this.party1 = party1;
        this.party2 = party2;
        graveyard = new Graveyard();
    }

    public void fullBattle(){
        while (party1.hasCharacters() && party2.hasCharacters()) {
            duel();
        }
    }

    public void duel(Character character1, Character character2){
        while (character1.getIsAlive() && character2.getIsAlive()){
            character1.attack(character2);
            character2.attack(character1);
        }
        burryTheDead(character1);
        burryTheDead(character2);
    }

    public void duel(int index1, int index2){
        duel(party1.getCharacter(index1),
                party2.getCharacter(index2));
    }

    public void duel(){
        duel(party1.getCharacter(),
                party2.getCharacter());
    }

    private void burryTheDead(Character character) {
        if (!character.getIsAlive()) {
            graveyard.addCharacterToGraveyard(character);
            party1.removeCharacter(character);
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
