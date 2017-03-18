package primitive_calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PrimitiveCalculatorTest {
  private PrimitiveCalculator pc;

  @Before
  public void init() {
    pc = new PrimitiveCalculator();
  }

  @Test
  public void calculateDp() {
    int[] r = pc.getDp(12);
    int[] e = new int[] {0, 0, 1, 1, 2, 3, 2, 3, 3, 2, 3, 4, 3};
    assertTrue(String.format("%s != %s", Arrays.toString(e), Arrays.toString(r)),
        Arrays.equals(e, r));
  }

  @Test
  public void highNumber() {
    int[] r = pc.getDp(96234);
    assertEquals(14, r[r.length-1]);
  }

    @Test
    public void simpleSequence() {
      List<Integer> r = pc.optimal_sequence(1);
      List<Integer> e = Arrays.asList(0, 1);
      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
    }

    @Test
    public void oneStep() {
      List<Integer> r = pc.optimal_sequence(2);
      List<Integer> e = Arrays.asList(1, 1, 2);
      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
    }

    @Test
    public void oneStepThree() {
      List<Integer> r = pc.optimal_sequence(3);
      List<Integer> e = Arrays.asList(1, 1, 3);
      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
    }

    @Test
    public void twoStep() {
      List<Integer> r = pc.optimal_sequence(4);
      List<Integer> e = Arrays.asList(2, 1, 2, 4);
      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
    }

    @Test
    public void multipleSteps() {
      List<Integer> r = pc.optimal_sequence(5);
      List<Integer> e = Arrays.asList(3, 1, 2, 4, 5);
      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
    }

//    @Test
//    public void multipleStepsAlt() {
//      // Either this or the other multipleSteps are valid solutions to the sequence
//      List<Integer> r = pc.optimal_sequence(5);
//      List<Integer> e = Arrays.asList(3, 1, 3, 4, 5);
//      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
//    }

    @Test
    public void longerSequence() {
      List<Integer> r = pc.optimal_sequence(96234);
      List<Integer> e = Arrays.asList(14, 1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234);
      assertTrue(String.format("%s != %s", e.toString(), r.toString()), e.equals(r));
    }
}
