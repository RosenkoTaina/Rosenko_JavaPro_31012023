package com.hillel.rosenko.lessons.lesson21;

import com.hillel.rosenko.lessons.lesson13.ArrayDataException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@RunWith(TestRunner.class)
public final class MyTest {

  private int[] testArray;
  private int[] shuffledArray;

  public static int[] stringToIntArray(String input) {
    return input != null ? Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray() :
        null;
  }
  @BeforeSuite
  public void setUp() {
    String input = "1,2,3,4,5,6,7,8,9,10";
    testArray = stringToIntArray(input);

    if (testArray == null) {
      throw new IllegalArgumentException("Input array cannot be null.");
    }
  }
  @Test(priority = 1)
  public void getShuffleArray() throws ArrayDataException {
    int[] array = testArray;
    if (array == null) {
      throw new ArrayDataException("Input array cannot be null.");
    }

    Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
    List<Integer> result = Arrays.asList(boxedArray);
    Collections.shuffle(result);
    shuffledArray = result.stream().mapToInt(Integer::intValue).toArray();
    System.out.println(Arrays.toString(shuffledArray));
  }

  @AfterSuite
  public void printArray() {
    int[] sortedArray = Arrays.stream(shuffledArray).sorted().toArray();
    if (!Arrays.equals(shuffledArray, sortedArray)) {
      System.out.println(Arrays.toString(sortedArray));
    } else {
      System.out.println("Вхідний масив відсортований!");
    }
  }
}






