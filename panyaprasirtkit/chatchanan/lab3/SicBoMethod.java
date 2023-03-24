/**
 * This SicBo program is to simulates a Sic Bo game (also known in Thai as “ไฮโล”). The dealer of the game rolls three dice
 * , then the player places a bet of 10 Baht. 
 * The player can choose to play the game in two ways:
 * 1. Choosing high or low on the total of the three dice. If the total is betwen 3-10 then the total is low. If the total is between 11-18 then the total is high. If the player bets correctly, he/she wins 20 Baht. For example, if the player chooses high and the total is 15 then the player receives 20 Baht.
 * If the player bets incorrectly then the player loses 10 Baht.
 * 2. Choosing a number between 1-6 that will be on the three dice. If the player bets correctly, the player receives 3 times the amount of money that the player bets for each dice which is 10 Baht. 
 * For example, if the player chooses the number 3 and the three dices are 3, 6, and 3. This means the player is correct for two dice then he receives 3 * 10 + 3*10 = 60 Baht in total.
 * Author: Chatchanan Panyaprasirtkit
 * ID: 653040123-1
 * Sec: 2
 * Date: December 16, 2022
 *
 **/
package panyaprasirtkit.chatchanan.lab3;

import java.util.Scanner;

public class SicBoMethod {
    static int choice;
    public static final Scanner scanner = new Scanner(System.in);

    static void getChoice() {
        // Ask the player how they want to play the game
        try {
            System.out.print(
                    "Choose how do you want to bet: \nType 1 for choosing high or low numbers: \nType 2 for choosing number between 1-6: \nEnter your choice :");
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.print("");
        }
    }

    static void playGame(int choice) {
        if (choice == 1) {

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

                // lose case
            } else if ((highLow.equalsIgnoreCase("h") && total <= 11)
                    || (highLow.equalsIgnoreCase("l") && total >= 10)) {
                System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                        + "\nTotal is " + total + "\nYou lost 10 Baht.\n");
            } else if (highLow.toLowerCase() != "h" && highLow.toLowerCase() != "l") {
                System.out.println("Incorrect input. Enter h for high and l for low only.");
            }

        } else if (choice == 2) {
            // Ask the player to choose a number between 1-6
            System.out.print("Enter a number between 1-6: ");
            try {
                int number = scanner.nextInt();

                if (number >= 1 && number <= 6) {
                    int dice1 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                    int dice2 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                    int dice3 = 1 + (int) (Math.random() * ((6 - 1) + 1));
                    int count = 0;

                    if (dice1 == number) {
                        count++;
                    }
                    if (dice2 == number) {
                        count++;
                    }
                    if (dice3 == number) {
                        count++;
                    }
                    if (count == 0) {
                        System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                                + "\nYou lost 10 Baht\n");

                    } else if (count == 1) {
                        System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                                + "\nYou won 30 Baht\n");
                    } else if (count == 2) {
                        System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                                + "\nYou won 60 Baht\n");
                    } else {
                        System.out.print("Dice 1 : " + dice1 + ", " + "Dice 2 : " + dice2 + ", " + "Dice 3 : " + dice3
                                + "\nYou won 90 Baht\n");
                    }
                } else {
                    System.out.print("Incorrect input. Enter a number between 1-6 only.");
                }
            } catch (Exception e) {
                System.out.print("Incorrect input. Enter a number between 1-6 only.");
            }
        } else {
            System.out.println("Incorrect input. Enter 1 or 2 only.");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        getChoice();
        playGame(choice);
    }

}
