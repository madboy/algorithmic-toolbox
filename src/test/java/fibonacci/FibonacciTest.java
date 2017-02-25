package fibonacci;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
  private Fibonacci f;

  @Before
  public void initialize() {
    f = new Fibonacci();
  }

  @Test
  public void zero() {
    assertEquals(f.calc_fib(0), f.fasterFib(0));
  }

  @Test
  public void smallNumber() {
    assertEquals(f.calc_fib(3), f.fasterFib(3));
  }

  @Test
  public void mediumNumber() {
    assertEquals(f.calc_fib(10), f.fasterFib(10));
  }

  @Test
  public void largeNumber() {
    assertEquals(f.calc_fib(21), f.fasterFib(21));
  }

  @Test
  public void largestNumber() {
    assertEquals(1134903170, f.fasterFib(45));
  }
}
