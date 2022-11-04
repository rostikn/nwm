package com.company;

import com.company.entities.Player;
import com.company.entities.Race;

public class Game {
    private final String name = "Ďuránová honba za dobrodruzstvim";
    private final double version = 0.1;
    private final String author = "RostyslavNovak";
    private GameDialog gameDialog;
    private Player player;

    public Game() {

        gameDialog = new GameDialog();
        player = new Player();
    }

    public void start() {
        gameDialog.intro(name, version, author);
        introMenu();
    }

    private void introMenu() {
        gameDialog.say("Vítej v poklidem mestecku. V mestecku bydli tisice lidi. Je cas vyber tve postavy");
        gameDialog.say("Zvol si svoji rasu", "red");
        for (Race value : Race.values()) {
            gameDialog.say(value.toString(), "purple");
        }
        selectRace();
        storyIntro();
    }

    private void selectRace() {
        String userInput = gameDialog.userInput();
        boolean check = false;
        for (Race value : Race.values()) {
            if (userInput.trim().equalsIgnoreCase(value.toString())){
                check = true;
                player.setRace(value);
                break;
            }
        }
        if (!check){
            selectRace();
            return;

        }
    }

    private void storyIntro(){
        gameDialog.say("Zvolil si rasu" + player.getRace(), "red");
        gameDialog.say("---------------------------------------------", "white");
        gameDialog.say("                Hra začíná                ");
        gameDialog.say("---------------------------------------------", "white");
        gameDialog.say("Vítej Tomáši v našem poklidném městečku, kde tisíce lidí přežívají tvojí existenci");
    }

}
