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

    public void playGame() throws InterruptedException {
        // go to getPlayerPositions

        getPlayersPositions();
        showBoard();
        battle();


    }

    private void battle() throws InterruptedException {

        while (!controller.gameOver()) {

            System.out.println(controller.takeTurns(getPlayerShot(), human));
            doIt();

            controller.takeTurns(controller.cpuTakeShot(),cpu) ;
           doIt();

        System.out.println(Arrays.toString(cpu.getShips().toArray()));
        }
        String winner =" ";
        System.out.println( winner = controller.determineWinner());
    }
    private String getPlayerShot(){
        String pS =" ";
        boolean isV = false;
        while(!isV) {
            System.out.println("Take a shot by providing the coordinates as you did to place your boats: A-J & 0-9");
             pS = sc.nextLine().toUpperCase();
            if(controller.isValidShot(pS, human)){
                isV= true;
            } else {
                System.out.println("YOU WANT A DARWIN AWARD? YOU ALMOST SUNK YOUR OWN SHIP ");
            }
        }
        return pS;
    }
    private void doIt() throws InterruptedException {
        showBoard();
        TimeUnit.SECONDS.sleep(3);
    }


    public void getPlayersPositions() {
        boardLocationInfo(); // give user info on how to enter board locations

        List<String> playerPosition = new ArrayList<>();
        int curShipCount = 1;

        while (curShipCount <= Player.BOAT_COUNT) {
            System.out.println("Enter the 'X' coordinate followed by the 'Y' coordinate");
            String position = sc.nextLine().toUpperCase();

            if (board.getStringCoords().containsKey(position)) { //validating location in game board
                if (!playerPosition.contains(position)) {
                    playerPosition.add(position);
                    controller.updateGameBoard(position, '@'); //TODO:find a way to get from player class
                    curShipCount++;
                } else {
                    System.out.println("You've already placed a ship there. Try again");
                }

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
