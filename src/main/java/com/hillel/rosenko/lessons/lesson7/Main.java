package com.hillel.rosenko.lessons.lesson7;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    findSymbolOccurrence("", 'x');
    findWordPosition("Hello", "world");
    stringReverse("Hello");
    System.out.println(isPalindromeReverseTheString("homework"));
    palindrome("homework");
    Game game1 = new Game();
    game1.startGame();
  }


  private static void findSymbolOccurrence(String a, char b) {
    if (!a.isEmpty()) {
      int count = 0;
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == b) {
          count++;
        }
      }
      System.out.println(count);
    } else {
      System.out.println("String is empty");
    }
  }

  private static void findWordPosition(String source, String target) {
    if (source.contains(target)) {
      System.out.println(source.indexOf(target));
    } else {
      System.out.println(-1);
    }
  }

  private static void stringReverse(String a) {
    StringBuilder sb = new StringBuilder(a);
    sb.reverse();
    System.out.println(a + "--->" + sb);
  }

  public static boolean isPalindromeReverseTheString(String text) {
    StringBuffer reverse = new StringBuffer();
    String clean = text.replaceAll("\\s+", "").toLowerCase();
    char[] plain = clean.toCharArray();
    for (int i = plain.length - 1; i >= 0; i--) {
      reverse.append(plain[i]);
    }
    return (reverse.toString()).equals(clean);
  }

  private static void palindrome(String a) {
    String plain = a;
    String reverse = "";
    int strLength = plain.length();

    for (int i = (strLength - 1); i >= 0; --i) {
      reverse = reverse + a.charAt(i);
    }
    if (plain.equalsIgnoreCase(reverse)) {
      System.out.println(plain + " is a Palindrome String.");
    } else {
      System.out.println(plain + " is not a Palindrome String.");
    }
  }

  static class Game {
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

    private static void findMatch(String guess, String nameOfComputer) {
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

    public void startGame() {
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
          findMatch(guess, nameOfComputer);
        }
      } while (!guess.equals(nameOfComputer));
    }
  }

}








