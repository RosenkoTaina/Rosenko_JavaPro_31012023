package com.hillel.rosenko.lessons.lesson7;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class RandomWord {
  private String nameOfComputer;
  private String nameOfUser;
  private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot",
      "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
      "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
      "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
      "potato"};

  public String getNameOfComputer() {
    Random generator = new Random();
    int index = generator.nextInt(words.length);
    return words[index];
  }

  public String getNameOfUser() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your name:");
    return sc.nextLine();
  }

  private static void printMatch(String guess, String nameOfComputer) {
    char[] str1 = guess.toCharArray();
    char[] str2 = nameOfComputer.toCharArray();
    int length = Math.max(str1.length, str2.length);
    char[] str3 = new char[length];
    Arrays.fill(str3, '*');

    for (int i = 0; i < length; i++) {
      if (i < str1.length && i < str2.length && Objects.equals(str1[i], str2[i])) {
        str3[i] = str1[i];
      }
    }
    System.out.println(Arrays.toString(str3));
  }

  public void getRandomWord() {
    nameOfUser = getNameOfUser();
    System.out.println("Hello, " + nameOfUser + "!");
    nameOfComputer = getNameOfComputer();
    System.out.println("Computer chose a word. Guess it!");
    System.out.println(Arrays.deepToString(words));
    Scanner sc = new Scanner(System.in);
    String guess;
    do {
      System.out.println("Enter your guess:");
      guess = sc.nextLine();
      if (guess.equals(nameOfComputer)) {
        System.out.println("Congratulations! You guessed the word.");
        return;
      } else {
        printMatch(guess, nameOfComputer);
      }
    } while (!guess.equals(nameOfComputer));
  }
}


