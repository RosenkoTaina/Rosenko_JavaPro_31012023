package com.hillel.rosenko.lessons.lesson14.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Occurrence {
  private final String name;
  private final int occurrence;

  public Occurrence(String name, int occurrence) {
    this.name = name;
    this.occurrence = occurrence;
  }

  public Occurrence() {
    this("", 0);
  }

  public static List<Occurrence> findOccurrence(List<String> list) {
    if (list == null || list.isEmpty()) {
      System.out.println("List is empty or null.");
      return Collections.emptyList();
    }

    Map<String, Integer> wordCountMap = new HashMap<>();
    for (String word : list) {
      if (word == null) {
        continue;
      }
      String lowercaseWord = word.toLowerCase();
      wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
    }

    List<Occurrence> occurrences = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
      occurrences.add(new Occurrence(entry.getKey(), entry.getValue()));
    }
    return occurrences;
  }

  public String getName() {
    return name;
  }

  public int getOccurrence() {
    return occurrence;
  }

  @Override
  public String toString() {
    return "{" + "name:'" + name + '\'' + ", occurrence:" + occurrence + '}';
  }
}