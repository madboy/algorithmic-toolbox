package sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import test_utils.TestUtils;

/** Created by kato on 12/03/17. */
public class SortingTest {
  private Sorting qs;

  @Before
  public void init() {
    qs = new Sorting();
  }

  @Test
  public void allTheSame() {
    int[] l = new int[] {1, 1, 1, 1};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }

  @Test
  public void oneSort() {
    int[] l = new int[] {2, 1, 1};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }

  @Test
  public void moreSort() {
    int[] l = new int[] {2, 1, 1, 3, 2};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }

  @Test
  public void fiveElements() {
    int[] l = new int[] {2, 3, 9, 2, 9};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }

  @Test
  public void shortLowDiversity() {
    int[] l = TestUtils.randomList(10000, 1, 5);
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }

  @Test
  public void longLowDiversity() {
    int[] l = TestUtils.randomList(100000, 1, 5);
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }

  @Test
  public void longDiverse() {
    int[] l = TestUtils.randomList(100000, 1, 1000000000);
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.randomizedQuickSort(l, 0, l.length - 1);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)), Arrays.equals(e, l));
  }
}
