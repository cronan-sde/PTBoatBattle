package com.vfw.users;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanPlayerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getShipSymbol() {
        HumanPlayer hp = new HumanPlayer("@");
        assertEquals('@',hp.getShipSymbol());
    }

    @Test
    public void getHitSymbol() {
        HumanPlayer hp = new HumanPlayer("!");
        assertEquals('!', hp.getHitSymbol());
    }

    @Test
    public void getMissSymbol() {
        HumanPlayer hp = new HumanPlayer("M");
        assertEquals('M',hp.getMissSymbol());
    }

    @Test
    public void getName() {
      HumanPlayer  hp = new HumanPlayer("Dude");
        assertEquals("Dude",hp.getName());


    }
}