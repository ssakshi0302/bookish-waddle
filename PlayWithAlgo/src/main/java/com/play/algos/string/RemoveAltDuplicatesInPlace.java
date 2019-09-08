package com.play.algos.string;

public class RemoveAltDuplicatesInPlace {
  static char[] removeDuplicates(final String s) {
    char[] input = s.toCharArray();
    int[] count = new int[256];
    int resIndex = 0;
    for (int i = 0; i < input.length; i++) {
      if (count[input[i] ] % 2 != 0) {
        while (count[input[i] ] % 2 != 0) {
          count[input[i] ]++;
          i++;
        }
      }
      count[input[i] ]++;
      input[resIndex] = input[i];
      resIndex++;
    }
    char[] result = new char[resIndex];
    for (int i = 0; i < resIndex; i++) {
      result[i] = input[i];
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "you got beautiful eyes";
    final char[] result = removeDuplicates(s);
    for (char c : result) {
      System.out.print(c);
    }

  }
}
