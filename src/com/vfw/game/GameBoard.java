package com.vfw.game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class GameBoard {
    private char[][] board; // 2D game board
    private static final int SIZE = 10; // dimension of game board
    // list of row identifiers
    private static final List<Character> CHAR_KEYS = new ArrayList<>(
            Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));

    // holds row identifier and its associated value for easy lookup in the 2D board array
    private Map<Character, Integer> rowKeyValues = new TreeMap<>();


    //ctor to initialize board
    public GameBoard() {
        board = new char[SIZE][SIZE];
        setRowKeyValues();
    }

    // Methods to print and update board
    // Symbols to represent board characters
    // '@' = HumanPlayer ships, '~' = water, 'M' = miss, '!' = sunk CPU ship, 'X' = sunk human ship
    // 'c' = cpu ship - c will be hidden by a '~'
    public void printBoard() {
        System.out.println("        0      1      2      3      4      5      6      7      8      9");
        for (int i = 0; i < board.length; i++) {
            System.out.print(CHAR_KEYS.get(i));
            System.out.print('|');
            for (int j = 0; j < board[i].length; j++) {
                // checking for ships, hits, and misses to update
                if (board[i][j] == '@' || board[i][j] == '!' || board[i][j] == 'X' || board[i][j] == 'M') {
                    System.out.printf("%7s", board[i][j]);
                }
                else {
                    System.out.printf("%7s", '~');
                }
            }
            System.out.println();
        }
    }
    // Symbols to represent board characters
    // '@' = HumanPlayer ships, '~' = water, 'M' = miss, '!' = sunk CPU ship, 'X' = sunk human ship
    // 'c' = cpu ship - c will be hidden by a '~'
    public void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public char[][] getBoard() {
        return board;
    }

    public Map<Character, Integer> getRowKeyValues() {
        return Collections.unmodifiableMap(rowKeyValues);
    }

    private void setRowKeyValues() {
        int value = 0;

        for (Character key : CHAR_KEYS) {
            rowKeyValues.put(key, value);
            value++;
        }
    }


}