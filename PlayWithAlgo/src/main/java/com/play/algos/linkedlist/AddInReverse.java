package com.play.algos.linkedlist;

public class AddInReverse {

  public static void main(String[] args) {
    ListNode B = new ListNode(9);
    B.next = new ListNode(9);
    B.next.next = new ListNode(9);
    ListNode A = new ListNode(1);
    System.out.println(addTwoNumbers(A, B));
  }

  public static ListNode addTwoNumbers(final ListNode A, final ListNode B) {
    if (A == null && B == null) {
      return null;
    }
    ListNode sum = null;
    ListNode head = null;
    int carry = 0;
    ListNode currentA = A;
    ListNode currentB = B;
    while (currentA != null && currentB != null) {

      int digitSum = currentA.val + currentB.val + carry;
      carry = digitSum / 10;
      ListNode temp = new ListNode(digitSum % 10);
      if (sum == null) {
        sum = temp;
        head = sum;
      } else {
        sum.next = temp;
        sum = sum.next;
      }
      currentA = currentA.next;
      currentB = currentB.next;

    }
    while (currentA != null) {
       int digitSum = currentA.val + carry;
      ListNode node = new ListNode(digitSum % 10);
      carry = digitSum / 10;
      if (sum == null) {
        sum = node;
        head = sum;
      } else {
        sum.next = node;
        sum = sum.next;
      }

      currentA = currentA.next;
    }
    while (currentB !=null ) {
      final int digitSum = currentB.val + carry;
      ListNode node = new ListNode(digitSum% 10);

      carry = digitSum / 10;
      if (sum == null) {
        sum = node;
        head = sum;
      } else {
        sum.next = node;
        sum = sum.next;
      }

      currentB = currentB.next;
    }
    if(carry !=0){
      ListNode node = new ListNode(carry);
      sum.next = node;
      sum = sum.next;
    }
    return head;
  }
}

