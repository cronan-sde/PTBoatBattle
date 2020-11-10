package com.vfw.users;


import java.util.List;


//TODO: implement CPUPlayer class
public class CPUPlayer extends Player{
    private List<String> usedLocations; //keep track of all used coordinates for CPU
    private static final char SHIP_SYMBOL = 'c';
    private static final char HIT_SYMBOL = 'X';

    public CPUPlayer() {

    }

    @Override
    public char getShipSymbol() {
        return SHIP_SYMBOL;
    }

    @Override
    public char getHitSymbol() {
        return HIT_SYMBOL;
    }

    @Override
    public char getMissSymbol() {
        return Character.MIN_VALUE;
    }
}