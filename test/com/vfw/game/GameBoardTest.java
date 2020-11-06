package com.vfw.game;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class GameBoardTest {
    private GameBoard board;

    @Before
    public void init() {
        board = new GameBoard();
    }

    @Test
    public void testUpdateGameBoard_shouldVisuallyAddCharsInProperLocation() {
        board.updateBoard(0,0, '@');
        board.updateBoard(2,2, 'M');
        board.updateBoard(3,6, '!');
        board.updateBoard(7,3, 'X');
        board.updateBoard(9,9, 'c');
        //visually inspect A0 = @, C2 = M, D6 = !, H3 = X
        // J9 = ~ the c should remain hidden
        board.printBoard();
    }

    @Test
    public void testPrintBoard_visuallyInspectBoardLayout() {
        board.printBoard();
    }

    @Test
    public void testGetRowKeyValues_shouldBeProperlyMappedLetterToValue() {
        // A=0, B=1, C=2,.....J=9
        Map<Character, Integer> letterKeyValue = board.getRowKeyValues();
        assertEquals(10, letterKeyValue.size());
        assertEquals(Integer.valueOf(0), letterKeyValue.get('A'));
        assertEquals(Integer.valueOf(9), letterKeyValue.get('J'));
    }
}