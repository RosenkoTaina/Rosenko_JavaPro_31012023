package com.hillel.rosenko.lessons.lesson14.phonebook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
  private Map<String, List<Record>> PhoneBook;

  public PhoneBook() {
    PhoneBook = new HashMap<>();
  }

  public void add(String name, String phoneNumber) {
    if (PhoneBook.containsKey(name)) {
      PhoneBook.get(name).add(new Record(name, phoneNumber));
    } else {
      ArrayList<Record> newRecord = new ArrayList<>();
      newRecord.add(new Record(name, phoneNumber));
      PhoneBook.put(name, newRecord);
    }
  }

  public String find(String name) {
    if (PhoneBook.containsKey(name)) {
      return PhoneBook.get(name).toString();
    } else {
      return "Record not found";
    }
  }

  public String findAll(String name) {
    StringBuilder result = new StringBuilder();
    for (String key : PhoneBook.keySet()) {
      if (key.contains(name)) {
        result.append(PhoneBook.get(key)).append("\n");
      }
    }
    if (result.length() > 0) {
      return result.toString();
    } else {
      return "No records found";
    }
  }
}

