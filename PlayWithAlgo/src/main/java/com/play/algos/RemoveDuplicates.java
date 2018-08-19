package com.play.algos;

import java.util.ArrayList;

public class RemoveDuplicates {
  public static int removeDuplicates(ArrayList<Integer> a) {
    int j = 0;
    for (int i = 1; i < a.size(); i++) {
      if (a.get(i - 1).intValue() != a.get(i).intValue()) {
        System.out.println(a.get(i - 1));
        System.out.println(a.get(i));
        j++;
        a.set(j, a.get(i));
      }
    }
    System.out.println(j);
    return j + 1;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(5000);
    list.add(5000);
    list.add(5000);
    removeDuplicates(list);
  }
}
