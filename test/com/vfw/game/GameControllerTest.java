package com.vfw.game;

import com.vfw.users.CPUPlayer;
import com.vfw.users.HumanPlayer;
import com.vfw.users.Player;
import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GameControllerTest {
    private GameController controller;
    private GameBoard board;
    private Player human;
    private Player cpu;
    List<String> humanShips = Stream.of("A1", "D5", "E8", "J9", "H4").collect(Collectors.toList());

    @Before
    public void init() {
        board = new GameBoard();
        human = new HumanPlayer("Dude");
        human.setShips(humanShips);
        cpu = new CPUPlayer();
        controller = new GameController(board, human, cpu);
    }

    @Test
    public void testGetCpuPosition_shouldAdd5ValidEntriesOnBoardAndSameEntriesInCPUplayerLocationList() {
        controller.getCpuPosition();
        //Make sure 5 ship locations were placed in cpu's playerShips List
        assertEquals(5, cpu.getShips().size());
        //check that players ships were properly mapped in the game board
        for (String position : cpu.getShips()) {
            int x = board.getStringCoords().get(position).x;
            int y = board.getStringCoords().get(position).y;
            assertEquals('c', board.getBoard()[x][y]);
        }
    }

    @Test
    public void testGenerateCPUCoordinate_shouldReturnUniqueStringNotInUsedLocationAndAddTOUsedLocationList() {
        //Testing 100 strings, 10X10 game board means 100 unique combinations
        Set<String> uniqueStrings = new HashSet<>(); //use to test if all unique string in usedLocations
        CPUPlayer cpuPlayer = (CPUPlayer) cpu; //downcast to access usedLocations
        for (int i = 0; i < 100; i++) {
            controller.generateCPUCoordinate();
        }
        assertEquals(100, cpuPlayer.getUsedLocations().size()); //should have 100 Strings
        //Testing uniqueness of Strings
        cpuPlayer.getUsedLocations().forEach(uniqueStrings::add); //add all Strings to uniqueStrings Set
        assertEquals(100, uniqueStrings.size()); //Should still have 100 total Strings
    }

    @Test
    public void testIsHit_shouldReturnTrueAndRemoveShipFromList_whenLocationCoincidingWithOpponentsShips() {
        //human ships at "A1", "D5", "E8", "J9", "H4"
        controller.getCpuPosition();
        assertTrue(controller.isHit("A1",cpu));
        assertEquals(4, human.getShips().size());
        assertTrue(controller.isHit("D5",cpu));
        assertEquals(3, human.getShips().size());
        assertTrue(controller.isHit("E8",cpu));
        assertEquals(2, human.getShips().size());
        assertTrue(controller.isHit("J9",cpu));
        assertEquals(1, human.getShips().size());
        assertTrue(controller.isHit("H4",cpu));
        assertEquals(0, human.getShips().size());
    }

    @Test
    public void testIsHit_shouldReturnFalse_whenLocationDoesNotCoincideWithAShip() {
        //human ships at "A1", "D5", "E8", "J9", "H4"
        controller.getCpuPosition();
        //test boundaries around A1
        assertFalse(controller.isHit("A0",cpu));//test left boundary
        assertFalse(controller.isHit("A2", cpu)); //test right boundary
        assertFalse(controller.isHit("B1", cpu)); //test southern boundary
        //playePositions should still have 5 ships
        assertEquals(5, human.getShips().size());
    }

    @Test
    public void testGameOver_shouldReturnTrue_whenPlayerHasNoShipsLeft() {
        //clearing human ships to test gameover
        human.getShips().clear(); //no ships left
        assertTrue(controller.gameOver()); //should return true
    }

    @Test
    public void testGameOver_shouldReturnFalse_whenBothPlayersHaveShipsLeft() {
        controller.getCpuPosition(); //setting cpu ships, human already has ships
        assertFalse(controller.gameOver()); //should return false
    }

    @Test
    public void testDetermineWinner_shouldReturnStringCongratulatingHumanPlayer_whenCPUPlayerHasNoShipsLeft() {
        String humanWins = "Congratulations Dude you have sunk all of CPU's ships"; //message should be returned
        //set cpu ships
        controller.getCpuPosition();
        //remove all ships from cpu, simulating losing
        cpu.getShips().clear();
        assertEquals(humanWins, controller.determineWinner());
    }

    @Test
    public void testDetermineWinner_shouldReturnStringTellingHumanPlayerCPUHasWon_whenHumanPlayerHasNoShipsLeft() {
        String cpuWins = "Game Over!\nCPU has sunk all of Dude's ships"; //message should be returned
        //empty human players ships
        human.getShips().clear();
        assertEquals(cpuWins, controller.determineWinner());
    }

    @Test
    public void testIsValidShot_shouldReturnTrue_whenShotNotInShootingPlayersListAndNotOutsideBoard() {
        // human player ship locations "A1", "D5", "E8", "J9", "H4"
        // board boundaries A0-J9
        assertTrue(controller.isValidShot("A0", human)); //should return true
        assertTrue(controller.isValidShot("J8", human)); //should return true
        assertTrue(controller.isValidShot("D6", human)); //should return true
    }

    @Test
    public void testIsValidShot_shouldReturnFalse_whenShotIsInPlayersShipList() {
        // human player ship locations "A1", "D5", "E8", "J9", "H4"
        //all should return false
        assertFalse(controller.isValidShot("A1", human));
        assertFalse(controller.isValidShot("D5", human));
        assertFalse(controller.isValidShot("E8", human));
        assertFalse(controller.isValidShot("J9", human));
        assertFalse(controller.isValidShot("H4", human));
    }

    @Test
    public void testIsValidShot_shouldReturnFalse_whenShotOutsideGameBoard() {
        //Board boundaries A0-J9
        assertFalse(controller.isValidShot("A10", human));//should return false
        assertFalse(controller.isValidShot("J10", human));//should return false
        assertFalse(controller.isValidShot("K0", human));//should return false
    }

    @Test
    public void testUpdateGameBoard_shouldUpdateXYPositionOnBoardWithCPUPlayerSymbols_whenPassedCPUPositions() {
        //manually place CPU positions at ship at "B3" [1,3] = 'c' hit at "A2" [0,2] = 'X' "A0" [0,0] = ''
        controller.updateGameBoard("B3", cpu.getShipSymbol());
        assertEquals('c', board.getBoard()[1][3]); //should return true
        controller.updateGameBoard("A2", cpu.getHitSymbol());
        assertEquals('X', board.getBoard()[0][2]); //should return true
        controller.updateGameBoard("A0", cpu.getMissSymbol());
        assertEquals(Character.MIN_VALUE, board.getBoard()[0][0]); //should return true
    }

    @Test
    public void testUpdateGameBoard_shouldUpdateXYPositionOnBoardWithHumanPlayerSymbols_whenPassedHumanPositions() {
        //manually place human shots, misses and ensure location on board is updated with proper symbol
        // "C2" - [2,2] = @, "G4" - [6,4] = '!' hit, "E1" - [4,1] = 'M' miss
        controller.updateGameBoard("C2", human.getShipSymbol());
        assertEquals('@', board.getBoard()[2][2]);
        controller.updateGameBoard("G4", human.getHitSymbol());
        assertEquals('!', board.getBoard()[6][4]);
        controller.updateGameBoard("E1", human.getMissSymbol());
        assertEquals('M', board.getBoard()[4][1]);
    }
}