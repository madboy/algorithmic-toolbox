package fractional_knapsack;

import java.util.Scanner;
import java.util.Arrays;

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

    final class Loot implements Comparable<Loot>{
      private int v;
      private int w;
      private double vow;

      public Loot(int v, int w) {
        this.v = v;
        this.w = w;
        vow = (double) v / w;
      }

      public int compareTo(Loot l) {
        if (this.vow < l.vow) {
          return 1;
        } else if (this.vow == l.vow) {
          return 0;
        }
        return -1;
      }

    }

    // calculate value per weight
    Loot[] lootTable = new Loot[values.length];
    for (int i = 0; i < values.length; i++) {
      lootTable[i] = new Loot(values[i], weights[i]);
    }

    Arrays.sort(lootTable);

    // Interesting thing, I played around with sorting the list of value_over_weight
    // but that turned out to be a lot slower than just doing the resort every time
    // not completely sure why but could be that the memory layout of the values is a lot worse
    // after the sort. Using an object for the loot and sorting that is even slower.
    // Could also be an artifact of how I was running the test. I was doing the same test
    // 1000 times which may skew results. Still switching to sorting since it makes for more readable
    // code and not noticeably slower on single runs.
    int items = 0;
    while (capacity > 0 && items < values.length) {

      if (capacity - lootTable[items].w < 0) {
        // pick a fraction
        value += (capacity / (double) lootTable[items].w) * lootTable[items].v;
        capacity = capacity - lootTable[items].w;
        items++;
      } else {
        // take the whole item
        value += lootTable[items].v;
        capacity = capacity - lootTable[items].w;
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
