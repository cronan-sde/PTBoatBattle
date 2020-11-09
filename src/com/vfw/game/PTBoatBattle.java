package com.vfw.game;

import com.vfw.users.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PTBoatBattle {


    private GameBoard board;
    private GameController controller;
    private int shipCount = 5; // ship count
    public ArrayList<String> cpuPosition = new ArrayList<>();
    public ArrayList<String> playerPosition = new ArrayList<>();
    public Player player;


    public Random rnd = new Random();

    Scanner sc = new Scanner(System.in);

    public PTBoatBattle() {
    }

    public void initializeGame() {
        new SayHello(); // calls popup that welcomes & gets user name
        // tell instructions
        playGame();
        new GameController();
    }
    public void playGame(){
        // go to getPlayerPositions
        getPlayersPositions();
        // get cpu positions
        // do some logic
        // interact with player to place shots
        // call controller to verify if valid shot
        // call controller to get cpu shot
        // wash rinse repeat

    }


    public ArrayList<String> getPlayersPositions() {

        String choiceX, choiceX2;
        String choiceY;
        // TODO  call a popup menu to get players positions to replace the below scanner
        // TODO in a while loop ensure pieces are in valid positions and correct
        System.out.println(player.getName() + " now you need to input your desired locations for your PT Boats");
        System.out.println("Positions need to be entered in the 'X' 'Y' coordinate system formula");
        for (int i = 0; i < shipCount; i++) {
            System.out.println("Enter the 'X' coordinate of position " + (shipCount + 1) + " below.");
            choiceX = sc.nextLine();
            choiceX2 = choiceX.toUpperCase();
            System.out.println("Now enter the 'Y' coordinate of position " + (shipCount + 1) + " below");
            choiceY = sc.nextLine();
            //choiceY2 = Character.toUpperCase(choiceY);
            String position = choiceX2+choiceY;
            playerPosition.add(position);
            System.out.println("\n");
        }

        player.setPlayerPosition(playerPosition);// set at human player class
        getCpuPosition(playerPosition);
        return playerPosition;
    }

    public ArrayList<String> getCpuPosition(ArrayList<String> playerPosition) { // make ArrayList<String> as return value & send in same
        ArrayList<String> playerPostion = playerPosition;
        char cpuX;
        char cpuY;
        String positionC;
        // need random generator to generate positions
        for (int i = 0; i < shipCount; i++) {
            char a = randomLetter();
            int b = randomNumber();
            // checking against players positions to ensure no stepping on positions
            while (getPlayersPositions().contains(a) && getPlayersPositions().contains(b)) {
                a = randomLetter();
                b = randomNumber();
            }
            cpuX = a;
            cpuY = (char) b;
             positionC = String.valueOf(cpuX + cpuY);
            cpuPosition.add(positionC);
        }
        player.setPlayerPosition(cpuPosition);
        return cpuPosition;
    }


    public  char  randomLetter() {
        char letter = ' ';
        Random rnd = new Random();
        for (int i = 0; i < shipCount; i++) {
            char c = (char) ('A' + rnd.nextInt(10));
            letter = c;
        }
        return letter;
    }

    public  char randomNumber() {
        char number = ' ';
        Random rnd = new Random();
        for (int i = 0; i < shipCount; i++) {
            char n = (char) ('0' + rnd.nextInt(10));
            number = n;
        }
        return number;
    }




}
