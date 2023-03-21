package com.hillel.rosenko.lessons.lesson8;

import java.util.Random;

/**
 * Exceptions in Java.
 */
public class Main {

  public static void main(String[] args) {
    String[][] arr = new String[0][0];
    Random rnd = new Random();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = String.valueOf(rnd.nextInt(10));
      }
    }
    for (String[] row : arr) {
      for (String cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }

    ArrayValueCalculator calc = new ArrayValueCalculator();
    try {
      int sum = calc.doCalc(arr);
      System.out.println("Sum: " + sum);
    } catch (MyCustomException e) {
      if (e instanceof ArraySizeException) {
        System.out.println("Array size should be 4x4");
      } else if (e instanceof ArrayDataException) {
        System.out.println(e.getMessage());
      } else {
        e.printStackTrace();
      }
    }
  }
}













