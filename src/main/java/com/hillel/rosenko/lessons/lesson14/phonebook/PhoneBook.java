package com.hillel.rosenko.lessons.lesson14.phonebook;

import java.util.ArrayList;
import java.util.Collections;
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

    phoneBook.putIfAbsent(name, List.of());
    List<Record> records = phoneBook.get(name);
    for (Record record : records) {
      if (record.phoneNumber().equals(phoneNumber)) {
        System.out.println("Record already exists!");
        return;
      }
    }
    List<Record> newRecords = new ArrayList<>(records);
    newRecords.add(new Record(name, phoneNumber));
    phoneBook.put(name, newRecords);
  }



  @Override
  public void find(String name) {
    Objects.requireNonNull(name, "Name cannot be null.");
    List<String> phoneNumbers = new ArrayList<>();
    if (phoneBook.containsKey(name)) {
      List<Record> records = Collections.singletonList(phoneBook.get(name).get(0));
      for (Record record : records) {
        phoneNumbers.add(record.phoneNumber());
      }
    }
    if (phoneNumbers.isEmpty()) {
      System.out.println("No records found");
    } else {
      for (String phoneNumber : phoneNumbers) {
        System.out.println(phoneNumber);
      }
    }
  }

  @Override
  public void findAll(String name) {
    Objects.requireNonNull(name, "Name cannot be null.");
    List<String> phoneNumbers = new ArrayList<>();
    for (String key : phoneBook.keySet()) {
      if (key.contains(name)) {
        List<Record> records = phoneBook.get(key);
        for (Record record : records) {
          phoneNumbers.add(record.phoneNumber());
        }
      }
    }
    if (phoneNumbers.isEmpty()) {
      System.out.println("No records found");
    } else {
      for (String phoneNumber : phoneNumbers) {
        System.out.println(phoneNumber);
      }
    }
  }
}
