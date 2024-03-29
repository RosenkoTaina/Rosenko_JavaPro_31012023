package com.hillel.rosenko.lessons.lesson14.task1;

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
  public static void main(String[] args) {

    List<Occurrence> occurrences =
        Occurrence.findOccurrence(Arrays.asList("bird", "cat", "dog", "bird", "cat"));
    for (Occurrence occurrence : occurrences) {
      System.out.println(occurrence.toString());
    }
  }




  public static int countOccurrence(List<String> list, String str) {
    if (list == null) {
      throw new IllegalArgumentException("List cannot be null");
    }
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
    return Arrays.asList(array);
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
    Map<String, Integer> duplicateCountMap;
    if (list == null || list.isEmpty()) {
      System.out.println("List is null or empty");
    } else {
      duplicateCountMap = list.stream().map(String::toLowerCase)
          .collect(Collectors.toMap(Function.identity(), items -> 1, Math::addExact));

      duplicateCountMap.forEach((key, value) -> System.out.println(key + " " + value));
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