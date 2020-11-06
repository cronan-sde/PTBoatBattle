package com.vfw.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {
    private GameBoard board;

    @Before
    public void init() {
        board = new GameBoard();
    }

    @Test
    public void testPrintBoard() {
        board.printBoard();
    }

    @Test
    public void testGetRowKeyValues() {
    }
}