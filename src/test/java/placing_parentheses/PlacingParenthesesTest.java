package placing_parentheses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlacingParenthesesTest {
  private PlacingParentheses pp;

  @Before
  public void init() {
    pp = new PlacingParentheses();
  }

  @Test
  public void simpleAddition() {
    long r = pp.getMaximValue("1+5");
    assertEquals(6, r);
  }

  @Test
  public void moreComplex() {
    long r = pp.getMaximValue("5-8+7*4-8+9");
    assertEquals(200, r);
  }
}
