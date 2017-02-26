package fibonacci_huge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciHugeTest {
  private class PisanoPeriod {
    private int n;
    private int pn;

    public PisanoPeriod(int n, int pn) {
      this.n = n;
      this.pn = pn;
    }
  }

  private FibonacciHuge f;
  private PisanoPeriod[] periods;

  @Before
  public void initialize() {
    f = new FibonacciHuge();
  }

  @Test
  public void xsmall() {
    assertEquals(1, f.getFibonacciHuge(1, 239));
  }

  @Test
  public void small() {
    assertEquals(1, f.getFibonacciHuge(2015, 3));
  }

  @Test
  public void medium() {
    assertEquals(161, f.getFibonacciHuge(239, 1000));
  }

  @Test
  public void xmedium() {
    assertEquals(15075, f.getFibonacciHuge(100, 100000));
  }

  @Test
  public void large() {
    assertEquals(10249, f.getFibonacciHuge(2816213588L, 30524));
  }

  @Test
  public void huge() {
    assertEquals(1917, f.getFibonacciHuge(1000000000000000000L, 9973));
  }

  @Test
  public void xhuge() {
    assertEquals(1, f.getFibonacciHuge(99999999999999999L, 5));
  }

  @Test
  public void pisanos() {
    periods = new PisanoPeriod[17];

    periods[0] = new PisanoPeriod(1, 1);
    periods[1] = new PisanoPeriod(2, 3);
    periods[2] = new PisanoPeriod(3, 8);
    periods[3] = new PisanoPeriod(4, 6);
    periods[4] = new PisanoPeriod(5, 20);
    periods[5] = new PisanoPeriod(6, 24);
    periods[6] = new PisanoPeriod(7, 16);
    periods[7] = new PisanoPeriod(8, 12);
    periods[8] = new PisanoPeriod(9, 24);
    periods[9] = new PisanoPeriod(10, 60);
    periods[10] = new PisanoPeriod(11, 10);
    periods[11] = new PisanoPeriod(12, 24);
    periods[12] = new PisanoPeriod(130, 420);
    periods[13] = new PisanoPeriod(50, 300);
    periods[14] = new PisanoPeriod(1000, 1500);
    periods[15] = new PisanoPeriod(10000, 15000);
    periods[16] = new PisanoPeriod(100000, 150000);

    for (PisanoPeriod pp : periods) {
      assertEquals(pp.pn, f.pisanoPeriod(pp.n));
    }
  }

  @Test
  public void largePisanoNumbers10() {
    assertEquals(true, f.largePisano(10));
  }

  @Test
  public void largePisanoNumbers50() {
    assertEquals(true, f.largePisano(50));
  }

  @Test
      public void largePisanoNumbers10K(){
    assertEquals(true, f.tenMultiple(100000));
  }
}
