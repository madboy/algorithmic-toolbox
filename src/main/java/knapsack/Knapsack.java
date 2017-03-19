package knapsack;

import java.util.*;

public class Knapsack {
  public static int[][] generateMatrix(int capacity, int[] w) {
    int[][] maxCarry = new int[capacity + 1][w.length + 1];
    for (int i = 1; i <= w.length; i++) {
      int weight = w[i - 1];
      for (int c = 0; c <= capacity; c++) {
        if (weight <= c) {
          maxCarry[c][i] = Math.max(weight + maxCarry[c - weight][i - 1], maxCarry[c][i - 1]);
        } else {
          maxCarry[c][i] = maxCarry[c][i - 1];
        }
      }
    }
    return maxCarry;
  }

  public static int optimalWeight(int capacity, int[] w) {
    int[][] maxCarry = generateMatrix(capacity, w);
    return maxCarry[capacity][w.length];
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
