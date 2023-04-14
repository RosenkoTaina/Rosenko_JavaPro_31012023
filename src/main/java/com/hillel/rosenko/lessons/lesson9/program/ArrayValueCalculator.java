package com.hillel.rosenko.lessons.lesson9.program;

public class ArrayValueCalculator {
  public static int doCalc(String[][] arr) throws MyCustomException {
    int sum = 0;
    if (arr.length != 2 || arr[0].length != 4) {
      throw new MyCustomException("Array size should be 4x4");
    }
    for (String[] row : arr) {
      for (String val : row) {
        try {
          sum += Integer.parseInt(val);
        } catch (NumberFormatException e) {
          throw new MyCustomException("Invalid value in array: " + val, e);
        }
      }
    }
    return sum;
  }
}