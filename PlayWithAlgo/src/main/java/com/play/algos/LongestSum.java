package com.play.algos;

import java.util.List;

public class LongestSum {

  // DO NOT MODFIY THE LIST.
  // DO NOT MODFIY THE LIST.
  public int maxSubArray(final List<Integer> input) {
    boolean allNegative = true;
    int maxNegativeInput = Integer.MIN_VALUE;

    int currentSum = 0;
    int maxSum = 0;
    for (int i = 0; i < input.size(); i++) {
      if (allNegative && input.get(i) > 0) {
        allNegative = false;
      } else if (allNegative && input.get(i) < 0 && input.get(i) > maxNegativeInput) {
        maxNegativeInput = input.get(i);
      }
      currentSum = currentSum + input.get(i);
      if (currentSum < 0) {
        currentSum = 0;
      }
      if (currentSum > maxSum) {
        maxSum = currentSum;
      }
    }
    return allNegative ? maxNegativeInput : maxSum;
  }

}
