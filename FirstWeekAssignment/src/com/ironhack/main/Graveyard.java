package com.ironhack.main;

import com.ironhack.Character.Character;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {
    private final List<Character> graveyardList;

    public Graveyard() {
        graveyardList = new ArrayList<>();
    }

    public void addCharacterToGraveyard(Character character) {
        graveyardList.add(character);
    }

    @Override
    public String toString() {
        if(getGraveyardList().size() == 0){
            return "+++ The Graveyard is empty.... +++ \n" +
                    "              ...                            \u0003\n" +
                    "             ;::::;                           \u0003\n" +
                    "           ;::::; :;                          \u0003\n" +
                    "         ;:::::'   :;                         \u0003\n" +
                    "        ;:::::;     ;.                        \u0003\n" +
                    "       ,:::::'       ;           OOO\\         \u0003\n" +
                    "       ::::::;       ;          OOOOO\\        \u0003\n" +
                    "       ;:::::;       ;         OOOOOOOO       \u0003\n" +
                    "      ,;::::::;     ;'         / OOOOOOO      \u0003\n" +
                    "    ;:::::::::`. ,,,;.        /  / DOOOOOO    \u0003\n" +
                    "  .';:::::::::::::::::;,     /  /     DOOOO   \u0003\n" +
                    " ,::::::;::::::;;;;::::;,   /  /        DOOO  \u0003\n" +
                    ";`::::::`'::::::;;;::::: ,#/  /          DOOO \u0003\n" +
                    ":`:::::::`;::::::;;::: ;::#  /            DOOO\u0003\n" +
                    "::`:::::::`;:::::::: ;::::# /              DOO\u0003\n" +
                    "`:`:::::::`;:::::: ;::::::#/               DOO\u0003\n" +
                    " :::`:::::::`;; ;:::::::::##                OO\u0003\n" +
                    " ::::`:::::::`;::::::::;:::#                OO\u0003\n" +
                    " `:::::`::::::::::::;'`:;::#                O \u0003\n" +
                    "  `:::::`::::::::;' /  / `:#                  \u0003\n" +
                    "   ::::::`:::::;'  /  /   `#         FOR NOW.....     ";
        } else {
            String graveyardDeaths = "The Graveyard is filled with the souls of \n";
            for (int i = 0; i < getGraveyardList().size(); i++) {
                graveyardDeaths += getGraveyardList().get(i).getName() + ", a brave " + getGraveyardList().get(i).getCharacterType()
                + "\n";
            }
            graveyardDeaths +=
                    "      ,-=-.     ______      _\n" +
                    "     /  +  \\     />----->  _|1|_\n" +
                    "     | ~~~ |    // -/- /  |_ H _|\n" +
                    "     |R.I.P|   //  /  /     |S|\n" +
                    "\\vV,,|_____|V,//_____/VvV,v,|_|/,,vhjwv/,";
            return graveyardDeaths;
        }
    }

    public List<Character> getGraveyardList() {
        return graveyardList;
    }
}
