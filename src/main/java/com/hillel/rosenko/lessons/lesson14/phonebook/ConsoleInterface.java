package com.hillel.rosenko.lessons.lesson14.phonebook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConsoleInterface extends PhoneBook {
  private static Scanner scanner = new Scanner(System.in);

  public ConsoleInterface() {
    super();
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


  public static String getValidInput(String prompt, String regex) {
    String input;
    boolean isValid = false;
    Pattern pattern = Pattern.compile(regex);
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.print(prompt);
      input = scanner.nextLine();
      Matcher matcher = pattern.matcher(input);
      if (matcher.matches()) {
        isValid = true;
      } else {
        System.out.println("Invalid input. Please try again.");
      }
    } while (!isValid);
    return input;
  }

  private void addRecord() {
    String name = getValidInput("Enter name: ", "[a-zA-Z]+");
    String phoneNumber = getValidInput("Enter phone number: ", "\\+?\\d{2}-\\d{3}-\\d{3}-\\d{4}");
    add(name, phoneNumber);
  }

  private void findRecord() {
    String name = getValidInput("Enter name to search: ", "[a-zA-Z]+");
    find(name);
  }

  private void findAllRecords() {
    String name = getValidInput("Enter name to search: ", "[a-zA-Z]+");
    findAll(name);
  }

}
