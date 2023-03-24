/**
 * this program is called DisplayMatrix that accepts a matrix and then displays it in different ways. The program has the following properties:
 * The program must have thee variables outside the main method to keep all the data to run the program
 * one static 2-dimensional int array named matrix 
 * two static int variables named rowDim and colDim for the number of rows and columns respectively.
 * The program has 9 static methods.
 * inputMatrix() reads the number of rows and columns for rowDim and colDim. Then the method uses those numbers to create the matrix.  Then the method repeatedly asks to enter each element in the matrix. 
 * showMatrix() show the original matrix that has been entered.
 * showMatrixByRow() shows the matrix by row.
 * showMatrixByColumn() shows the matrix by column.
 * showMatrixByRowBackward() shows the matrix by row backward.
 * showMatrixByColumnBackward() shows the matrix by column backward.
 * showMatrixByDiagonalTopLeftBottomRight() shows the diagonal elements of the matrix from the top left to the bottom right.
 * showMatrixByDiagonalTopRightBottomLeft() shows the diagonal elements of the matrix from the top right to the bottom left.
 * showMatrixByRowZigzag() shows the matrix by row zigzag
 *
 **/
package panyaprasirtkit.chatchanan.lab4;

import java.util.Scanner;

/**
 * 
 * DisplayMatrix is a program that prompts the user to input a matrix, and then
 * displays the matrix in various formats,
 * such as by row, by column, backwards, by diagonal, and zigzag. The program
 * includes methods for inputting the matrix,
 * displaying the matrix in different ways, and handling input errors.
 * 
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 6/1/2023
 */
public class DisplayMatrix {

  static int[][] matrix;
  static int rowDim, colDim;
  static String rowAndColDim;
  static String[] rowAndColDimSplit;

  /**
   * 
   * The main method calls the following methods in order: inputMatrix(),
   * showMatrix(), showMatrixByRow(), showMatrixByColumn(),
   * showMatrixByRowBackward(), showMatrixByColumnBackward(),
   * showMatrixByDiagonalTopLeftBottomRight(),
   * showMatrixByDiagonalTopRightBottomLeft(),
   * showMatrixByRowZigzag()
   * 
   * @param args default args
   */
  public static void main(String[] args) {
    inputMatrix();
    showMatrix();
    showMatrixByRow();
    showMatrixByColumn();
    showMatrixByRowBackward();
    showMatrixByColumnBackward();
    showMatrixByDiagonalTopLeftBottomRight();
    showMatrixByDiagonalTopRightBottomLeft();
    showMatrixByRowZigzag();
  }

