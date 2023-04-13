package com.hillel.rosenko.lessons.lesson14.phonebook;

import java.util.Scanner;


public class ConsoleInterface implements PhoneBookInterface {
  private static Scanner scanner = new Scanner(System.in);
  private PhoneBook phoneBook;

  public ConsoleInterface() {
    phoneBook = new PhoneBook();
  }

  public void start() {
    String command;
    System.out.println("Welcome to Phone Book!");
    while (true) {
      System.out.println("Enter a command (add, find, find all, exit):");
      command = scanner.nextLine();

      switch (command) {
        case "add":
          addRecord();
          break;
        case "find":
          findRecord();
          break;
        case "find all":
          findAllRecords();
          break;
        case "exit":
          System.out.println("Goodbye!");
          return;
        default:
          System.out.println("Invalid command!");
      }
    }
  }

  public void add(String name, String phoneNumber) {
    phoneBook.add(name, phoneNumber);
    System.out.println("Record added successfully!");
  }

  public String find(String name) {
    return phoneBook.find(name);
  }

  public String findAll(String name) {
    return phoneBook.findAll(name);
  }

  private void addRecord() {
    System.out.println("Enter name:");
    String name = scanner.nextLine();

    System.out.println("Enter phone number:");
    String phoneNumber = scanner.nextLine();

    add(name, phoneNumber);
  }

  private void findRecord() {
    System.out.println("Enter name to search:");
    String name = scanner.nextLine();
    System.out.println(find(name));
  }

  private void findAllRecords() {
    System.out.println("Enter name to search:");
    String name = scanner.nextLine();
    System.out.println(findAll(name));
  }
}

