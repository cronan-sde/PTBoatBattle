package com.vfw.users;


//TODO: implement HumanPlayer Class
public class HumanPlayer extends Player {
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
}