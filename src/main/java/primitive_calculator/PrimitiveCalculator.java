package primitive_calculator;

import java.util.*;

public class PrimitiveCalculator {
  public static List<Integer> optimal_sequence(int n) {
    List<Integer> sequence = new ArrayList<>();
    int[] dp = getDp(n);

    int count = dp[n];
    sequence.add(n);
    for (int i = 0; i < count; i++) {
      int candidate = 1000;
      int alt = -1;

      if (n % 3 == 0 && dp[n / 3] < candidate) {
        candidate = dp[n/3];
        alt = n/3;
      }

      if (n % 2 == 0 && dp[n/2]< candidate) {
        candidate = dp[n/2];
        alt = n/2;

      }

      if (dp[n-1] < candidate) {
        alt = n-1;
      }

      sequence.add(alt);
      n = alt;

    }
    Collections.reverse(sequence);
    sequence.add(0, count);
    return sequence;
  }

  private static int[] maxedArray(int n) {
    int[] m = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      m[i] = 1000000;
    }
    return m;
  }

  public static int[] getDp(int n) {
    int[] dp = maxedArray(n);
    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      if (i % 3 == 0 && dp[i / 3] < dp[i]) {
        dp[i] = dp[i / 3] + 1;
      }

      if (i % 2 == 0 && dp[i / 2] < dp[i]) {
        dp[i] = dp[i / 2] + 1;
      }

      if (dp[i - 1] < dp[i]) {
        dp[i] = dp[i - 1] + 1;
      }
    }
    return dp;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> sequence = optimal_sequence(n);
    System.out.println(sequence.get(0));
    for (Integer x : sequence.subList(1,sequence.size())) {
      System.out.print(x + " ");
    }
  }
}
