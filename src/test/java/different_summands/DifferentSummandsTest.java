package different_summands;

import test_utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class DifferentSummandsTest {

  private DifferentSummands df;

  @Before
  public void init() {
    df = new DifferentSummands();
  }

  @Test
  public void singleAnswer() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);

    List<Integer> actual = df.optimalSummands(1);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void singleAnswerTwo() {
    List<Integer> summands = new ArrayList<>();
    summands.add(2);

    List<Integer> actual = df.optimalSummands(2);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void twoPartsFour() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(3);

    List<Integer> actual = df.optimalSummands(4);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void threeParts() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(3);

    List<Integer> actual = df.optimalSummands(6);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void threePartsSeven() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(4);

    List<Integer> actual = df.optimalSummands(7);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void threePartsEight() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(5);

    List<Integer> actual = df.optimalSummands(8);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void threePartsNine() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(6);

    List<Integer> actual = df.optimalSummands(9);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void fourPartsTwenty() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(3);
    summands.add(4);
    summands.add(10);

    List<Integer> actual = df.optimalSummands(20);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void twentyNine() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(3);
    summands.add(4);
    summands.add(5);
    summands.add(6);
    summands.add(8);

    List<Integer> actual = df.optimalSummands(29);
    assertTrue(
        String.format("%s != %s", summands.toString(), actual.toString()), summands.equals(actual));
  }

  @Test
  public void maximumValue() {
    List<Integer> actual = df.optimalSummands(1000000000);
    assertEquals(44720, actual.size());
  }

  @Test
  public void randomNumbers() {
    for (int i = 0; i < 10; i++) {
      int n = TestUtils.randInt(1, 1000000000);
      List<Integer> actual = df.optimalSummands(n);

      int sum = 0;
      for (int s : actual) {
        sum += s;
      }
      assertEquals(sum, n);
    }
  }
}
