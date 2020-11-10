package com.vfw.users;

import java.util.List;

public abstract class Player {
    private String name; // Humans will have a name, CPU will always be named CPU
    private final int boatCount = 5; // default count of ships will be 5 each player
    private List<String> playerPosition;

    //ctor for CPUPlayer
    public Player() {
        this.name = "CPU";
    }

    // ctor for use by HumanPlayer
    public Player(String name) {
        this.name = name;
    }


    // GETTERS & SETTERS
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