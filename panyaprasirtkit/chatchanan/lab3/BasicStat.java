/**
 * This BasicStat program is find the minimum, the maximum, the average, 
 * the median, and the standard deviation of the list of numbers entered. 
 * The program reads all numbers from the console using Java class Scanner.
 * Author: Chatchanan Panyaprasirtkit
 * ID: 653040123-1
 * Sec: 2
 * Date: December 16, 2022
 *
 **/
package panyaprasirtkit.chatchanan.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class BasicStat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numbers (seperated by space): ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        double[] numbers = new double[inputArray.length];
        // to check condition
        if (input.length() == 0) {
            System.out.println("Please enter at least one number.");
        } else if (inputArray.length > 10) {
            System.out.println("Please enter number less than 10 numbers");
        } else {
            for (int i = 0; i < inputArray.length; i++) {
                try {
                    numbers[i] = Double.parseDouble(inputArray[i]);
                } catch (NumberFormatException e) {

                }
            }
            // sort the numbers
            Arrays.sort(numbers);

            double min = numbers[0];
            double max = numbers[numbers.length - 1];
            // find the average
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            double average = sum / numbers.length;

            // find the median
            double median;
            if (numbers.length % 2 == 0) {
                median = (numbers[numbers.length / 2] + numbers[numbers.length / 2 - 1]) / 2;
            } else {
                median = numbers[numbers.length / 2];
            }

            // calculate the standard deviation
            double sumOfSquares = 0;
            for (double num : numbers) {
                sumOfSquares += Math.pow(num - average, 2);
            }
            double variance = sumOfSquares / numbers.length;
            double standardDeviation = Math.sqrt(variance);

            System.out.println("Sort numbers are "
                    + Arrays.toString(numbers).replace("[", "").replace("]", "").replace(",", ""));
            System.out.println("Minimum: " + String.format("%.2f", min));
            System.out.println("Maximum: " + String.format("%.2f", max));
            System.out.println("Average: " + String.format("%.2f", average));
            System.out.println("Median: " + String.format("%.2f", median));
            System.out.println("Standard deviation: " + String.format("%.2f", standardDeviation));
        }
        scanner.close();
    }
}