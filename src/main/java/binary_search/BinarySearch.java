package binary_search;

import java.io.*;
import java.util.*;

public class BinarySearch {

  // Contraints:
  // 1≤𝑛,𝑘≤10^5;
  // 1≤𝑎𝑖 ≤10^9 for all 0≤𝑖<𝑛;
  // 1≤𝑏𝑗 ≤10^9 for all 0≤𝑗<𝑘;

  public static int binarySearch(int[] a, int x) {
    // get upper  and lower bound for the array that we're going to search
    // get the mid point and use that as comparison
    // if the number we're looking for is mid we're done
    // else
    // if it's smaller we should continue looking in the lower part of the array
    // if it's bigger we'll look in the upper part

    int left = 0, right = a.length;
    int i = 0;

    while ((right - left) > 0) {
      int mid = (right - left) / 2 + left;
      if (a[mid] == x) {
        return mid;
      } else if (x < a[mid]) {
        right = mid - 1;
      } else if (a[mid] < x) {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static int linearSearch(int[] a, int x) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == x) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    int m = scanner.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scanner.nextInt();
    }
    for (int i = 0; i < m; i++) {
      //replace with the call to binarySearch when implemented
      System.out.print(binarySearch(a, b[i]) + " ");
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
