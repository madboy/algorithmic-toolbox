package sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/** Created by kato on 12/03/17. */
public class SortingTest {
  private Sorting s;

  @Before
  public void init() {
    s = new Sorting();
  }

  @Test
  public void sameElement() {
    int[] l = new int[] {1, 1, 1, 1};
    s.randomizedQuickSort(l, 0, l.length);
    assertTrue(Arrays.equals(new int[] {1, 1, 1, 1}, l));
  }
}
