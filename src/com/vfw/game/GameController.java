package com.vfw.game;

import com.vfw.users.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class GameController {

    //TESTING PURPOSES
    private GameBoard board;
    private Player human;
    private Player cpu;
    private int shipCount = Player.BOAT_COUNT; // ship count

    public GameController(GameBoard board, Player human, Player cpu) {
        this.board = board;
        this.human = human;
        this.cpu = cpu;
    }


    public void getCpuPosition(){
        List<String> cpuPosition = new ArrayList<>(5);

        int curShipCount =1;
        while(curShipCount <= shipCount){
            char cpuX = randomLetter();
            char cpuY = randomNumber();
            String positionC = String.valueOf(cpuX) + cpuY;

            if(!human.getShips().contains(positionC) && !cpuPosition.contains(positionC)){
                cpuPosition.add(positionC);
                updateGameBoard(positionC, 'c'); //TODO:figure out how to get this from player class
                curShipCount++;
            }
        }
        cpu.setShips(cpuPosition); // update cpu position field
    }

    //TESTING PURPOSE
    public void updateGameBoard(String position, char symbol) {
        int x = board.getStringCoords().get(position).x;
        int y = board.getStringCoords().get(position).y;
        board.updateBoard(x, y, symbol);
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

    public char randomNumber() {
        char number = ' ';
        Random rnd = new Random();
        for (int i = 0; i < shipCount; i++) {
            char n = (char) ('0' + rnd.nextInt(10));
            number = n;
        }
        return number;
    }

    //TODO: implement
    // NOTE: this is just a rough sample to get us started and is in no way the final product
    // or even the direction we need to go, just ideas we can talk about and change anything we want
    // to fit our needs
    public String takeTurns(String shot, String player) {
       // String winnerName = null;
        //e.g. usage
        String something;
        if (isValidShot(shot)) {

            // if is valid shot, check hit
            if (isHit("A1")) {

                something ="HIT ";
                gameOver(); // checks for win
                if(player.equals("human")) {
                    updateGameBoard(shot, '!');
                } else if( player.equals("cpu")){
                    updateGameBoard(shot, 'X');
                }
                gameOver();
            }
            else {
                // no hit, continue playing
            }
        }
        else {
            //not a valid shot, re-enter a new shot
        }
        return something =" ";
    }

    //TODO: implement
    // Takes in a shot, checks if the shot is a valid location within the game board
    // returns boolean and takes String in form of "A1"-"J9"
    // If valid shot, pass it off to isHit() to check for hits
    public boolean isValidShot(String shot) {
        return false; //placeholder for now
    }

    //TODO: implement
    // Takes in a shot, checks if the shot was a hit or miss
    // returns true if a hit, false if miss
    // Should also update the game board with either a '!' for sunk cpu ship
    // or 'X' for sunk player ship or 'M' if miss, need to account for who fired shot
    // and whose ship was sunk
    // Call isWin() if there is a hit to see if it was last ship to be sunk
    public boolean isHit(String shot) {
        boolean result = false;
        if(shot.equals(cpu.getShips()) || shot.equals(human.getShips())){
            result = true;
        }
        return result;
    }

    //TODO: implement
    // check if either player has 0 ships left
    // return true if a player has 0 ships
    // return false if both players still have ships
    public boolean gameOver() {
        boolean result = false;
        if(human.getShips().size() ==0 || cpu.getShips().size()==0){
            result = true;
        }
        return result; //placeholder
    }

    //TODO: implement
    // determine which player has ships left and return their name
    public String determineWinner() {
        String playerName = "name";
        return playerName;
    }

    public void cpuTakeShot() {

        char cpuA = randomLetter();
        char cpuB = randomNumber();
        String positionC = String.valueOf(cpuA) + cpuB;

        if(!cpu.getShips().contains(positionC)){
         //   cpuShot.add(positionC);
            updateGameBoard(positionC, 'c'); //TODO:figure out how to get this from player class

        }

    }
}