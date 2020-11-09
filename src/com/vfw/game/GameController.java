package com.vfw.game;


class GameController {

    //TODO: implement
    // NOTE: this is just a rough sample to get us started and is in no way the final product
    // or even the direction we need to go, just ideas we can talk about and change anything we want
    // to fit our needs
    public String takeTurns() {
        String winnerName = null;
        //e.g. usage
        if (isValidShot("A1")) {
            // if is valid shot, check hit
            if (isHit("A1")) {
                //check for win
                if (isWin()) {
                    winnerName = determineWinner();
                }
                else {
                    // no winner yet, but player has lost a ship
                }
            }
            else {
                // no hit, continue playing
            }
        }
        else {
            //not a valid shot, re-enter a new shot
        }
        return winnerName;
    }

    //TODO: implement
    // Takes in a shot, checks if the shot is a valid location within the game board
    // returns boolean and takes String in form of "A1"-"J9"
    // If valid shot, pass it off to isHit() to check for hits
    public boolean isValidShot(String shot) {
        return false; //placeholder for now
    }

    //TODO: implement
    // Takes in a shot, checks if the shot was a hit or miss
    // returns true if a hit, false if miss
    // Should also update the game board with either a '!' for sunk cpu ship
    // or 'X' for sunk player ship or 'M' if miss, need to account for who fired shot
    // and whose ship was sunk
    // Call isWin() if there is a hit to see if it was last ship to be sunk
    public boolean isHit(String shot) {
       return false; //placeholder
    }

    //TODO: implement
    // check if either player has 0 ships left
    // return true if a player has 0 ships
    // return false if both players still have ships
    public boolean isWin() {
        return false; //placeholder
    }

    //TODO: implement
    // determine which player has ships left and return their name
    public String determineWinner() {
        String playerName = "name";
        return playerName;
    }
}