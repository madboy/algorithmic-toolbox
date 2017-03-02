package binary_search;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
  private BinarySearch bs;

  private static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  @Before
  public void init() {
    bs = new BinarySearch();
  }

  @Test
  public void shortList() {
    int[] l = new int[] {1, 5, 8, 12, 13};
    int[] s = new int[] {8, 1, 23, 1, 11};
    int[] expected = new int[] {2, 0, -1, 0, -1,};

    for (int i = 0; i < s.length; i++){
      int actual = bs.binarySearch(l, s[i]);
      assertEquals(expected[i], actual);
    }
  }

}
