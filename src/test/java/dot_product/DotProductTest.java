package dot_product;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class DotProductTest {
  private DotProduct dp;

  private static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  private void createSlots(int[] slots, int min, int max) {
    for (int i = 0; i < slots.length; i++) {
      slots[i] = randInt(min, max);
    }
  }

  @Before
  public void init() {
    dp = new DotProduct();
  }

  @Test
  public void noValue() {
    int[] value = new int[] {3, 3, 3};
    int[] clicks = new int[] {1, 0, -1};
    assertEquals(0, dp.maxDotProduct(value, clicks));
  }

  @Test
  public void singleSlot() {
    int[] a = new int[] {23};
    int[] b = new int[] {39};
    assertEquals(897, dp.maxDotProduct(a, b));
  }

  @Test
  public void mixedValues() {
    int[] a = new int[] {1, 3, -5};
    int[] b = new int[] {-2, 4, 1};
    assertEquals(23, dp.maxDotProduct(a, b));
  }

  @Test
  public void negativeValues() {
    int[] a = new int[] {3, 1, 2};
    int[] b = new int[] {-6, -1, -10};
    assertEquals(-25, dp.maxDotProduct(a, b));
  }
  @Test
  public void maximumValues() {
    int[] a = new int[] {100000};
    int[] b = new int[] {100000};
    assertEquals(10000000000L, dp.maxDotProduct(a, b));
  }

  @Test
  public void minimumValues() {
    int[] a = new int[] {-100000};
    int[] b = new int[] {-100000};
    assertEquals(10000000000L, dp.maxDotProduct(a, b));
  }

  @Test
  public void maximumSlots() {
    int[] a = new int[1000];
    int[] b = new int[1000];

    createSlots(a, -100000, 100000);
    createSlots(b, -100000, 100000);
    for (int i = 0; i < 1000; i++) {
      dp.maxDotProduct(a, b);
    }
  }
}
