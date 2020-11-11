package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.Player;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> cpuPosition = new ArrayList<>(shipCount);
        String positionC = "";
        int curShipCount = 1;

        while (curShipCount <= shipCount) {

            positionC = generateCPUCoordinate();

            if (!human.getShips().contains(positionC)) {
                cpuPosition.add(positionC);
                updateGameBoard(positionC, cpu.getShipSymbol());
                curShipCount++;
            }
        }
        cpu.setShips(cpuPosition); // update cpu position field
    }

    // Shot validated prior to entry
    public String takeTurns(String shot, Player player) {
        // String winnerName = null;
        //e.g. usage
        String message;
        String opponent = player instanceof CPUPlayer ? human.getName() : cpu.getName();

        // if is valid shot, check hit
        if (isHit(shot,player)) {
            message = "HIT!!!! " + player.getName() + " just sunk " + opponent + "'s PTBoat at location " + shot;
            updateGameBoard(shot, player.getHitSymbol());
        }
        else {
            message = "MISS!!!! " + player.getName() + " missed shot at location " + shot;
            updateGameBoard(shot, player.getMissSymbol());
        }
        return message;
    }

    public String cpuTakeShot() {
      return generateCPUCoordinate();
    }

    //TODO: created this method in order to use and access the CPUPlayer's usedLocations List
    // everything still works the exact same, but now we can use the usedLocations List to validate
    // the CPU's shots, it contains its ship locations and every shot it takes
    public String generateCPUCoordinate() {
        String positionC = "";
        boolean isValid = false;
        CPUPlayer cpuPlayer = (CPUPlayer) cpu;

        while(!isValid){
            char cpuA = randomLetter();
            char cpuB = randomNumber();
            positionC = String.valueOf(cpuA) + cpuB;

            if(!cpuPlayer.getUsedLocations().contains(positionC)) { // DONE: also check in CPUPlayer usedLocations
                cpuPlayer.getUsedLocations().add(positionC);
                isValid = true;
            }
        }
        System.out.println("CPU USEDLOCATIONS: " + Arrays.toString(cpuPlayer.getUsedLocations().toArray()));
        return positionC;
    }

    public boolean isHit(String shot, Player player) {
        boolean result = false;

        if (cpu.getShips().contains(shot) || human.getShips().contains(shot)) {
            if(player instanceof CPUPlayer){
                human.getShips().remove(shot);
            }
            else {
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

        return result;
    }

    public String determineWinner() {
        String winner = "";

        if (human.getShips().size() == 0){
            winner = "Game Over!\n" + cpu.getName() + " has sunk all of " + human.getName() + "'s ships";
        }
        else {
            winner = "Congratulations " + human.getName() + " you have sunk all of " + cpu.getName() + "'s ships";
        }
        return winner;
    }

    public boolean isValidShot(String shot, Player player) {
        boolean isValid = false;

        if(!player.getShips().contains(shot) && board.getStringCoords().containsKey(shot)){
            isValid = true;
        }
        return isValid; //placeholder for now
    }

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
    public void resetGame(){
        human.getShips().clear();
        cpu.getShips().clear();
        CPUPlayer cpuPlayer = (CPUPlayer) cpu;
        cpuPlayer.getUsedLocations().clear();
        board.resetBoard(); //implement in GameBoard
    }
}