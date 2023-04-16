package com.hillel.rosenko.lessons.lesson14;

import static com.hillel.rosenko.lessons.lesson14.Task1.calcOccurrence;
import static com.hillel.rosenko.lessons.lesson14.Task1.countOccurrence;
import static com.hillel.rosenko.lessons.lesson14.Task1.countOccurrence2;
import static com.hillel.rosenko.lessons.lesson14.Task1.findOccurrence2;
import static com.hillel.rosenko.lessons.lesson14.Task1.findUnique;
import static com.hillel.rosenko.lessons.lesson14.Task1.findUnique2;
import static com.hillel.rosenko.lessons.lesson14.Task1.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class Task1Test {

  @Test
  void testCountOccurrence() {
    List<String> testList = Arrays.asList("Cat", "Cat", "Cat", "Cat", "Cat", "Dog");
    String str = "Cat";
    int expected = 5;
    int actual = countOccurrence(testList, str);
    assertEquals(expected, actual);

  }

  @Test
  void testCountOccurrence2() {
    List<String> testList = Arrays.asList("Cat", "Cat", "Cat", "Cat", "Cat", "Dog");
    String str = "Dog";
    int expected = 1;
    int actual = countOccurrence2(testList, str);
    assertEquals(expected, actual);

  }

  @Test
  void testEmptyArrayToList() {
    Object[] array = {};
    List<Object> list = toList(array);
    assertTrue(list.isEmpty());
  }

  @Test
  void testMultipleElementArrayToList() {
    Object[] array = {1, "two", 3.0};
    List<Object> list = toList(array);
    assertEquals(3, list.size());
    assertEquals(1, list.get(0));
    assertEquals("two", list.get(1));
    assertEquals(3.0, list.get(2));
  }

  @Test
  void testArrayWithNullToList() {
    Object[] array = {1, null, "three"};
    List<Object> list = toList(array);
    assertEquals(3, list.size());
    assertEquals(1, list.get(0));
    assertNull(list.get(1));
    assertEquals("three", list.get(2));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  void testFindUniqueWithUniqueValues(int value) {
    List<Integer> input = List.of(value);
    List<Integer> expectedOutput = List.of(value);
    assertEquals(expectedOutput, findUnique(input));
  }

  @Test
  void testFindUniqueWithDuplicateValues() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1);
    List<Integer> expectedOutput = Arrays.asList(1, 2, 3, 4);
    assertEquals(expectedOutput, findUnique(input));
  }

  @Test
  void testFindUniqueWithEmptyList() {
    List<Integer> input = List.of();
    List<Integer> expectedOutput = List.of();
    assertEquals(expectedOutput, findUnique(input));
  }


  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  void testFindUnique2WithUniqueValues(int value) {
    List<Integer> input = List.of(value);
    List<Integer> expectedOutput = List.of(value);
    assertEquals(expectedOutput, findUnique2(input));
  }


  @Test
  void testFindUnique2DuplicateValues() {
    List<Integer> input = List.of(1, 2, 3, 4, 4, 4, 2, 1, 4, 7);
    List<Integer> result = findUnique2(input);
    List<Integer> expectedOutput = Arrays.asList(1, 2, 3, 4, 7);
    assertEquals(expectedOutput.size(), result.size());

  }


  @Test
  public void testCalcOccurrence() {
    List<String> list = Arrays.asList("apple", "banana", "banana", "cherry", "banana", "apple");
    Map<String, Integer> expected = new HashMap<>();
    expected.put("apple", 2);
    expected.put("banana", 3);
    expected.put("cherry", 1);
    assertEquals(expected, calcOccurrence(list));
  }

  @Test
  void testFindOccurrence2WithStrings() {
    List<String> list = Arrays.asList("apple", "banana", "orange", "apple", "orange", "pear");
    Map<String, Long> expected = new HashMap<>();
    expected.put("apple", 2L);
    expected.put("banana", 1L);
    expected.put("orange", 2L);
    expected.put("pear", 1L);

    Map<String, Long> result = findOccurrence2(list);

    assertEquals(expected.size(), result.size());
    assertTrue(expected.entrySet().containsAll(result.entrySet()));
  }

  @Test
  void testFindOccurrence2WithIntegers() {
    List<Integer> list = Arrays.asList(1, 2, 3, 2, 3, 3);
    Map<Integer, Long> expected = new HashMap<>();
    expected.put(1, 1L);
    expected.put(2, 2L);
    expected.put(3, 3L);

    Map<Integer, Long> result = findOccurrence2(list);

    assertEquals(expected.size(), result.size());
    assertTrue(expected.entrySet().containsAll(result.entrySet()));
  }
}

