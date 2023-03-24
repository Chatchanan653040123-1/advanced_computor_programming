/**
 * This SicBo program is to simulates a Sic Bo game (also known in Thai as “ไฮโล”). The dealer of the game rolls three dice
 * , then the player places a bet of 10 Baht. 
 * The player can choose to play the game in two ways:
 * 1. Choosing high or low on the total of the three dice. If the total is between 3-10 then the total is low. If the total is between 11-18 then the total is high. If the player bets correctly, he/she wins 20 Baht. For example, if the player chooses high and the total is 15 then the player receives 20 Baht.
 * If the player bets incorrectly then the player loses 10 Baht.
 * 2. Choosing a number between 1-6 that will be on the three dice. If the player bets correctly, the player receives 3 times the amount of money that the player bets for each dice which is 10 Baht. 
 * For example, if the player chooses the number 3 and the three dices are 3, 6, and 3. This means the player is correct for two dice then he receives 3 * 10 + 3*10 = 60 Baht in total.
 *
 **/
package panyaprasirtkit.chatchanan.lab4;

import java.util.Scanner;

/**
 * 
 * This SicBoV4 program is to simulates a Sic Bo game (also known in Thai as
 * “ไฮโล”). The dealer of the game rolls three dice
 * , then the player places a bet of 10 Baht.
 * The program allows the user to make a choice on how they want to play the
 * game (high/low or a number between 1-6).
 * The program uses random number generation to simulate the rolling of dice,
 * and determines the outcome of the game based on the user's choice and the
 * result of the dice roll.
 * The program also tracks the user's game play and results, and stores them in
 * the gamePlay and gameResult arrays.
 * The method getChoice() prompts the user to make a choice on how they want to
 * play the game and the playGame method handles the game logic.
 * The method playGame() takes choice and the last digit of the id number as
 * input and depending on the choice, it will ask the user to enter 'h' for high
 * or 'l' for low or a number between 1-6.
 * And then it will generate three random numbers between 1-6, and depending on
 * the number of matches and the user's choice, it will determine if the user
 * wins or loses the game.
 * It also keep track of the game play and results of the user.
 * 
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 6/1/2023
 */
public class SicBoV4 {
    static int choice;
    static int currentInput = 0;
    final static int MAX_INPUT = 100;
    static String[] gamePlay = new String[MAX_INPUT];
    static String[] gameResult = new String[MAX_INPUT];
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Ask the player how they want to play the game, with input validation and
     * error handling.
     */
    public static void getChoice() {
        // Ask the player how they want to play the game
        while (true) {
            System.out.print(
                    "Choose how do you want to bet: \nType 1 for choosing high or low numbers: \nType 2 for choosing number between 1-6: \nEnter your choice :");
            try {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    currentInput++;
                    break;
                }
                System.out.println("Enter only 1 or 2:");
            } catch (Exception e) {
                System.out.println("Enter only 1 or 2:");
                scanner.nextLine();
            }
        }
    }

    /**
     * Play the game based on the choice of the user and the last digit of the id
     * number.
     * 
     * @param choice                      the choice of user how to play the game
     * @param the_last_digit_of_id_number the last digit of the id number
     */
    public static void playGame(int choice, int the_last_digit_of_id_number) {
        if (choice == 1) {
            do {
                // Ask the player to choose high or low
                System.out.print("Enter h for high or l for low: ");
                String highLow = scanner.next();

                // Generate three random numbers between 1-6
                int dice1 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                int dice2 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                int dice3 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                int total = dice1 + dice2 + dice3;
                // win case
                if ((highLow.equalsIgnoreCase("h") && total >= 11) || (highLow.equalsIgnoreCase("l") && total <= 10)) {
                    System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                            + "\nTotal is " + total + "\nYou won 20 Baht.\n");
                    gamePlay[currentInput] = String.valueOf(highLow);
                    gameResult[currentInput] = "You won 20 Baht.";
                    break;
                    // lose case
                } else if ((highLow.equalsIgnoreCase("h") && total <= 11)
                        || (highLow.equalsIgnoreCase("l") && total >= 10)) {
                    System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                            + "\nTotal is " + total + "\nYou lost 10 Baht.\n");
                    gamePlay[currentInput] = String.valueOf(highLow);
                    gameResult[currentInput] = "You lost 10 Baht.";
                    break;
                } else if (highLow.toLowerCase() != "h" && highLow.toLowerCase() != "l") {
                    System.out.println("Incorrect input. Enter h for high and l for low only.");
                }
            } while (true);

        } else if (choice == 2) {
            // Ask the player to choose a number between 1-6
            while (true) {
                System.out.print("Type in a number to bet on (1-6): ");
                try {
                    int number = scanner.nextInt();

                    if (number >= 1 && number <= 6) {
                        int dice1 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                        int dice2 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                        int dice3 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                        int number_of_dice_matches = 0;

                        if (dice1 == number) {
                            number_of_dice_matches++;
                        }
                        if (dice2 == number) {
                            number_of_dice_matches++;
                        }
                        if (dice3 == number) {
                            number_of_dice_matches++;
                        }
                        if (number_of_dice_matches == 0) {
                            System.out
                                    .print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                                            + "\nYou lost 10 Baht\n");
                            gamePlay[currentInput] = String.valueOf(number);
                            gameResult[currentInput] = "You lost 10 Baht";
                            break;

                        } else {
                            System.out.printf(
                                    "Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                                            + "\nYou won %s Baht\n",
                                    10 * number_of_dice_matches * (the_last_digit_of_id_number % 5 + (1)));
                            gamePlay[currentInput] = String.valueOf(number);
                            gameResult[currentInput] = "You won "
                                    + 10 * number_of_dice_matches * (the_last_digit_of_id_number % 5 + (1)) + " Baht";
                            break;
                        }
                    } else {
                        System.out.println("Incorrect input. Enter a number between 1-6 only.");
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number between 1-6 only.");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Incorrect input. Enter 1 or 2 only.");
        }
    }

    /**
     * 
     * This is the main method of the program where the game is executed.
     * The user is prompted to play again or exit the game.
     * The game displays the name and ID of the developer, and prompts the user to
     * make a choice before starting the game.
     * The last digit of the ID is used in the game logic.
     * 
     * @param args default args
     */
    public static void main(String[] args) {
        String checkIfUserWantToPlayAgain;
        String NameLastnameId = "ชัชนันท์ ปัญญาประเสริฐกิจ (653040123-1)";
        do {
            System.out.printf("Welcome to %s Game:\n", NameLastnameId);
            getChoice();
            char lastDigit = NameLastnameId.charAt(NameLastnameId.length() - 2);
            playGame(choice, lastDigit);
            System.out.println("Press A to play again. Press the other keys to exit.");
            checkIfUserWantToPlayAgain = scanner.next();
            if (!checkIfUserWantToPlayAgain.equalsIgnoreCase("A")) {
                System.out.println("### Game Play Summary ###");
                for (int i = 1; i <= currentInput; i++) {
                    System.out.printf("Game %s :\n", i - 1);
                    System.out.printf("You have bet on %s \n", gamePlay[i]);
                    System.out.println(gameResult[i]);
                }
                System.out.println("Good Bye!");

                break;
            }
        } while (true);
        scanner.close();
    }

}
