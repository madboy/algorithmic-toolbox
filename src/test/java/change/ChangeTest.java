package change;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ChangeTest {
  private Change c;

  @Before
  public void init(){
    c = new Change();
  }

  @Test
  public void onlyOne() {
    assertEquals(1, c.getChange(1));
  }

  @Test
  public void nine() {
    assertEquals(5, c.getChange(9));
  }

  @Test
  public void twoCoinsOrBust() {
    assertEquals(2, c.getChange(2));
  }

  @Test
  public void twentyEight() {
    assertEquals(6, c.getChange(28));
  }

  @Test
  public void maxAmount() {
    assertEquals(100, c.getChange(1000));
  }


//
//  @Test
//  public void evenTens() {
//    assertEquals(10, c.numberOfTens(100));
//  }
//
//  @Test
//  public void unevenTens() {
//    assertEquals(9, c.numberOfTens(95));
//  }

}
