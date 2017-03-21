package knapsack;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import test_utils.TestUtils;

public class KnapsackTest {
  Knapsack ks;

  @Before
  public void init() {
    ks = new Knapsack();
  }

  @Test
  public void simpleMatrix() {
    int[][] r = ks.generateMatrix(10, new int[] {6, 3, 4, 2});
    int[][] e =
        new int[][] {
          {0, 0, 0, 0, 0}, //0
          {0, 0, 0, 0, 0}, //1
          {0, 0, 0, 0, 2}, //2
          {0, 0, 3, 3, 3}, //3
          {0, 0, 3, 4, 4}, //4
          {0, 0, 3, 4, 5}, //5
          {0, 6, 6, 6, 6}, //6
          {0, 6, 6, 7, 7}, //7
          {0, 6, 6, 7, 8}, //8
          {0, 6, 9, 9, 9}, //9
          {0, 6, 9, 10, 10}, //10
        };
    for (int row = 0; row < e.length; row++) {
      assertTrue(
          String.format(
              "capacity %d: %s %s", row, Arrays.toString(e[row]), Arrays.toString(r[row])),
          Arrays.equals(e[row], r[row]));
    }
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

  @Test
  public void takeTwoTwo() {
    int r = ks.optimalWeight(9, new int[] {6, 5, 5, 4});
    assertEquals(9, r);
  }

  @Test
  public void takeThree() {
    int r = ks.optimalWeight(15, new int[] {1, 4, 8, 10});
    assertEquals(15, r);
  }

  @Test
  public void takeThree2() {
    int r = ks.optimalWeight(21, new int[] {1, 2, 3, 8, 10});
    assertEquals(21, r);
  }

  @Test
  public void takeFour() {
    int r = ks.optimalWeight(16, new int[] {10, 8, 3, 2, 1});
    assertEquals(16, r);
  }

  @Test
  public void takeFour2() {
    int r = ks.optimalWeight(14, new int[] {1, 2, 3, 4, 5, 16, 17});
    assertEquals(14, r);
  }

  @Test
  public void takeFive() {
    int r = ks.optimalWeight(18, new int[] {10, 8, 4, 3, 2, 1});
    assertEquals(18, r);
  }

  @Test
  public void takeSix() {
    int r = ks.optimalWeight(20, new int[] {10, 8, 4, 3, 2, 1});
    assertEquals(20, r);
  }

  @Test
  public void takeEveryOther() {
    int r = ks.optimalWeight(11, new int[] {10, 8, 5, 6, 7, 2});
    assertEquals(11, r);
  }

  @Test
  public void everythingToHeavy() {
    int r =
        ks.optimalWeight(
            19,
            new int[] {
              35, 35, 40,
            });
    assertEquals(0, r);
  }

  @Test
  public void canCarryMore() {
    int r = ks.optimalWeight(20, new int[] {4, 3, 2, 1});
    assertEquals(10, r);
  }

  @Test
  public void maxNumbers() {
    int[] maxedItems = TestUtils.randomList(300, 0, 10000);
    int r = ks.optimalWeight(10000, maxedItems);
  }

  @Test
  public void duplicates() {
    int r = ks.optimalWeight(10, new int[] {3, 5, 3, 3, 5});
    assertEquals(10, r);
  }

  @Test
  public void roomLeft() {
    int r = ks.optimalWeight(3, new int[] {1, 2});
    assertEquals(3, r);
  }
}
