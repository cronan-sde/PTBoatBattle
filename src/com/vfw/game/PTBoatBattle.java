package com.vfw.game;


public class PTBoatBattle {
//    private HumanPlayer human;
//    private CPUPlayer cpuP;
    private GameBoard board;
    private GameController controller;
    private int num = 5;
    private char[][] cpuPosition = new char[num][num];

    public PTBoatBattle(){}

    public void initializeGame(){
        new SayHello(); // calls popup that welcomes & gets user name

        new GameController();
    }

    // TODO take in players locations of pieces
    public char[][] getPlayersPositions(){
        char playerPosition [][] = new char[num][num];
        // TODO  call a popup menu to get players positions
        // or put scanner here and get input from human


        // set the position in human player class
        getCpuPosition();
        return playerPosition;
    }
    public char[][] getCpuPosition(){
       // char cpuPosition[][] = new char[num][num];
        // need random generator to generate positions
        for(int i = 0; i< num; i++){

        }
        // check against players positions to ensure no conflicts
        // set position in cpu class
        return cpuPosition;
    }



}
