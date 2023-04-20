package com.hillel.lesson.lesson13;

import com.hillel.rosenko.lessons.lesson13.ArrayTransfer;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class ArrayContainNumbersTest {
  private final int[] inputArray;
  private final boolean expectedArray;

  public ArrayContainNumbersTest(int[] inputArray, boolean expectedArray) {
    this.inputArray = inputArray;
    this.expectedArray = expectedArray;
  }

  @Parameterized.Parameters
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {new int[] {1, 2, 3}, false},
        {new int[] {4, 5, 6}, false},
        {new int[] {1, 4, 2, 4, 3, 4}, false},
        {new int[] {1, 1, 1}, false},
        {new int[] {4, 4, 4}, false},
        {new int[] {1, 4, 1, 4}, true},

    });
  }

  @Test
  public void testIsArrayContainsNumbers() {
    assertEquals(expectedArray, ArrayTransfer.doesArrayContainNumbers(inputArray));
  }

}


