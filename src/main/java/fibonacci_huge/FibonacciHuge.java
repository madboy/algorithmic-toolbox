package fibonacci_huge;

import java.util.*;
import java.lang.Math;

public class FibonacciHuge {
  public static int getFibonacciMod(int n, int m) {
    if (n <= 1) {
      return n;
    }
    int[] table = new int[n + 1];
    table[0] = 0;
    table[1] = 1;
    for (int i = 2; i <= n; i++) {
      table[i] = (table[i - 1] + table[i - 2]) % m;
    }
    return table[n];
  }

  public static boolean largePisano(long m) {
    int n = 1;
    while (2 * Math.pow(5, n) <= m) {
      if (2 * (Math.pow(5, n)) == m) {
        return true;
      }
      n++;
    }
    return false;
  }

  public static boolean tenMultiple(long m) {
    int n = 1;
    while (Math.pow(10, n) <= m) {
      if (Math.pow(10, n) == m) {
        return true;
      }
      n++;
    }
    return false;
  }

  public static int pisanoPeriod(int m) {
    int[] table = new int[6 * m + 1];

    if (m == 1) {
      return 1;
    } else if (largePisano(m)) {
      return 6 * m;
    } else if (tenMultiple(m)) {
      return 15 * m / 10;
    } else {
      // If it's not one of the special pisano periods
      // we need to calculate the mod for fibonacci numbers
      // until the pattern 0 1 repeats and we know we're in the
      // next pisano period
      table[0] = 0;
      table[1] = 1;
      int i = 2;
      table[i] = (table[i - 1] + table[i - 2]) % m;
      int c = table[i];
      i += 1;
      while (true) {
        table[i] = (table[i - 1] + table[i - 2]) % m;
        int next = table[i];
        if (c == 0 && next == 1) {
          return i - 1;
        } else {
          i++;
          c = next;
        }
      }
    }
  }

  public static long getFibonacciHuge(long n, long m) {
    int pisano = pisanoPeriod((int) m);
    int reducedF = (int) (n % pisano);
    return getFibonacciMod(reducedF, (int) m);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    System.out.println(getFibonacciHuge(n, m));
  }
}
