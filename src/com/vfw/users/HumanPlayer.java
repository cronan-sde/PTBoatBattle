package com.vfw.users;

import java.util.Arrays;

//TODO: implement HumanPlayer Class
public class HumanPlayer extends Player {
   private char shipSymbol = '@';
   private char hitSymbol = '!';
   private char missSymbol = 'M';

   public HumanPlayer(String name) {
      super(name);
   }
}