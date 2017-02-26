package fibonacci_huge;

import java.util.*;
import java.lang.Math;

public class FibonacciHuge {
  public static int getFibonacciLastDigitFast(int n, int m) {
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
    if (m == 1) {
      return 1;
    } else if (largePisano(m)) {
      return 6 * m;
    } else if (tenMultiple(m)) {
      return 15 * m / 10;
    }
    int n = 1;
    int c = getFibonacciLastDigitFast(n, m);
    while (true) {
      int next = getFibonacciLastDigitFast(n + 1, m);
      if (c == 0 && next == 1) {
        return n;
      } else {
        c = next;
        n++;
      }
    }
  }

  public static long getFibonacciHuge(long n, long m) {
    int pisano;
    int[] table = new int[6* (int) m + 1];

    if (m == 1) {
      pisano = 1;
    } else if (largePisano(m)) {
      pisano = 6 * (int) m;
    } else if (tenMultiple(m)) {
      pisano =  15 * (int) m / 10;
    } else {
      table[0] = 0;
      table[1] = 1;
      int i = 2;
      table[i] = (table[i - 1] + table[i - 2]) % (int) m;
      int c = table[i];
      i += 1;
      while (true) {
        table[i] = (table[i - 1] + table[i - 2]) % (int) m;
        int next = table[i];
        if (c == 0 && next == 1) {
          pisano = i-1;
          break;
        } else {
          i++;
          c = next;
        }
      }
    }
    int reducedF = (int) (n % pisano);
    return getFibonacciLastDigitFast(reducedF, (int) m);
  }

  public static long getFibonacciHuge2(long n, long m) {
    int p = pisanoPeriod((int) m);
    return getFibonacciLastDigitFast((int) (n % p), (int) m);
  }

  public static long getFibonacciHugeNaive(long n, long m) {
    if (n <= 1) return n;

    long previous = 0;
    long current = 1;

    for (long i = 0; i < n - 1; ++i) {
      long tmp_previous = previous;
      previous = current;
      current = tmp_previous + current;
    }

    return current % m;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    System.out.println(getFibonacciHuge(n, m));
  }
}
