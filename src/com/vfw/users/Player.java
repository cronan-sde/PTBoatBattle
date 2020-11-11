package com.vfw.users;

import java.util.List;

public abstract class Player {
    private String name;
    public static final int BOAT_COUNT = 5; // Ships will be 5 for each player
    private List<String> playerPosition; //list of players ships positions

    // ctor for CPUPlayer
    public Player() {
        this.name = "CPU";
    }

    // ctor for use by HumanPlayer
    public Player(String name) {
        this.name = name;
    }

    /*
     * Symbols represented on the game board, differ between HumanPlayer and CPUPlayer
     */
    public abstract char getShipSymbol();
    public abstract char getHitSymbol();
    public abstract char getMissSymbol();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getShips() {
        return playerPosition;
    }

    /*
     * Takes a list of String representing player ships locations
     * on the game board
     */
    public void setShips(List<String> playerPosition) {
        this.playerPosition = playerPosition;
    }

}