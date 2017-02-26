package fractional_knapsack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FractionalKnapsack {
  public static double getOptimalValue(int capacity, int[] values, int[] weights) {
    double value = 0;

    // number of items 1 <= n <= 1000
    // capacity of knapsack 0 <= c <= 2000000
    // values 0 <= v <= 2000000
    // weights 0 < w <= 2000000

    // pick the most valuable item first and see if I can carry it, otherwise take a fraction of it.
    // if we can only take a fraction of the item we should be finished
    // else
    // remove the item we've picked up
    // go to next valuable

    // calculate value per weight
    double[] value_over_weight = new double[values.length];
    for (int i = 0; i < values.length; i++) {
      value_over_weight[i] = (double) values[i] / weights[i];
    }

    int items = 0;
    while (capacity > 0 && items < values.length) {
      double max_value = -1;
      int max_value_pos = -1;
      for (int i = 0; i < value_over_weight.length; i++) {
        if (value_over_weight[i] > max_value) {
          max_value = value_over_weight[i];
          max_value_pos = i;
        }
      }

      if (capacity - weights[max_value_pos] < 0) {
        // pick a fraction
        value += (capacity / (double) weights[max_value_pos]) * values[max_value_pos];
        capacity = capacity - weights[max_value_pos];
        items++;
      } else {
        // take all of it
        value += values[max_value_pos];
        capacity = capacity - weights[max_value_pos];
        value_over_weight[max_value_pos] = -1;
        items++;
      }
    }

    return value;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int capacity = scanner.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scanner.nextInt();
      weights[i] = scanner.nextInt();
    }
    System.out.println(getOptimalValue(capacity, values, weights));
  }
}
