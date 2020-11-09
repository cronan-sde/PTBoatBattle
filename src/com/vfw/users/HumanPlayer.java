package com.vfw.users;

import java.util.ArrayList;
import java.util.Scanner;

//TODO: implement HumanPlayer Class
public class HumanPlayer extends Player{
   private Scanner scan = new Scanner(System.in);
   private ArrayList<String> playerPosition;

   public ArrayList<String> getHumanPlayerPosition() {
      return playerPosition;
   }

   public void playerPosition(ArrayList<String> humanPlayerPosition) {
      this.playerPosition = playerPosition;
   }

   public HumanPlayer(String name) {
      super(name);
   }

   @Override
   public String setShips() {
      String location = null;
      boolean isValid = false;

      while (!isValid) {
         System.out.print("Enter the location to place the ship: ");
         location = scan.nextLine().toUpperCase();

         if (location.length() == 2) {
            isValid = true;
         }
         else {
            System.out.println(invalidFormat());
         }
      }

      return location;
   }

   @Override
   public String generateShot() {
      String location = null;
      boolean isValid = false;

      while (!isValid) {
         System.out.print("Enter the location you would like to shoot at: ");
         location = scan.nextLine().toUpperCase();

         if (location.length() == 2) {
            isValid = true;
         }
         else {
            System.out.println(invalidFormat());
         }
      }
      return location;
   }

   @Override
   public void setPlayerPosition(ArrayList<String> cpuPosition) {
      this.playerPosition = playerPosition;
   }

   // returns message that user entered location in an invalid form
   private String invalidFormat() {
      return "Invalid Input - location must be in form of row letter + column number -" +
              " e.g. A1, B2, D5 etc. Case Insensitive";
   }
}