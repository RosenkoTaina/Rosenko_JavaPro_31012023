package com.hillel.rosenko.lessons.lesson14.phonebook;
public interface PhoneBookInterface {
  void add(String name, String phoneNumber);

  void find(String name);

  void findAll(String name);
}