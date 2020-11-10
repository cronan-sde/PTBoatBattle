package com.vfw.users;

import java.util.Arrays;

//TODO: implement HumanPlayer Class
public class HumanPlayer extends Player {
   private char playerShip = '@';
   private char playerHit = '!';
   private char playerMiss = 'M';

   public HumanPlayer(String name) {
      super(name);
   }


   @Override
   public String toString() {
      return "HumanPlayer{" +
              "playerPosition=" + Arrays.toString(super.getShips().toArray()) +
              '}';
   }
}