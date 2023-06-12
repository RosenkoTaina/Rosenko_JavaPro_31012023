package main.test.com.hillel.rosenko.lessons.lesson17;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;

import com.hillel.rosenko.lessons.lesson17.Sorting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SortingTest {

  @ParameterizedTest
  @CsvSource(value = {
      "10,7,8,9,1,5:1,5,7,8,9,10",
      "1,2,3,4,5:1,2,3,4,5",
      "0,0,0,0,0:0,0,0,0,0",
      "-10,22,-5,0,5:-10,-5,0,5,22"},
      delimiter = ':')
  void testBubbleSort(String input, String expected) {
    int[] inputArr = CSVStringToIntArray(input);
    int[] expectedArr = CSVStringToIntArray(expected);
    assertArrayEquals(expectedArr, Sorting.bubbleSort(inputArr));
  }


  @ParameterizedTest
  @CsvSource(value = {
      "10,7,8,9,1,5:1,5,7,8,9,10",
      "1,2,3,4,5:1,2,3,4,5",
      "0,0,0,0,0:0,0,0,0,0",
      "-10,22,-5,0,5:-10,-5,0,5,22"},
      delimiter = ':')
   void testCocktailSort(String input, String expected) {
    int[] inputArr = CSVStringToIntArray(input);
    int[] expectedArr = CSVStringToIntArray(expected);
    assertArrayEquals(expectedArr, Sorting.cocktailSort(inputArr));
  }


  @ParameterizedTest
  @CsvSource(value = {
      "10,7,8,9,1,5:10,7,8,9,1,5",
      "1,2,3,4,5:1,2,3,4,5",
      "0,0,0,0,0:0,0,0,0,0",
      "-10,22,-5,0,5:-10,22,-5,0,5"},
      delimiter = ':')
  void testBubbleSort2(String input, String expected){
    int[] inputArr = CSVStringToIntArray(input);
    int[] expectedArr = CSVStringToIntArray(expected);
    assertArrayEquals(Arrays.stream(expectedArr).sorted().toArray(), Sorting.bubbleSort(inputArr));

  }

  //CSV String explicit conversion
  public int[] CSVStringToIntArray(String input) {
    return input != null ? Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray() :
        null;
  }
}