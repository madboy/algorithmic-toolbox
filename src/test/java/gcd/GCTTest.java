package gcd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GCTTest {
  private GCD g;

  @Before
  public void initialize() {
    g = new GCD();
  }

  @Test
  public void zero() {
    assertEquals(9, g.gcd(9, 0));
  }

  @Test
  public void lowest() {
    assertEquals(g.gcd_naive(1, 1), g.gcd_naive(1, 1));
  }

  @Test
  public void small() {
    assertEquals(g.gcd_naive(18, 35), g.gcd(18, 35));
  }

  @Test
  public void medium() {
    assertEquals(g.gcd_naive(28851538, 1183019), g.gcd(28851538, 1183019));
  }

  @Test
  public void large() {
    assertEquals(g.gcd_naive(288515381, 11830119), g.gcd(288515381, 11830119));
  }

  @Test
  public void xlarge() {
    assertEquals(61232, g.gcd(3918848, 1653264));
  }

  @Test
  public void onedividestheother() {
    assertEquals(g.gcd_naive(90, 30), g.gcd(90, 30));
  }

  @Test
  public void maximum() {
    assertEquals(1, g.gcd(2000000000, 1999999999));
  }
}
