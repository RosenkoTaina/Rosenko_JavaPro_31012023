package main.test.com.hillel.rosenko.lessons.lesson13;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import com.hillel.rosenko.lessons.lesson13.ArrayDataException;

import com.hillel.rosenko.lessons.lesson13.ArrayTransfer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

public class ArrayTransferTest {

  @ParameterizedTest
  @CsvSource(value = {
      "1,2,3,4,5:5",
      "1,2,3,4:",
      "4,3,2,1:3,2,1",
      "1,2,3,4,5,6:5,6"},
      delimiter = ':')
    //numbers before the "symbol" are the input data and numbers after "symbol" are the expected data
  void testGetTransferArray(String input, String expected) {
    int[] inputArr = CSVStringToIntArray(input);
    int[] expectedArr = CSVStringToIntArray(expected);
    if (expectedArr == null) {
      assertThrows(ArrayDataException.class, () -> ArrayTransfer.getTransferArray(inputArr));
    } else {
      assertArrayEquals(expectedArr, ArrayTransfer.getTransferArray(inputArr));
    }
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5:false",
      "1,1,1,1:false",
      "4,4,4,4:false",
      "1,1,4,1,5:false",
      "7,1,4,1,4:false",
      "1,1,5,1,4:false",
      "1,4,1,4,1:true"},
      delimiter = ':')
  void testDoesArrayContainNumbers(String input, boolean expected) {
    int[] inputArr = CSVStringToIntArray(input);
    assertEquals(expected, ArrayTransfer.doesArrayContainNumbers(inputArr));
  }

  @ParameterizedTest
  @NullSource
  @CsvSource(value = {"1,2,3"})
  void testGetTransferArrayThrowsException(String input) {
    int[] inputArr = CSVStringToIntArray(input);
    if (inputArr == null) {
      assertThrows(NullPointerException.class, () -> ArrayTransfer.getTransferArray(inputArr));
    } else {
      assertThrows(ArrayDataException.class, () -> ArrayTransfer.getTransferArray(inputArr));
    }
  }

  //CSV String explicit conversion
  public int[] CSVStringToIntArray(String input) {
    return input != null ? Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray() :
        null;
  }
}


