package binary_search;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
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
  public void middleNumber() {
    int[] l = new int[]{1, 2, 3, 4, 5};
    assertEquals(2, bs.binarySearch(l, 3));
  }

  @Test
  public void lowerNumber() {
    int[] l = new int[]{1, 2, 3, 4, 5};
    assertEquals(0, bs.binarySearch(l, 1));
  }

  @Test
  public void upperNumber(){
    int[] l = new int[]{1,2,3,4,5};
    assertEquals(4, bs.binarySearch(l, 5));
  }

  @Test
  public void duplicates(){
    int[] l = new int[]{1,2,2,3,3,4,5};
    assertEquals(1, bs.binarySearch(l, 2));
  }

  @Test
  public void shortList() {
    int[] l = new int[]{1, 5, 8, 12, 13};
    int[] s = new int[]{8, 1, 23, 1, 11};
    int[] expected = new int[]{2, 0, -1, 0, -1,};

    for (int i = 0; i < s.length; i++) {
      int actual = bs.binarySearch(l, s[i]);
      assertEquals(expected[i], actual);
    }
  }

  @Test
  public void longList() {
    int[] l = new int[100000];
    for (int i = 0; i < l.length; i++){
      l[i] = randInt(1, 1000000000);
    }
    Arrays.sort(l);
    bs.binarySearch(l, 912090);
  }

  @Test
  public void lookingForThree() {
    int[] l = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    assertEquals(1, bs.binarySearch(l, 3));
  }

  @Test
  public void failingUploadTest() {
    int[] l = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    int[] s = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] expected = new int[] {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1};

    for (int i = 0; i < s.length; i++) {
      int actual = bs.binarySearch(l, s[i]);
      assertEquals(String.format("%d %d -> %d", expected[i], actual, s[i]), expected[i], actual);
    }
  }

}
