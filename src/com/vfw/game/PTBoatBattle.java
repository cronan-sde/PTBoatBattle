package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;
import com.vfw.users.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class PTBoatBattle {
    private GameBoard board;
    private Player human;
    private Player cpu;
    private GameController controller;
    private Random rnd = new Random();
    private Scanner sc = new Scanner(System.in);

    public PTBoatBattle() {
        board = new GameBoard();
        human = new HumanPlayer("dude");
        cpu = new CPUPlayer();
        controller = new GameController(board, human, cpu);
    }

    public void initializeGame() throws InterruptedException {
        // new SayHello(); // calls popup that welcomes & gets user name
        System.out.println("Welcome to PT Boat Battle ");
        System.out.println("You and the computer will be given 5 boats to place on the board");
        System.out.println("This is followed by taking shots at each other to sink the others boats");
        System.out.println("Winner is decided when the Victor sinks all the opponents boats");
        System.out.println("Here is what the board looks like");
        showBoard();
        TimeUnit.SECONDS.sleep(5);
        // tell instructions
        controller = new GameController(board, human, cpu);
        playGame();
    }

    public void playGame() {
        // go to getPlayerPositions

        getPlayersPositions();
        showBoard();
        // do some logic
        // interact with player to place shots
        // call controller to verify if valid shot
        // call controller to get cpu shot
        // wash rinse repeat

    }


    public void getPlayersPositions() {
        boardLocationInfo(); // give user info on how to enter board locations

        List<String> playerPosition = new ArrayList<>();
        int curShipCount = 1;

        while (curShipCount <= Player.BOAT_COUNT) {
            System.out.println("Enter the 'X' coordinate followed by the 'Y' coordinate");
            String position = sc.nextLine().toUpperCase();

            if (board.getStringCoords().containsKey(position)) { //validating location in game board
                playerPosition.add(position);
                controller.updateGameBoard(position, '@'); //TODO:find a way to get from player class
                curShipCount++;
            } else {
                System.out.println("Invalid input, location outside the ocean, please try again.");
            }
        }
        human.setShips(playerPosition); //setting positions in Players field
        System.out.println("Your valid positions are : " + Arrays.toString(human.getShips().toArray()));
        controller.getCpuPosition(); //getting cpu positions
    }

    private void showBoard() {
        board.printBoard();
    }

    public void boardLocationInfo() {
        System.out.println("\n\n");
        System.out.println("Positions need to be entered in the 'X' 'Y' coordinate system formula");
        System.out.println("Please do not use extra spaces or characters.");
        System.out.println("A valid example is like this :  a3   or   A6 ");
        System.out.println("Remember valid letters are a-j & valid numbers are 0-9");
    }
}
