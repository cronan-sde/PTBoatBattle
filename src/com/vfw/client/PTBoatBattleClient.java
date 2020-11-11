package com.vfw.client;

import com.vfw.game.PTBoatBattle;

public class PTBoatBattleClient {

    public static void main(String[] args) throws InterruptedException {
        PTBoatBattle app = new PTBoatBattle();
        app.initializeGame();
    }
    // for demonstration purposes; go to gameController and un-comment-out in generateCPUCoordinate the println before return to see computers locations or else game could take a while
}
