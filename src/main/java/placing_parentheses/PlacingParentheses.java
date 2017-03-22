package placing_parentheses;

import java.util.Scanner;

public class PlacingParentheses {
  public static long[] minAndMax(int i, int j, long[][] M, long[][] m, char[] op) {
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    for (int k = i; k < j; k++) {
      long a = eval(M[i][k], M[k + 1][j], op[k]);
      long b = eval(M[i][k], m[k + 1][j], op[k]);
      long c = eval(m[i][k], M[k + 1][j], op[k]);
      long d = eval(m[i][k], m[k + 1][j], op[k]);

      min = Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
      max = Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
    }
    return new long[] {min, max};
  }

  public static long getMaximValue(String exp) {
    int n = exp.length() / 2 + 1;
    long[][] m = new long[n + 1][n + 1];
    long[][] M = new long[n + 1][n + 1];
    char[] op = new char[n];

    int index = 1; // Use a separate index to make sure digits and operations line up
    for (int i = 0; i < exp.length(); i++) {
      if (i % 2 == 0) {
        m[index][index] = Character.getNumericValue(exp.charAt(i));
        M[index][index] = Character.getNumericValue(exp.charAt(i));
      } else {
        op[index] = exp.charAt(i);
        index++;
      }
    }

    for (int s = 1; s <= n; s++) {
      for (int i = 1; i <= n - s; i++) {
        int j = i + s;
        long[] mam = minAndMax(i, j, M, m, op);
        m[i][j] = mam[0];
        M[i][j] = mam[1];
      }
    }
    return M[1][n];
  }

  private static long eval(long a, long b, char op) {
    if (op == '+') {
      return a + b;
    } else if (op == '-') {
      return a - b;
    } else if (op == '*') {
      return a * b;
    } else {
      assert false;
      return 0;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String exp = scanner.next();
    System.out.println(getMaximValue(exp));
  }
}
