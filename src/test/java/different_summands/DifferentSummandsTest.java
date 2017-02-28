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
    List<Integer> summands = new ArrayList<Integer>();
    assertTrue(summands.equals(df.optimalSummands(1)));
  }
}
