package knapsack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {
  Knapsack ks;

  @Before
  public void init() {
    ks = new Knapsack();
  }

  @Test
  public void takeOne() {
    int r = ks.optimalWeight(10, new int[] {2, 9});
    assertEquals(9, r);
  }

  @Test
  public void takeTwo() {
    int r = ks.optimalWeight(10, new int[] {1, 4, 8});
    assertEquals(9, r);
  }

}