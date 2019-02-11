package com.play.algos;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestIncreasingMaxSubArraySum {
  public static void main(String[] args) {
    //code
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        list.add(sc.nextInt());

      }
      System.out.println(maxIncreasingSum(list));
    }
    sc.close();
  }

  static int maxIncreasingSum(ArrayList<Integer> list) {

    int[] LIS = new int[list.size()];

    for(int i=0; i<list.size();i++){
      LIS[i] = list.get(i);
    }
    for (int i = 1; i < list.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (list.get(i) > list.get(j)) {
          LIS[i] = Math.max(LIS[i], LIS[j] + list.get(i));
        }
      }
    }

    int maxSum = 0;
    for (int i = 0; i < LIS.length; i++) {
      if (maxSum < LIS[i]) {
        maxSum = LIS[i];
      }
    }
    return maxSum;
  }
}