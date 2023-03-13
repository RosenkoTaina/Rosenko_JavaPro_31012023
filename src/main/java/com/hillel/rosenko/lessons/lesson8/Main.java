package com.hillel.rosenko.lessons.lesson8;

import java.util.Random;

/**
 * Exceptions in Java.
 */
public class Main {

  public static void main(String[] args) {

    String[][] arr = new String[4][4];
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
      int sum = ArrayValueCalculator.doCalc(arr);
      System.out.println("Sum: " + sum);
    } catch (MyCustomException e) {
      switch (e.getClass().getSimpleName()) {
        case "ArraySizeException" -> System.out.println("Array size should be 4x4");
        case "NumberFormatException" -> System.out.println(e.getMessage());
        default -> e.printStackTrace();
      }
    }
  }
}





