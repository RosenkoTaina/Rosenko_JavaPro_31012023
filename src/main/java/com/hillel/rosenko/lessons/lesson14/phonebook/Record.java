package com.hillel.rosenko.lessons.lesson14.phonebook;

public class Record {
  private final String name;
  private String phoneNumber;
  public Record(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

//  @Override
//  public String toString() {
//    return "Record [Name = " + name + ", Phone Number = " + phoneNumber + "]\n";
//  }

  public String getName() {
    return this.name;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
