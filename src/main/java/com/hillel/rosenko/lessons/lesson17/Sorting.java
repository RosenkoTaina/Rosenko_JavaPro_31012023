package com.hillel.rosenko.lessons.lesson17;

public class Sorting {
  public static int[] bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }


  public static int[] cocktailSort(int[] arr) {
    boolean swapped = true;
    int start = 0;
    int end = arr.length;

    while (swapped) {
      swapped = false;

      for (int i = start; i < end - 1; ++i) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }

      swapped = false;
      end = end - 1;

      for (int i = end - 1; i >= start; i--) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          swapped = true;
        }
      }

      start = start + 1;
    }
    return arr;
  }

}

