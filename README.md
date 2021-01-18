## Introduction
The objective of this homework is to develop an RPG battle simulator, were you can create a party of warriors and wizards to fight other parties to determinate the winner. This will be a warmup project that will not have any following in the next weeks so use it as an opportunity to learn to work with your team and practice the basics on a longer project.

Let's walk through the details of the project:

We have two types of characters, warriors and wizards who have differents attributes and combat styles You need to create character class (that cannot be instantiated) that will contain base attributes that are common for both warriors and wizards

#### Character:

- `id` - unique identifier
- `name` - String
- `hp` - number representing the health points
- `isAlive` - flag to determine if the Player is alive

##### Warrior:

- `stamina` - number to represent a resource the warrior consumes to make an attack
- `strength` - number to calculate how strong the warrior attack is
##### Wizard:

- `mana` - number to represent a resource the wizard consumes to cast spells
- `intelligence` - number to calculate how strong the wizard spells are

#### How the battle simulator works
The characters are grouped in parties and the battle will be between 2 parties. So before the battle could start you need to add warriors or wizards in both parties (the parties could have any size and could be mixed with warriors and wizards).

The battles will be 1 vs 1. So you will need to be able to choose between members of the party to duel another member from the rival party.

The battle will be by rounds, in each round both combatants will attack at the same time (so you even if one combatant do the killing blow both will take damage). So the combat could end in a tie.

When the battle is over the winner will return to the party and the loser will be removed and sent to the graveyard. Then you can choose the combatants for the next duel.

When a party lose all their members a winner party is declared.

#### Character Attacks
Both wizards and warrios will have the same attack command defined by an interface called `Attacker`.

Warriors are strong well armored characters that focus on the attribute strength. Every round a warrior will try to do a "Heavy attack". The damage of a heavy attack is equals to their strength and every hit will decrease their stamina by 5 points. If he can't make a heavy attack he will do a "Weak attack". The damage of a weak attack is the half of the strength (truncate decimals). Every weak attack will recover his stamina by 1.

Wizards are the masters of the arcane their main attribute is intelligence. Every round a wizard will try to cast a "Fireball". The damage of a fireball is equals to his intelligence and every fireball will decrease their mana by 5 points. If he can't cast a fireball he will do a "Staff hit". The damage of a staff hit is equals to 2. Every staff hit will recover his mana by 1.

### Requirements
For this project you must accomplish all of the following:

1. Navigate trough a text based menu using Standard Input and Output.

2. Create Warriors and Wizards individually customizing their stats and name and adding them to a party.

3. Create a full party of randomly generated Wizards and Warriors with randomized stats considering this limits.

    - `name`: based on an array of names, pick random position and if is already in the party add Jr at the end.
    - `hp`: random between 100-200 to warriors, 50-100 for wizards)
    - `stamina`: random between 10-50
    - `strength`: random between 1-10
    - `mana`: random between 10-50
    - `intelligence`: random between 1-50
4. Import a party using a csv file.

5. Show the graveyard (is the same graveyard for both parties)

6. Battle between parties and determine the winner.

7. Keep a detailed log (on the standard output) of every action taken during the duels.

### Optional Achievements
1. Export party into an importable csv file.

2. Simulate whole party fights with one command by choosing random fighters in each side and make them duel until one party is wiped out.
