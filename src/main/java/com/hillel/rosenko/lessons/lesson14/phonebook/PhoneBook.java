package com.hillel.rosenko.lessons.lesson14.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PhoneBook implements PhoneBookInterface {
  protected final Map<String, List<Record>> phoneBook;

  public PhoneBook() {
    phoneBook = new HashMap<>();
  }

  @Override
  public void add(String name, String phoneNumber) {
    Objects.requireNonNull(name, "Name cannot be null.");
    Objects.requireNonNull(phoneNumber, "Phone number cannot be null.");
    if (phoneBook.containsKey(name)) {
      List<Record> records = phoneBook.get(name);
      for (Record record : records) {
        if (record.phoneNumber().equals(phoneNumber)) {
          System.out.println("Record already exists!");
          return;
        }
      }
      records.add(new Record(name, phoneNumber));
    } else {
      ArrayList<Record> newRecord = new ArrayList<>();
      newRecord.add(new Record(name, phoneNumber));
      phoneBook.put(name, newRecord);
    }
  }

  @Override
  public void find(String name) {
    Objects.requireNonNull(name, "Name cannot be null.");

    if (phoneBook.containsKey(name)) {
      System.out.println(phoneBook.get(name).get(0).toString());
    } else {
      System.out.println("No records found");
    }
  }

  @Override
  public void findAll(String name) {
    Objects.requireNonNull(name, "Name cannot be null.");
    StringBuilder result = new StringBuilder();
    for (String key : phoneBook.keySet()) {
      if (key.contains(name)) {
        result.append(phoneBook.get(key)).append("\n");
      }
    }
    if (result.length() > 0) {
      System.out.println(result);
    } else {
      System.out.println("No records found");
    }
  }
}