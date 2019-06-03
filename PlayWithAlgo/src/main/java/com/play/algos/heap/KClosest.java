package com.play.algos.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest {

  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(-10);
    input.add(-50);
    input.add(70);
    input.add(40);
    input.add(18);
    input.add(80);
    input.add(15);
    int num = 20;
    int resultCount = 4;
    kClosest(input, num, resultCount);

  }

  private static void kClosest(final List<Integer> input, final int num, final int resultCount) {
    PriorityQueue<Pair> heap = new PriorityQueue<>(resultCount);
    int i;
    for (i = 0; i < resultCount; i++) {
      heap.add(new Pair(Math.abs(input.get(i) - num), i));
    }
    for (; i < input.size(); i++) {
      final int diff = Math.abs(input.get(i) - num);
      if (diff < heap.peek().getDiff()) {
        heap.remove();
        heap.add(new Pair(diff, i));
      }
    }
    for (int j = 0; j < resultCount; j++) {
      Pair pair = heap.poll();
      System.out.println(input.get(pair.getIndex()));
    }
  }

}
