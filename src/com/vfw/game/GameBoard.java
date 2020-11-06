package com.vfw.game;


import java.util.*;

class GameBoard {
    private char[][] board; // 2D game board
    private static final int SIZE = 10; // dimension of game board
    Map<Character, Integer> rowKeyValues = new HashMap<>(10);

    // Symbols to represent board characters
    // '@' = HumanPlayer ships, '~' = water, 'M' = miss, '!' = sunk CPU ship, 'X' = sunk human ship

    //ctor to initialize board
    public GameBoard() {
        board = new char[SIZE][SIZE];
    }

    // Methods to print and update board
    public void printBoard() {
        System.out.print("       0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < board.length; i++) {

        }
    }

    public Map<Character, Integer> getRowKeyValues() {
        return Collections.unmodifiableMap(rowKeyValues);
    }

    private void setRowKeyValues() {
        List<Character> charKeys = new ArrayList<>(
                Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));

        int value = 0;

        for (Character key : charKeys) {
            rowKeyValues.put(key, value);
            value++;
        }
    }
}