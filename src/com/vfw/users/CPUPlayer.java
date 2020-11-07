package com.vfw.users;

import java.util.HashSet;
import java.util.Set;

//TODO: implement CPUPlayer class
class CPUPlayer extends Player{

    private Set<String> usedLocations = new HashSet<>(); //keep track of all used coordinates for CPU

    @Override
    public String setShips() {
        return null;
    }

    @Override
    public String generateShot() {
        return null;
    }
}