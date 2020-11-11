package com.vfw.users;


import java.util.ArrayList;
import java.util.List;

public class HumanPlayer extends Player {
   private List<String> usedLocations = new ArrayList<>(); //keep track of all used coordinates for human
   private static final char SHIP_SYMBOL = '@';
   private static final char HIT_SYMBOL = '!';
   private static final char MISS_SYMBOL = 'M';

   public HumanPlayer(String name) {
      super(name);
   }

   @Override
   public char getShipSymbol() {
      return SHIP_SYMBOL;
   }

   @Override
   public char getHitSymbol() {
      return HIT_SYMBOL;
   }

   @Override
   public char getMissSymbol() {
      return MISS_SYMBOL;
   }

   // prevents repeat shots in same coordinates
   public List<String> getUsedLocations(){ return usedLocations;}
}