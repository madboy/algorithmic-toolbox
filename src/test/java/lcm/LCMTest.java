package lcm;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LCMTest {
  private LCM l;

  @Before
  public void initialize() {
    l = new LCM();
  }

  @Test
  public void small() {
    assertEquals(l.lcm_naive(8, 6), l.lcm(8, 6));
  }

  @Test
  public void smallish() {
    assertEquals(l.lcm_naive(9, 0), l.lcm(9, 0));
  }

  @Test
  public void medium() {
    assertEquals(1933053046, l.lcm(28851538, 1183019));
  }

  @Test
  public void large() { assertEquals(226436590403296L, l.lcm(14159572, 63967072));}

}
