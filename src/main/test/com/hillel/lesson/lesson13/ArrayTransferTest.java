package com.hillel.lesson.lesson13;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hillel.rosenko.lessons.lesson13.ArrayTransfer;
import com.hillel.rosenko.lessons.lesson13.ArrayDataException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ArrayTransferTest {

  @Test
  void testGetTransferArray() throws ArrayDataException {
    int[] arr1 = {1, 2, 3, 4, 5};
    int[] expected1 = {5};
    assertArrayEquals(expected1, ArrayTransfer.getTransferArray(arr1));

    int[] arr2 = {1, 2, 3, 4};
    int[] expected2 = {};
    assertArrayEquals(expected2, ArrayTransfer.getTransferArray(arr2));

    int[] arr3 = {4, 3, 2, 1};
    int[] expected3 = {3};
    assertFalse(Arrays.equals(expected3, ArrayTransfer.getTransferArray(arr3)));

    int[] arr4 = {1, 2, 4, 5, 6};
    int[] expected4 = {5, 6};
    assertArrayEquals(expected4, ArrayTransfer.getTransferArray(arr4));
  }

  @Test
  void testDoesArrayContainNumbers() throws ArrayDataException {
    int[] arr1 = {1, 2, 3, 4, 5};
    boolean expected1 = false;
    assertEquals(expected1, ArrayTransfer.doesArrayContainNumbers(arr1));

    int[] arr2 = {1, 1, 1, 1};
    boolean expected2 = false;
    assertEquals(expected2, ArrayTransfer.doesArrayContainNumbers(arr2));

    int[] arr3 = {4, 4, 4, 4};
    boolean expected3 = false;
    assertEquals(expected3, ArrayTransfer.doesArrayContainNumbers(arr3));

    int[] arr4 = {1, 1, 4, 1, 5};
    boolean expected4 = false;
    assertEquals(expected4, ArrayTransfer.doesArrayContainNumbers(arr4));

    int[] arr5 = {7, 1, 4, 1, 4};
    boolean expected5 = false;
    assertEquals(expected5, ArrayTransfer.doesArrayContainNumbers(arr5));

    int[] arr6 = {1, 1, 5, 1, 4};
    boolean expected6 = false;
    assertEquals(expected6, ArrayTransfer.doesArrayContainNumbers(arr6));

    int[] arr7 = {1, 4, 1, 4, 1};
    boolean expected7 = true;
    assertEquals(expected7, ArrayTransfer.doesArrayContainNumbers(arr7));
  }

  @Test
  void testGetTransferArrayException() {
    int[] arr1 = null;
    assertThrows(NullPointerException.class, () -> ArrayTransfer.getTransferArray(arr1));

    int[] arr2 = {1, 2, 3};
    assertThrows(ArrayDataException.class, () -> ArrayTransfer.getTransferArray(arr2));
  }

}