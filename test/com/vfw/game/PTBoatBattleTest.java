package com.vfw.game;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class PTBoatBattleTest {
    private PTBoatBattle ptbB = new PTBoatBattle();

    @Before
    public void setUp(){
        PTBoatBattle ptbBattle = new PTBoatBattle();
    }
    @Test
    public void testRandomNumbers(){
     // ensure not null & print to ensure good results
      //  assertNotNull(ptbB.randomNumber());
        char[] numbs = new char[]{'0','1','2','3','4','5','6','7','8','9'};



    }
    @Test
    public void test_randomLetters(){
        // ensure not null & print to ensure good results
       // assertNotNull(ptbB.randomLetter());
        char[] letters = new char[]{'A','B','C','D','E','F','G','H','I','J'};

    }
//
//    @Test
//    public void test_getPlayersPositions(){
//        // this may need to be flexible  and have sout calls to ensure scanner is working and results are taken in and stored
//
//    }
//    @Test
//    public void test_getCpuPosition(){
//        // need to send to method char[][] playerPositions
//
//    }

}
