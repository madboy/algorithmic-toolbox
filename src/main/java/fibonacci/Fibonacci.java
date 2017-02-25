package fibonacci;

import java.util.Scanner;

public class Fibonacci {
  public static long calc_fib(int n) {
    if (n <= 1) return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  public static long fasterFib(int n) {
    if (n <= 1) {
      return n;
    }
    int[] table = new int[n + 1];
    table[0] = 0;
    table[1] = 1;
    for (int i = 2; i <= n; i++) {
      table[i] = table[i - 1] + table[i - 2];
    }
    return table[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(fasterFib(n));
  }
}
