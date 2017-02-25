package gcd;

import java.util.*;
import java.lang.Math;

public class GCD {
  public static int gcd(int a, int b) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);
    if (min == 0) {
      return max;
    }
    return gcd(min, max % min);
  }

  public static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for (int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
