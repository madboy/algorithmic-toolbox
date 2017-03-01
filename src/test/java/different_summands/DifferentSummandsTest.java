package different_summands;

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
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void singleAnswerTwo() {
    List<Integer> summands = new ArrayList<>();
    summands.add(2);

    List<Integer> actual = df.optimalSummands(2);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void twoPartsFour() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(3);

    List<Integer> actual = df.optimalSummands(4);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void threeParts() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(3);

    List<Integer> actual = df.optimalSummands(6);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void threePartsSeven() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(4);

    List<Integer> actual = df.optimalSummands(7);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void threePartsEight() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(5);

    List<Integer> actual = df.optimalSummands(8);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void threePartsNine() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(3);
    summands.add(5);

    List<Integer> actual = df.optimalSummands(9);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void fourPartsTwenty() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(3);
    summands.add(5);
    summands.add(11);

    List<Integer> actual = df.optimalSummands(20);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void twentyNine() {
    List<Integer> summands = new ArrayList<>();
    summands.add(1);
    summands.add(2);
    summands.add(4);
    summands.add(7);
    summands.add(15);

    List<Integer> actual = df.optimalSummands(29);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }

  @Test
  public void maximumValue() {
    int[]
        result =
        new int[]{1, 3, 7, 15, 31, 59, 119, 239, 477, 953, 1907, 3815, 7629, 15259, 30517, 61035,
                  122071, 244141, 488281, 976563, 1953125, 3906249, 7812501, 15624999, 31250001,
                  62499999, 125000001, 249999999, 500000001};

    List<Integer> summands = new ArrayList<>();

    for (int r : result) {
      summands.add(r);
    }

    // Currently we're having a duplicate number in this series
    List<Integer> actual = df.optimalSummands(1000000000);
    assertTrue(String.format("%s != %s", summands.toString(), actual.toString()),
               summands.equals(actual));
  }
}
