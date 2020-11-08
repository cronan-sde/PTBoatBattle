package com.vfw.game;

import com.vfw.users.Player;

import java.util.Random;
import java.util.Scanner;

public class PTBoatBattle {


    private GameBoard board;
    private GameController controller;
    private int num = 5;
    public char[][] cpuPosition = new char[num][num];
    public char[][] playerPosition = new char[num][num];

    private Player player;
    Random rnd = new Random();

    Scanner sc = new Scanner(System.in);

    public PTBoatBattle() {
    }

    public void initializeGame() {
        new SayHello(); // calls popup that welcomes & gets user name

        new GameController();
    }


    public char[][] getPlayersPositions() {
        char choiceX, choiceX2;
        char choiceY, choiceY2;
        // TODO  call a popup menu to get players positions to replace the below scanner

        System.out.println(player.getName() + " now you need to input your desired locations for your PT Boats");
        System.out.println("Positions need to be entered in the 'X' 'Y' coordinate system formula");
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the 'X' coordinate of position " + (num + 1) + " below.");
            choiceX = sc.next().charAt(0);
            choiceX2 = Character.toUpperCase(choiceX);
            System.out.println("Now enter the 'Y' coordinate of position " + (num + 1) + " below");
            choiceY = sc.next().charAt(0);
            choiceY2 = Character.toUpperCase(choiceY);
            playerPosition[i] = new char[]{choiceX2, choiceY2};
            System.out.println("\n");
        }

        setPlayerPosition(playerPosition);
        getCpuPosition(playerPosition);
        return playerPosition;
    }

    public char[][] getCpuPosition(char[][] playerPositions) {
        char cpuPosition[][] = new char[num][num];
        char cpuX;
        char cpuY;
        // need random generator to generate positions
        for (int i = 0; i < num; i++) {
            char a = randomLetter();
            char b = randomNumber();
            // checking against players positions to ensure no stepping on positions
            while (playerPositions[i].equals(a) && playerPositions.equals(b)) {
                a = randomLetter();
                b = randomNumber();
            }
            cpuX = a;
            cpuY = b;
            cpuPosition[i] = new char[]{cpuX, cpuY};
        }
        setCpuPosition(cpuPosition);
        return cpuPosition;
    }


    public char randomLetter() {
        char letter = ' ';

        for (int i = 0; i < num; i++) {
            char c = (char) ('A' + rnd.nextInt(10));
            letter = c;
        }
        return letter;
    }

    public char randomNumber() {
        char number = ' ';
        for (int i = 0; i < num; i++) {
            char n = (char) ('0' + rnd.nextInt(10));
            number = n;
        }
        return number;
    }

    public char[][] getCpuPosition() {
        return cpuPosition;
    }

    public void setCpuPosition(char[][] cpuPosition) {
        this.cpuPosition = cpuPosition;
    }

    public char[][] getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(char[][] playerPosition) {
        this.playerPosition = playerPosition;
    }
}
