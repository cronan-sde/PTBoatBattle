package com.vfw.client;

import com.vfw.game.PTBoatBattle;

public class PTBoatBattleClient {
    public static void main(String[] args) throws InterruptedException {
        PTBoatBattle ptbb = new PTBoatBattle();
        ptbb.initializeGame();
    }
}
