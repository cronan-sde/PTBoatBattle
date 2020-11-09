package com.vfw.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TODO: implement CPUPlayer class
public class CPUPlayer extends Player{

    public CPUPlayer(){

    }
    private ArrayList<String> playerPosition;

    private ArrayList<String> getPlayerPosition() {
        return playerPosition;
    }

    private Set<String> usedLocations = new HashSet<>(); //keep track of all used coordinates for CPU

    @Override
    public String setShips() {
        return null;
    }

    @Override
    public String generateShot() {
        return null;
    }

    @Override
    public void setPlayerPosition(List<String> cpuPosition) {

    }

    public Set<String> getUsedLocations() {
        return usedLocations;
    }

    public void setUsedLocations(Set<String> usedLocations) {
        this.usedLocations = usedLocations;
    }
}