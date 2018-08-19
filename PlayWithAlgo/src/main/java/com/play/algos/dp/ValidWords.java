package com.play.algos.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidWords {
  private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("arrays", "dynamic", "heaps", "IDeserve", "IDeservelea", "learn", "learning", "linked", "list", "platform", "programming", "stacks", "trees"));

  public static void main(String[] args) {
    String input = "IDeservelearningplatform";
    System.out.println(containsValidWords(input));

  }

  private static boolean containsValidWords(String input) {
    if (input == null || input.length() == 0) {
      return true;
    }
    int n = input.length();
    boolean[] validWords = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (dictionary.contains(input.substring(0, i + 1))) {
        validWords[i] = true;
        for (int l = 0; l < input.length(); l++) {
          System.out.print(input.charAt(l) + " " + (validWords[l] == false ? 0 : 1) + " ");
        }
      }
      if (validWords[i] == true && (i == n - 1))
        return true;
      if (validWords[i] == true) {
        for (int j = i + 1; j < n; j++) {
          if (dictionary.contains(input.substring(i + 1, j + 1))) {
            validWords[j] = true;
          }
          if (j == n - 1 && validWords[j] == true) {
            for (int l = 0; l < input.length(); l++) {
              System.out.print(input.charAt(l) + " " + (validWords[l] == false ? 0 : 1) + " ");
            }
            return true;
          }
        }
      }
    }
    return false;
  }

}
