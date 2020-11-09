package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;
import com.vfw.users.Player;

import java.util.*;

public class PTBoatBattle {


    private GameBoard board;
    private GameController controller;
    private int shipCount = 2; // ship count
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

    public void initializeGame() {
       // new SayHello(); // calls popup that welcomes & gets user name
        // tell instructions
        playGame();
        gC = new GameController();
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


    public void getPlayersPositions() {

        String choiceX, choiceX2;
        String choiceY;
        // TODO  call a popup menu to get players positions to replace the below scanner
        // TODO in a while loop ensure pieces are in valid positions and correct
      //  System.out.println(human.getName() + " now you need to input your desired locations for your PT Boats");
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

        human.setPlayerPosition(playerPosition);// set at human player class
        System.out.println(Arrays.toString(playerPosition.toArray()));
        gC.getCpuPosition();

        return ;
    }







}
