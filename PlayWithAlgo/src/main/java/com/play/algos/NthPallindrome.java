package com.play.algos;

public class NthPallindrome {

  public static void main(String[] args) {
    System.out.println(getNthNumber(5000));
  }

  /* Will return the nth binary palindrome number */
  static int getNthNumber(int n) {
    int group_no = 0, group_offset;
    int count_upto_group = 0, count_temp = 1;
    int op, aux_num;

    /* Add number of elements in all the groups,
       until the group of the nth number is found */
    while (count_temp < n) {
      group_no++;

      // Total number of elements until this group
      count_upto_group = count_temp;
      count_temp += 3 * (1 << (group_no - 1));
    }
    System.out.println(group_no);
    // Element's offset position in the group
    group_offset = n - count_upto_group - 1;

    /* Finding which bit to be placed in the
       middle and finding the number, which we
       will fill from the middle in both
       directions */
    if ((group_offset + 1) <= (1 << (group_no - 1))) {
      op = 2; // No need to put extra bit in middle

      // We need to fill this auxiliary number
      // in binary form the middle in both directions
      aux_num = group_offset;
    } else {
      if (((group_offset + 1) - (1 << (group_no - 1))) % 2 != 0)
        op = 0; // Need to Insert 0 at middle
      else
        op = 1; // Need to Insert 1 at middle
      aux_num = ((group_offset) - (1 << (group_no - 1))) / 2;
    }
    System.out.println(group_no);
    System.out.println(aux_num);
    return constructNthNumber(group_no, aux_num, op);
  }

  static int constructNthNumber(int group_no, int aux_num,
                                int op) {
    int a[] = new int[64];

    int num = 0, len_f;
    int i = 0;

    // No need to insert any bit in the middle
    if (op == 2) {
      // Length of the final binary representation
      len_f = 2 * group_no;

      // Fill first and last bit as 1
      a[len_f - 1] = a[0] = 1;

        /* Start filling the a[] from middle,
           with the aux_num binary representation */
      while (aux_num > 0) {
        // Get the auxiliary number's ith bit and
        // fill around middle
        a[group_no + i] = a[group_no - 1 - i]
            = aux_num & 1;
        aux_num = aux_num >> 1;
        i++;
      }
    }

    // Insert bit 0 in the middle
    else if (op == 0) {
      // Length of the final binary representation
      len_f = 2 * group_no + 1;

      // Fill first and last bit as 1
      a[len_f - 1] = a[0] = 1;
      a[group_no] = 0;

        /* Start filling the a[] from middle, with
        the aux_num binary representation */
      while (aux_num > 0) {
        // Get the auxiliary number's ith bit and fill
        // around middle
        a[group_no + 1 + i] = a[group_no - 1 - i]
            = aux_num & 1;
        aux_num = aux_num >> 1;
        i++;
      }
    } else     // Insert bit 1 in the middle
    {
      // Length of the final binary representation
      len_f = 2 * group_no + 1;

      // Fill first and last bit as 1
      a[len_f - 1] = a[0] = 1;
      a[group_no] = 1;

        /* Start filling the a[] from middle, with
           the aux_num binary representation */
      while (aux_num > 0) {
        // Get the auxiliary number's ith bit and fill
        // around middle
        a[group_no + 1 + i] = a[group_no - 1 - i]
            = aux_num & 1;
        aux_num = aux_num >> 1;
        i++;
      }
    }

    /* Convert the number to decimal from binary */
    for (i = 0; i < len_f; i++)
      num += (1 << i) * a[i];
    return num;
  }
}
