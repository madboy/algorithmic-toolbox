package fractional_knapsack;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class FractionalKnapsackTest {
  private FractionalKnapsack f;

  private static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  private void fillLoot(int[] loot, int min, int max) {
    for (int i = 0; i < loot.length; i++) {
      loot[i] = randInt(min, max);
    }
  }

  @Before
  public void init() {
    f = new FractionalKnapsack();
  }

  @Test
  public void moreCapacityThanItems() {
    int[] values = new int[] {2, 1, 3};
    int[] weights = new int[] {2, 1, 3};
    assertEquals(6.0, f.getOptimalValue(11, values, weights), 0.001);
  }

  @Test
  public void lowValue() {
    int[] values = new int[] {60, 100, 120};
    int[] weights = new int[] {20, 50, 30};
    assertEquals(180.0, f.getOptimalValue(50, values, weights), 0.001);
  }

  @Test
  public void fractions() {
    int[] values = new int[] {500};
    int[] weights = new int[] {30};
    assertEquals(166.6667, f.getOptimalValue(10, values, weights), 0.001);
  }

  @Test
  public void maximumValue() {
    int[] values = new int[] {2000000};
    int[] weights = new int[] {30};
    assertEquals(666666.6666666666, f.getOptimalValue(10, values, weights), 0.001);
  }

  @Test
  public void zeroWeight() {
    int[] values = new int[] {3, 2, 1};
    int[] weights = new int[] {2, 1, 0};
    assertEquals(6.0, f.getOptimalValue(10, values, weights), 0.001);
  }

  @Test
  public void maximumNumberOfItems() {
    int[] values = new int[1000];
    int[] weights = new int[1000];

    fillLoot(values, 1, 2000000);
    fillLoot(weights, 0, 2000000);

    f.getOptimalValue(2000000, values, weights);
  }
}
