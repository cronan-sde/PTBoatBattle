package com.vfw.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PTBoatBattleTest {
    private PTBoatBattle ptbB;

//    @Before
//    public void setUp(){
//       // PTBoatBattle ptbBattle = new PTBoatBattle();
//    }
    @Test
    public void testRandomNumbers(){
     // ensure not null & print to ensure good results
       PTBoatBattle ptbBattle = new PTBoatBattle();
        assertNotNull(ptbBattle.randomNumber());


    }
//    @Test
//    public void test_randomLeters(){
//        // ensure not null & print to ensure good results
//
//    }
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
