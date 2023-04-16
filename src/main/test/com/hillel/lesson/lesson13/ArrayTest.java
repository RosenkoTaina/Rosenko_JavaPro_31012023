package com.hillel.lesson.lesson13;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import com.hillel.rosenko.lessons.lesson13.ArrayDataException;
import com.hillel.rosenko.lessons.lesson13.ArrayTransfer;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ArrayTest {
  private final int[] inputArray;
  private final int[] expectedArray;

  public ArrayTest(int[] inputArray, int[] expectedArray) {
    this.inputArray = inputArray;
    this.expectedArray = expectedArray;
  }

  @Parameters
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {new int[] {1, 2, 3, 4, 5}, new int[] {5}},
        {new int[] {1, 2, 3, 4, 0}, new int[] {0}},
        {new int[] {4, 3, 2, 1}, new int[] {3, 2, 1}},
        {new int[] {1, 2, 4, 5, 6}, new int[] {5, 6}}
    });
  }

  @Test
  public void testArrayTransfer() {
    assertArrayEquals(expectedArray, ArrayTransfer.getTransferArray(inputArray));
  }
  @Test
  public void testArrayFilterException() {
    int[] input = new int[]{1, 2, 3};
    int[] input2 = new int[]{1, 2, 3, 4};
    assertThrows(ArrayDataException.class, () -> ArrayTransfer.getTransferArray(input));
    assertThrows(ArrayDataException.class, () -> ArrayTransfer.getTransferArray(input2));
  }

}





