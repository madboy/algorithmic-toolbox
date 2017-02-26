package lcm;

import java.util.*;
import java.lang.Math;

public class LCM {
  public static int gcd(int a, int b) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);
    if (min == 0) {
      return max;
    }
    return gcd(min, max % min);
  }

  public static long lcm(int a, int b) {
    return (long) a * b / gcd(a, b);
  }

  public static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l) if (l % a == 0 && l % b == 0) return l;

    return (long) a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
