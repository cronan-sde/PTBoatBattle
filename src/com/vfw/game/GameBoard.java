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
    private static final List<Character> ROW_IDENTIFIERS = new ArrayList<>(
            Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));

    // holds row identifier and its associated value for easy lookup in the 2D board array
    private final Map<String, Coordinates> stringCoords = new TreeMap<>();


    //ctor to initialize board
    public GameBoard() {
        board = new char[SIZE][SIZE];
        setStringCoords();
    }

    // Methods to print and update board
    // Symbols to represent board characters
    // '@' = HumanPlayer ships, '~' = water, 'M' = miss, '!' = sunk CPU ship, 'X' = sunk human ship
    // 'c' = cpu ship - c will be hidden by a '~'
    public void printBoard() {
        System.out.println("        0      1      2      3      4      5      6      7      8      9");
        for (int i = 0; i < board.length; i++) {
            System.out.print(ROW_IDENTIFIERS.get(i));
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

    //resets the games board
    public void resetBoard() {
        for (String position : getStringCoords().keySet()) {
            int x = getStringCoords().get(position).x;
            int y = getStringCoords().get(position).y;
            updateBoard(x,y,Character.MIN_VALUE);
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public Map<String, Coordinates> getStringCoords() {
        return Collections.unmodifiableMap(stringCoords);
    }

    private void setStringCoords() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            sb.append(ROW_IDENTIFIERS.get(i));
            for (int j = 0; j < SIZE; j++) {
                sb.append(j);
                stringCoords.put(sb.toString(), new Coordinates(i, j));
                sb.deleteCharAt(1);
            }
            sb.delete(0, sb.length());
        }
    }

    /*
     * Inner class to help map String keys "A0"-"J9" to an x,y coordinate value
     */
    class Coordinates {
        int x;
        int y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
}