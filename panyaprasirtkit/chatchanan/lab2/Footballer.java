package panyaprasirtkit.chatchanan.lab2;

/**
 * This Footballer program is to accept three arguments: footballer name, the
 * the nationality of the footballer, and the football club that the footballer
 * plays.
 * It's output format is
 * “My Favorite football player is <footballer name>.
 * His nationality as <nationality>
 * He plays for <club name>”
 *
 * Author: Chatchanan Panyaprasirtkit
 * ID: 653040123-1
 * Sec: 2
 * Date: December 9, 2022
 *
 **/
class Footballer {
    public static void main(String[] args) {
        if (args.length != 3) { // Check length of args that's user input
            System.out.println("Usage: Footballer <footballer name> <nationality> <club name>"); // True then print this
        } else { // If the condition is False then print these 3 outputs
            String player = args[0];
            String national = args[1];
            String club = args[2];
            System.out.println("My favorite football player is " + player); // Football player output (Set to args1)
            System.out.println("His nationality is " + national); // Nationality of player output (Set to args2)
            System.out.println("He plays for " + club); // club of Football player output (Set to args3)
        }
    }
}
