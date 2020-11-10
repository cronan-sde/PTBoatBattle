package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;
import com.vfw.users.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PTBoatBattle {


    private GameBoard board = new GameBoard();
    private GameController controller;
    private int shipCount = 5; // ship count
    public List<String> cpuPosition = new ArrayList<>();
    public List<String> playerPosition = new ArrayList<>();
    public Player player;
    public HumanPlayer human = new HumanPlayer("dude");
    private GameController gC = new GameController();
    public Player cpuP = new CPUPlayer();


    public Random rnd = new Random();

    Scanner sc = new Scanner(System.in);

    public PTBoatBattle() {
    }

    public void initializeGame() throws InterruptedException {
      // new SayHello(); // calls popup that welcomes & gets user name
        System.out.println("Welcome to PT Boat Battle ");
        System.out.println("You and the computer will be given 5 boats to place on the board");
        System.out.println("This is followed by taking shots at each other to sink the others boats");
        System.out.println("Winner is decided when the Victor sinks all the opponents boats");
        System.out.println("Here is what the board looks like");
        board.printBoard();
        TimeUnit.SECONDS.sleep(5);
        // tell instructions
        playGame();
        gC = new GameController();
    }
    public void playGame(){
        // go to getPlayerPositions

        getPlayersPositions();

        // do some logic
        // interact with player to place shots
        // call controller to verify if valid shot
        // call controller to get cpu shot
        // wash rinse repeat

    }

    public void getPlayersPositions() {

        System.out.println("\n\n");
        System.out.println("Positions need to be entered in the 'X' 'Y' coordinate system formula");
        System.out.println("Please do not use extra spaces or characters.");
        System.out.println("A valid example is like this :  a3   or   A6 ");
        System.out.println("Remember valid letters are a-j & valid numbers are 0-9");

        for (int i = 0; i < shipCount; i++ ) {

            System.out.println("Enter the 'X' coordinate followed by the 'Y' coordinate");
            String position = sc.nextLine().toUpperCase();
            //System.out.println("\n");

            if(board.getStringCoords().containsKey(position)){
            playerPosition.add(position);
             }
        }
            human.setPlayerPosition(playerPosition);// set at human player class
            System.out.println("Your valid positions are : " + Arrays.toString(playerPosition.toArray()));
            gC.getCpuPosition();

            return;
   }
}
