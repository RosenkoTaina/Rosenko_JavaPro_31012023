package com.hillel.rosenko.lessons.lesson7;

public class Main {
  public static void main(String[] args) {
    findSymbolOccurrence("", 'x');
    findWordPosition("Hello", "world");
    stringReverse("Hello");
    System.out.println(isPalindromeReverseTheString("homework"));
    palindrome("homework");
    new RandomWord().getRandomWord();
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
}








