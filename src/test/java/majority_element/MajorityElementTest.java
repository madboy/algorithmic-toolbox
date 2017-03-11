package majority_element;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import test_utils.TestUtils;

public class MajorityElementTest {

  private MajorityElement me;

  @Before
  public void init() {
    me = new MajorityElement();
  }

  @Test
  public void shortList() {
    int[] l = new int[] {2, 3, 9, 2, 2};
    assertEquals(1, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void noMajorityElement() {
    int[] l = new int[] {1, 2, 3, 4};
    assertEquals(-1, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void exactlyHalfIsNotEnough() {
    int[] l = new int[] {1, 2, 3, 1};
    assertEquals(-1, me.getMajorityElement(l, 0, l.length));
  }
}
