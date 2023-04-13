package com.hillel.rosenko.lessons.lesson14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {

  public static int countOccurrence(List<String> list, String str) {
    int count = 0;
    for (String s : list) {
      if (s.equals(str)) {
        count++;
      }
    }
    return count;
  }


  public static int countOccurrence2(List<String> list, String str) {
    return Collections.frequency(list, str);
  }


  public static List<Object> toList(Object[] array) {
    return new ArrayList<>(Arrays.asList(array));
  }

  public static ArrayList<Integer> findUnique(List<Integer> list) {
    ArrayList<Integer> newList = new ArrayList<>();
    for (Integer element : list) {
      if (!newList.contains(element)) {
        newList.add(element);
      }
    }
    return newList;
  }

  public static List<Integer> findUnique2(List<Integer> list) {
    Set<Integer> set = new HashSet<>(list);
    return new ArrayList<>(set);
  }

  public static Map<String, Integer> calcOccurrence(List<String> list) {
    if (list == null || list.isEmpty()) {
      return Collections.emptyMap();
    }
    Map<String, Integer> occuranceMap = new HashMap<>();
    for (String word : list) {
      if (word != null) {
        word = word.toLowerCase();
        occuranceMap.put(word, occuranceMap.getOrDefault(word, 0) + 1);
      }
    }
    return occuranceMap;
  }


  public static void calcOccurrence2(List<String> list) {
    Map<String, Integer> duplicateCountMap =
        list.stream().collect(Collectors.toMap(Function.identity(), items -> 1, Math::addExact));
    duplicateCountMap.forEach((key, value) -> System.out.println("Key: " + key + " " + value));
  }


  public static void calcOccurrence3(List<String> list) {
    if (list == null || list.isEmpty()) {
      System.out.println("List is null or empty");
      return;
    }
    Map<String, Integer> duplicateCountMap = list.stream().map(String::toLowerCase)
        .collect(Collectors.toMap(Function.identity(), items -> 1, Math::addExact));

    duplicateCountMap.forEach((key, value) -> System.out.println(key + " " + value));
  }


  public static void findOccurrence(List<String> list) {
    if (list == null || list.isEmpty()) {
      System.out.println("List is empty or null.");
      return;
    }

    Map<String, Integer> wordCountMap = new HashMap<>();
    for (String word : list) {
      if (word == null) {
        continue;
      }
      String lowercaseWord = word.toLowerCase();
      wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
    }

    for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
      String name = entry.getKey();
      int occurrence = entry.getValue();
      System.out.println("{name: \"" + name + "\", occurrence: " + occurrence + "}");
    }
  }

  public static <T> Map<T, Long> findOccurrence2(List<T> list) {
    Map<T, Long> countMap =
        list.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
    countMap.entrySet().stream().forEach(
        entry -> System.out.printf("{name: \"%s\", occurrence: %d}%n",
            new Object[] {entry.getKey(), entry.getValue()}));
    return countMap;
  }

}






