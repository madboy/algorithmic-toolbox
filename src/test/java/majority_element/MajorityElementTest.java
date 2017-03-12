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
  public void emptyListIsInvalid() {
    int[] l = new int[] {};
    assertEquals(-1, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void oneLengthListIsMajority() {
    int[] l = new int[] {4};
    assertEquals(4, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void anyOneLengthListIsMajority() {
    int rn = TestUtils.randInt(0, 1000000000);
    int[] l = new int[] {rn};
    assertEquals(rn, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void sameNumberInListIsMajority() {
    int[] l = new int[] {2, 2};
    assertEquals(2, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void hasMajorityElement() {
    int[] l = new int[] {2, 3, 9, 2, 2};
    assertEquals(2, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void partialMajorityElement() {
    int[] l = new int[] {9, 2, 2};
    assertEquals(2, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void trickerDistributionOfElement() {
    int[] l = new int[] {2, 3, 2, 9, 2, 9, 2};
    assertEquals(2, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void onlyMajorityElement() {
    int[] l = new int[] {2, 2, 2};
    assertEquals(2, me.getMajorityElement(l, 0, l.length));
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

  @Test
  public void equalElementsIsNotMajority() {
    int[] l = new int[] {5, 5, 5, 5, 3, 3, 3, 3};
    assertEquals(-1, me.getMajorityElement(l, 0, l.length));
  }

  @Test
  public void longList() {
    int[] l = TestUtils.randomList(100000, 1, 1000000000);
    assertEquals(-1, me.getMajorityElement(l, 0, l.length));
  }
}
