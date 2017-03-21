package edit_distance;

import java.util.*;

class EditDistance {
  public static int editDistance(String a, String b) {
    int n = a.length();
    int m = b.length();

    int[][] d = new int[n + 1][m + 1];

    for (int j = 0; j <= m; j++) {
      for (int i = 0; i <= n; i++) {
        if (j == 0) {
          d[i][j] = i;
        } else if (i == 0) {
          d[i][j] = j;
        } else {
          int insertion = d[i][j - 1] + 1;
          int deletion = d[i - 1][j] + 1;
          int match = d[i - 1][j - 1];
          int mismatch = d[i - 1][j - 1] + 1;
          if (a.charAt(i - 1) == b.charAt(j - 1)) {
            d[i][j] = Math.min(insertion, Math.min(deletion, match));
          } else {
            d[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
          }
        }
      }
    }
    return d[n][m];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
  }
}
