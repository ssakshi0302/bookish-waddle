package com.play.algos.heap;

import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair implements Comparator , Comparable{
  int diff;
  int index;

  public Pair(final int diff, final int index) {
    this.diff = diff;
    this.index = index;
  }

  @Override
  public int compare(final Object o1, final Object o2) {
    return ((Pair) o2).diff - ((Pair) o1).diff;
  }

  @Override
  public int compareTo(final Object o) {
    return ((Pair)o).diff-this.diff;
  }
}
