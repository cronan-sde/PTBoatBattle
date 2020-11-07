package com.vfw.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
    public void testGetStringCoords_shouldBeProperlyMappedStringToCoordArray() {
        // A=0, B=1, C=2,.....J=9
        Map<String, GameBoard.Coordinates> letterKeyValue = board.getStringCoords();
        assertEquals(100, letterKeyValue.size()); //should be 100 mappings A0-J9
        //Testing lower bound A0 Coordinates
        assertEquals(0, letterKeyValue.get("A0").x);
        assertEquals(0, letterKeyValue.get("A0").y);

        //Testing upper bound J9 Coordinates
        assertEquals(9, letterKeyValue.get("J9").x);
        assertEquals(9, letterKeyValue.get("J9").y);
    }

    @Test
    public void testGetStringCoords_shouldProperlyDisplayKeyAndCoordnateValue_whenVisuallyInspecting() {
        Map<String, GameBoard.Coordinates> letterKeyValue = board.getStringCoords();

        for (String key : letterKeyValue.keySet()) {
            System.out.println("Key:" + key + ", Coordinates: " + letterKeyValue.get(key));
        }
    }
}