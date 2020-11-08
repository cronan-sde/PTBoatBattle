package com.vfw.users;

public abstract class Player {
    private String name; // Humans will have a name, CPU will always be named CPU
    private int boatCount = 5; // default count of ships will be 5 each player

    public Player() {

    }

    // ctor for use by HumanPlayer
    public Player(String name) {
        this.name = name;
    }

    /*
     * Each player will set their ship locations, implementation
     * differs between Human and CPUPlayer
     * String will be returned in form of A0,B3,J9 etc.
     */
    public abstract String setShips();

    /*
     * Each player will choose a location to shoot at, implementation
     * differs between Human and CPUPlayer
     * String will be returned in form of A0, B3, J9 etc.
     */
    public abstract String generateShot();

}