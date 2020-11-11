package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;
import com.vfw.users.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;

/*
 * TODO: We still need to get human players name at beginning of the game, we also need to prompt
 *  if they would like to play again, if they choose to play again keep their name for the next game.
 *  So potentially if they choose to play again, we just recall the playGame() method again?
 */
public class PTBoatBattle {
    private GameBoard board;
    private Player human;
    private Player cpu;
    private GameController controller;
    private Random rnd = new Random();
    private Scanner sc = new Scanner(System.in);

    public PTBoatBattle() {
        board = new GameBoard();
        human = new HumanPlayer("Human Player");
        cpu = new CPUPlayer();
        controller = new GameController(board, human, cpu);
    }

    public void initializeGame() throws InterruptedException {
        hello();
        System.out.println("Welcome to PT Boat Battle "+ human.getName());
        System.out.println("You and the computer will be given 5 boats to place on the board");
        System.out.println("This is followed by taking shots at each other to sink the others boats");
        System.out.println("Winner is decided when the Victor sinks all the opponents boats");
        System.out.println("Here is what the board looks like");
        showBoard();
        TimeUnit.SECONDS.sleep(5);

        controller = new GameController(board, human, cpu);
        playGame();
    }
    public boolean hello(){
        boolean isReady = false;
        System.out.println("Hello New Player");
        System.out.println("Welcome To PT Boat Battle.");
        System.out.println("Lets Start the Game By Getting your name.");
        System.out.println("Please enter your name and hit your return key");
        String name = sc.nextLine();
        human = new HumanPlayer(name);

        isReady = true;
        return isReady;
    }

    public void playGame() throws InterruptedException {
        // go to getPlayerPositions
        getPlayersPositions();
        showBoard();
        battle();
    }

    public void getPlayersPositions() {
        boardLocationInfo(); // give user info on how to enter board locations

        List<String> playerPosition = new ArrayList<>();
        int curShipCount = 1;

        while (curShipCount <= Player.BOAT_COUNT) {
            System.out.println("Enter the 'X' coordinate followed by the 'Y' coordinate");
            String position = sc.nextLine().toUpperCase();

            if (board.getStringCoords().containsKey(position)) { //validates location in game board
                if (!playerPosition.contains(position)) {
                    playerPosition.add(position);
                    controller.updateGameBoard(position, human.getShipSymbol());
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
        controller.getCpuPosition(); //gets the cpu positions
    }

    private void battle() throws InterruptedException {
        while (!controller.gameOver()) {
            System.out.println(controller.takeTurns(getPlayerShot(), human));
            doIt();

            if (!controller.gameOver()) {
                System.out.println(controller.takeTurns(controller.cpuTakeShot(), cpu));
                doIt();
            }
            System.out.println(Arrays.toString(cpu.getShips().toArray()));
        }
        System.out.println(controller.determineWinner());
        playAgain();
    }

    //TODO: potential issues when validating shot. If player shoots at an already sunk ship it will call it a miss
    // and mark the previously sunk ship with an 'M'. We should catch this issue, we can still call it a miss, but
    // maybe print a message saying miss, you already sunk that ship, and leave the '!' on the game board
    private String getPlayerShot() {
        String shot = " ";
        boolean isV = false;

        while (!isV) {
            System.out.println("Take a shot by providing the coordinates as you did to place your boats: A-J & 0-9");
            shot = sc.nextLine().toUpperCase();

            if (controller.isValidShot(shot, human)) {
                isV = true;
            } else {
                System.out.println("YOU WANT A DARWIN AWARD? YOU ALMOST SUNK YOUR OWN SHIP ");
            }
        }
        return shot;
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

    private void doIt() throws InterruptedException {
        showBoard();
        TimeUnit.SECONDS.sleep(3);
    }
    private void playAgain() throws InterruptedException {
        System.out.println(human.getName()+ "  would you like to play again?  If yes please enter 'Y'");
        System.out.println("Otherwise the game ends");
        String answer = sc.nextLine().toUpperCase();
        if(!answer.equals("Y")){
            System.out.println("Thanks for playing. Good-By");
            return;
        } else {
            System.out.println("Welcome to a new round, lets reset your positions.");
            controller.resetGame();
            // after reset, player sent back to getPlayersPositions automatically.
            playGame();
        }
    }

}