  /**
   * 
   * The inputMatrix method prompts the user to input the size of the matrix
   * (number of rows and number of columns) and elements of the matrix.
   * It also includes try-catch block to handle input errors and loops to ensure
   * the correct input is entered.
   */
  public static void inputMatrix() {
    // This try method is to handle if user didn't type anything or type less than
    // need or wrong type input and then loop this again
    try {
      Scanner scanner = new Scanner(System.in);
      // This do-while loop is to handle If user type more than need then type it
      // again
      do {
        System.out.print("Enter the size of the matrix (number of rows then number of collums) : ");
        rowAndColDim = scanner.nextLine();
        rowAndColDimSplit = rowAndColDim.split(" ");
        if (rowAndColDimSplit.length == 2) {
          rowDim = Integer.parseInt(rowAndColDimSplit[0]);
          colDim = Integer.parseInt(rowAndColDimSplit[1]);
          matrix = new int[rowDim][colDim];
          break;
        }
        System.out.println("Please enter two integer seperate by space (Example 1 2 or 3 4)");
      } while (rowAndColDimSplit.length != 2);

      for (int i = 0; i < rowDim; i++) {
        for (int j = 0; j < colDim; j++) {
          System.out.print("Enter element at row " + i + " column " + j + ": ");
          matrix[i][j] = scanner.nextInt();
        }
      }
      scanner.close();

    } catch (Exception e) {
      if (matrix == null || rowAndColDimSplit.length != 2) {
        System.out.println("Please enter two integer seperate by space (Example 1 2 or 3 4)");
      } else {
        System.out.println("Please enter the integer only (Example 1, 2, 3)");
        for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = 0;
          }
        }
      }
      inputMatrix();
    }
  }

  /**
   * 
   * The showMatrix method displays the original matrix entered by the user.
   */
  public static void showMatrix() {
    System.out.println("Show the original Matrix :");
    for (int i = 0; i < rowDim; i++) {
      for (int j = 0; j < colDim; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * 
   * The showMatrixByRow method displays the matrix by row.
   */
  public static void showMatrixByRow() {
    System.out.print("Show the matrix by row: ");
    for (int i = 0; i < rowDim; i++) {
      for (int j = 0; j < colDim; j++) {
        System.out.print(matrix[i][j] + " ");
      }
    }
    System.out.println();
  }

  /**
   * 
   * The showMatrixByColumn method displays the matrix by column.
   */
  public static void showMatrixByColumn() {
    System.out.print("Show the matrix by column: ");
    for (int j = 0; j < colDim; j++) {
      for (int i = 0; i < rowDim; i++) {
        System.out.print(matrix[i][j] + " ");
      }
    }
    System.out.println();
  }

  /**
   * 
   * The showMatrixByRowBackward method displays the matrix by row in backwards
   * order.
   */
  public static void showMatrixByRowBackward() {
    System.out.print("Show the matrix by row backward: ");
    for (int i = rowDim - 1; i >= 0; i--) {
      for (int j = colDim - 1; j >= 0; j--) {
        System.out.print(matrix[i][j] + " ");
      }
    }
    System.out.println();
  }

  /**
   * 
   * The showMatrixByColumnBackward method displays the matrix by column in
   * backwards order.
   */
  public static void showMatrixByColumnBackward() {
    System.out.print("Show the matrix by column backward: ");
    for (int j = colDim - 1; j >= 0; j--) {
      for (int i = rowDim - 1; i >= 0; i--) {
        System.out.print(matrix[i][j] + " ");
      }
    }
    System.out.println();
  }

  /**
   * 
   * The showMatrixByDiagonalTopLeftBottomRight method displays the matrix by
   * diagonal starting from top left corner to bottom right corner.
   */
  public static void showMatrixByDiagonalTopLeftBottomRight() {
    System.out.print("Show the diagonal elements of the matrix from top-left to bottom-right: ");
    for (int i = 0; i < rowDim; i++) {
      for (int j = 0; j < colDim; j++) {
        if (i == j) {
          System.out.print(matrix[i][j] + " ");
        }
      }
    }
    System.out.println();
  }

  /**
   * 
   * The showMatrixByDiagonalTopRightBottomLeft method displays the matrix by
   * diagonal starting from top right corner to bottom left corner.
   */
  public static void showMatrixByDiagonalTopRightBottomLeft() {
    System.out.print("Show the diagonal elements of the matrix from top-right to bottom-left: ");
    for (int i = 0; i < rowDim; i++) {
      for (int j = 0; j < colDim; j++) {
        if (i + j == colDim - 1) {
          System.out.print(matrix[i][j] + " ");
        }
      }
    }
    System.out.println();
  }

  /**
   * 
   * The showMatrixByRowZigzag method displays the matrix by row in a zigzag
   * pattern.
   */
  public static void showMatrixByRowZigzag() {
    System.out.print("Show the matrix by row zigzag: ");
    for (int i = 0; i < rowDim; i++) {
      // i%2 because if row is start from 0 which mean 0 % 2 = 0
      // example
      // 1 2 3 4 this is row 0
      // 4 5 6 7 this is row 1
      if (i % 2 == 0) {
        for (int j = 0; j < colDim; j++) {
          System.out.print(matrix[i][j] + " ");
        }
      } else {
        for (int j = colDim - 1; j >= 0; j--) {
          System.out.print(matrix[i][j] + " ");
        }
      }
    }
    System.out.println();
  }

}