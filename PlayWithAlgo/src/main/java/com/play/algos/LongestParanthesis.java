package com.play.algos;

public class LongestParanthesis {
  static int maxbalancedprefix(String str, int n)
  {
    int sum = 0;
    int maxi = 0;

    // Traversing the string.
    for (int i = 0; i < n; i++) {

      // If open bracket add 1 to sum.
      if (str.charAt(i) == '(')
        sum += 1;

        // If closed bracket subtract 1
        // from sum
      else
        sum -= 1;

      // If sum is 0, store the index
      // value.
      if (sum == 0)
        maxi = i;
    }

    return maxi + 1;
  }

  // Driven Program
  public static void main (String[] args)
  {
    String str = "((())())())((";
    int n = str.length();

    System.out.println( maxbalancedprefix(str, n));


   /* final Long MICROS_PER_DAY = new Long(24 * 60 * 60 * 1000 * 1000);
    final Long MILLIS_PER_DAY = new Long(24 * 60 * 60 * 1000);
    System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
   */ final long MICROS_PER_DAY = 24 * 60 * 60 * 1000L * 1000;
    final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
    System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

  }

}
