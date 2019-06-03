package com.play.algos.dp;

public class LCS {

  public static void main(String[] args) {
    String s1 = "ABGDHLNS";
    String s2 = "ADHFNSL";
    System.out.println(longestSubsequence(s1, s2));
  }

  private static int longestSubsequence(final String s1, final String s2) {
    int M = s1.length();
    int N = s2.length();
    if (M > 0 && N > 0) {
      int matrix[][] = new int[2][N + 1];
      for (int i = 0; i <= 2; i++) {
        matrix[i][0] = 0;
      }

      for (int j = 0; j <= N; j++) {
        matrix[0][j] = 0;
      }

      for (int i = 1; i <= M; i++) {
        for (int j = 1; j <= N; j++) {
          if (s1.charAt(i-1) == s2.charAt(j-1)) {
             matrix[i][j]= matrix[i-1][j-1] + 1;
          }else{
            matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]);
          }
        }
      }
      return matrix[M][N];
    }
    return 0;
  }
}
