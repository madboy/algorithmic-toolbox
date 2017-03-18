package quick_sort;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
  private QuickSort qs;

  @Before
  public void init() {
    qs = new QuickSort();
  }

  @Test
  public void allTheSame() {
    int[] l = new int[] {1, 1, 1, 1};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.sort(l, 0, l.length);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)),
        Arrays.equals(e, l));
  }

  @Test
  public void oneSort() {
    int[] l = new int[] {2, 1, 1};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.sort(l, 0, l.length);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)),
        Arrays.equals(e, l));
  }

  @Test
  public void moreSort() {
    int[] l = new int[] {2, 1, 1, 3, 2};
    int[] e = Arrays.copyOf(l, l.length);
    Arrays.sort(e);
    qs.sort(l, 0, l.length);
    assertTrue(
        String.format("%s != %s", Arrays.toString(e), Arrays.toString(l)),
        Arrays.equals(e, l));
  }
}
