package com.hillel.rosenko.lessons.lesson13;

import java.util.Arrays;
import java.util.Random;

class ArrayTransferHandler {
  private int[] arr;

  public ArrayTransferHandler() {
    new ArrayTransfer();
  }

  public void transferFour() {
    Random rd = new Random(); // creating Random object
    arr = new int[5];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = rd.nextInt(10); // storing random integers in an array
      System.out.println(arr[i]); // printing each array element
    }
    try {
      int[] result = ArrayTransfer.getTransferArray(arr);
      System.out.println(Arrays.toString(result));
    } catch (NullPointerException ex) {
      System.out.println("Given array is null!");
    } catch (ArrayDataException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public void transferOnetoFour() {
//    Random rd = new Random(); // creating Random object
    arr = new int[] {4, 4, 1, 4, 5};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = rd.nextInt(10); // storing random integers in an array
//            System.out.println(arr[i]); // printing each array element
//        }
    try {
      boolean result = ArrayTransfer.doesArrayContainNumbers(arr);
      System.out.println(result);
    } catch (NullPointerException ex) {
      System.out.println("Given array is null!");
    } catch (ArrayDataException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
