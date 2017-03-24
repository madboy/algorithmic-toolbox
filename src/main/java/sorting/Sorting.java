package sorting;

import java.io.*;
import java.util.*;

public class Sorting {
  private static Random random = new Random();

  private static int randomInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  private static void swap(int[] A, int f, int t) {
    int tmp = A[f];
    A[f] = A[t];
    A[t] = tmp;
  }

  private static int[] partition3(int[] A, int l, int n) {
    swap(A, randomInt(l, n), n);
    int i = l;
    int k = l;
    int p = n;
    while (i < p) {
      if (A[i] < A[n]) {
        swap(A, i++, k++);
      } else if (A[i] == A[n]) {
        swap(A, i, --p);
      } else {
        i++;
      }
    }
    int m = Math.min(p - k, n - p + 1);

    //    swapRange(A,k,k+m-1,r-m+1,r);
    int sq = n - m + 1;
    for (int sk = k; sk < k + m; sk++) {
      swap(A, sk, sq);
      sq++;
    }
    return new int[] {k - 1, n - p + k + 1};
  }

  private static int partition2(int[] a, int l, int r) {
    int x = a[l];
    int j = l;
    for (int i = l + 1; i <= r; i++) {
      if (a[i] <= x) {
        j++;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
      }
    }
    int t = a[l];
    a[l] = a[j];
    a[j] = t;
    return j;
  }

  public static void randomizedQuickSort(int[] a, int l, int r) {
    if (l >= r) {
      return;
    }
    int k = random.nextInt(r - l + 1) + l;
    int t = a[l];
    a[l] = a[k];
    a[k] = t;
    //use partition3
    int[] m = partition3(a, l, r);
    randomizedQuickSort(a, l, m[0]);
    randomizedQuickSort(a, m[1], r);
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    randomizedQuickSort(a, 0, n - 1);
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
