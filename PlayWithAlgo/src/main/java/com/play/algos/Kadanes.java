package com.play.algos;

import java.util.ArrayList;
import java.util.Scanner;

public class Kadanes {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        int val = sc.nextInt();

        list.add(val);
      }
      System.out.println(maxSumContiguousArray(list));
    }
    sc.close();
  }

  private static int maxSumContiguousArray(ArrayList<Integer> list) {

    int maxSum = list.get(0);
    int currentSum = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      currentSum = Math.max(list.get(i), currentSum + list.get(i));
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }
    return maxSum;

  }

  /*package whatever //do not write package name here */

/*
import java.util.*;
import java.lang.*;
import java.io.*;

  class GFG {
    public static void main (String[] args) {
      //code
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for (int i=0; i<T; i++){
        int N= sc.nextInt();
        int maxSum = (N*(N+1))/2;
        // System.out.println(maxSum);
        int sum=0;
        for(int j=0;j<N-1; j++){
          sum = sum + sc.nextInt();
        }
//	  System.out.println(sum);
        System.out.println(maxSum-sum);

      }
    }
  }

*/

}