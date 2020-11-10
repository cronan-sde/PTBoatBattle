package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;
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


    public void getCpuPosition() {
        List<String> cpuPosition = new ArrayList<>(5);

        int curShipCount = 1;
        while (curShipCount <= shipCount) {
            char cpuX = randomLetter();
            char cpuY = randomNumber();
            String positionC = String.valueOf(cpuX) + cpuY;

            if (!human.getShips().contains(positionC) && !cpuPosition.contains(positionC)) {
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

    public char randomLetter() {
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


    public String takeTurns(String shot, Player player) {
        // String winnerName = null;
        //e.g. usage
        String something;
        if (isValidShot(shot, player)) {

            // if is valid shot, check hit
            if (isHit(shot,player)) {

                something = "HIT !!  Good Job";
                updateGameBoard(shot, player.getHitSymbol());
                gameOver();
            } else {
                something = "MISS !!";
                updateGameBoard(shot, player.getMissSymbol());
            }
        } else {
            something = "NOT A VALID SHOT :  OUCH MISSED TURN";
        }

        return something;
    }

    public boolean isValidShot(String shot, Player player) {
        boolean isValid = false;
        if(!player.getShips().contains(shot) && board.getStringCoords().containsKey(shot)){
            isValid = true;
        }

        return isValid; //placeholder for now
    }

    public boolean isHit(String shot, Player player) {
        boolean result = false;
        if (cpu.getShips().contains(shot) || human.getShips().contains(shot)) {
            if(player instanceof CPUPlayer){
                human.getShips().remove(shot);
            }
            if (player instanceof HumanPlayer) {
                cpu.getShips().remove(shot);
            }
            result = true;
        }
        return result;
    }


    public boolean gameOver() {
        boolean result = false;
        if (human.getShips().size() == 0 || cpu.getShips().size() == 0) {
            result = true;
        }
        return result; //placeholder
    }

    //TODO: implement
    // determine which player has ships left and return their name
    public String determineWinner() {
        String winner = " ";
        if(human.getShips().size() ==0){
            winner = cpu.getName();
        } else {
            winner = human.getName();
        }
        return winner;
    }

    public String cpuTakeShot() {
        String positionC =" ";
        boolean isGood = false;

            while(!isGood ){
                char cpuA = randomLetter();
                char cpuB = randomNumber();
                positionC = String.valueOf(cpuA) + cpuB;
                if( !cpu.getShips().contains(positionC) ){ // TODO also check in CPUplayer usedLocations
                  isGood= true;
                }
            }
        return positionC;
    }
}