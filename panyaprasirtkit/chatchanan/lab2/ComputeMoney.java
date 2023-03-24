package panyaprasirtkit.chatchanan.lab2;

/**
 * This ComputeMoney Program help Wanlee to Compute how much money Wanlee has.
 * She will input the number of notes of
 * 1,000 Baht, 500 Baht, 100 Baht and 20 Baht, the program should output the
 * total amount of money
 * Its output format is
 * "Total Money is <Total>"
 *
 * Author: Chatchanan Panyaprasirtkit
 * ID: 653040123-1
 * Sec: 2
 * Date: December 9, 2022
 *
 **/
class ComputeMoney {
    public static void main(String[] args) {
        if (args.length != 4) {// Check length of args that's user input
            // True then print this
            System.out.println(
                    "Usage: MoneyProcessor <# of 1,000 Baht Notes> <# of 500 Baht Notes> <# of 100 Baht Notes> <# of 20 Baht Notes>");
        } else {// If the condition is False then Compute money and print the output
            double b1000 = Double.parseDouble(args[0]) * 1000;
            double b500 = Double.parseDouble(args[1]) * 500;
            double b100 = Double.parseDouble(args[2]) * 100;
            double b20 = Double.parseDouble(args[3]) * 20;
            System.out.print("Total Money is " + (b1000 + b500 + b100 + b20));// <Total> output
        }
    }
}
