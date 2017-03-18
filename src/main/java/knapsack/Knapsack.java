package knapsack;

import java.util.*;

public class Knapsack {
  public static int optimalWeight(int capacity, int[] w) {
    //write you code here
    int result = 0;
    for (int i = 0; i < w.length; i++) {
      if (result + w[i] <= capacity) {
        result += w[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
  }
}
