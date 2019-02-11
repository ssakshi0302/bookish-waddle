package com.play.algos;

import java.util.Arrays;
import java.util.List;

public class DutchFlag {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 0, 1, 0, 1, 2, 0, 0, 1);
    list= Arrays.asList(1,0,1,2,1,1,0,0,1,2,1,2,1,2,1,0,0,1,1,2,2,0,0,2,2,2,1,1,1,2,0,0,0,2,0,1,1,1,1,0,0,0,2,2,1,2,2,2,0,2,1,1,2,2,0,2,2,1,1,0,0,2,0,2,2,1,0,1,2,0,0,0,0,2,0,2,2,0,2,1,0,0,2,2);
    sortList(list);
    list.forEach(i -> System.out.print(i));
    System.out.println(list.get(28));
    System.out.println(list.get(53));
  }

  private static void sortList(final List<Integer> list) {
    int low = 0, mid = 0, high = list.size() - 1;
    int count0=0;
    int count1=0;
    int count2=0;
    while (mid <= high) {
      switch (list.get(mid)) {
        case 0:
          swap(mid, low, list);
          low++;
          mid++;
          count0++;
          break;
        case 1:
          mid++;
          count1++;
          break;
        case 2:
          swap(high, mid, list);
          high--;
          count2++;
      }
    }
    System.out.println("count" + count0 + "ggg " + count1 + "ffffffffff  "+ count2 );
  }

  private static void swap(final Integer a, final Integer b, final List<Integer> list) {
    int temp = list.get(a);
    list.set(a, list.get(b));
    list.set(b, temp);
  }
}
