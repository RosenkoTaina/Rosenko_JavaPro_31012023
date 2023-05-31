package com.hillel.rosenko.lessons.lesson15;
import java.util.Scanner;

public class CustomerInputHandler {
  private Scanner scanner;

  public CustomerInputHandler() {
    scanner = new Scanner(System.in);
  }

  public String getNameOfCustomer() {
    System.out.println("Enter name:");
    return scanner.nextLine();
  }
}