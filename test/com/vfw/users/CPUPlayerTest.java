package com.vfw.users;

import org.junit.Test;

import static org.junit.Assert.*;

public class CPUPlayerTest {

    @Test
    public void getShipSymbol() {
        CPUPlayer cpu = new CPUPlayer();
        assertEquals('c', cpu.getShipSymbol());
    }

    @Test
    public void getHitSymbol() {
        CPUPlayer cpu = new CPUPlayer();
        assertEquals('X', cpu.getHitSymbol());
    }


}