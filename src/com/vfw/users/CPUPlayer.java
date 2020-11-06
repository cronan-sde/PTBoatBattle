package com.vfw.users;

public class CPUPlayer implements Player{

    private String previousShot;


    @Override
    public void generateShot() {


    }

    public String getPreviousShot() {
        return previousShot;
    }

    public void setPreviousShot(String previousShot) {
        this.previousShot = previousShot;
    }
}
