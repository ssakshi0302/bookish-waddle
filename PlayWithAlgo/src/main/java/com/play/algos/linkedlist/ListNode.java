package com.play.algos.linkedlist;

import lombok.ToString;

@ToString
public class ListNode {
  public int val;
  public ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

}
