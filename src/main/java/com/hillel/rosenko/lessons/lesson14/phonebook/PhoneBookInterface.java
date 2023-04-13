package com.hillel.rosenko.lessons.lesson14.phonebook;

public interface PhoneBookInterface {
  void add(String name, String phoneNumber);
  String find(String name);
  String findAll(String name);
}
