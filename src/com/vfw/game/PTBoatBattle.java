package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;

public class PTBoatBattle {
    private HumanPlayer human;
    private CPUPlayer cpuP;
    private GameBoard board;
    private GameController controller;
    private int num = 5;

    public PTBoatBattle(){}

    public void initializeGame(){
        new SayHello(); // calls popup that welcomes & gets user name

        new GameController();
    }

    // TODO take in players locations of pieces
    public char[][] getPlayersPositions(){
        char playerPosition [][] = new char[num][num];


        return playerPosition;
    }
    public char[][] getCpuPosition(){
        char cpuPosition[][] = new char[num][num];


        return cpuPosition;
    }



}
