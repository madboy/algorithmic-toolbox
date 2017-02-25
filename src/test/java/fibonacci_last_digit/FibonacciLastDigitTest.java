package fibonacci_last_digit;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import org.junit.Before;
import org.junit.Test;

public class FibonacciLastDigitTest {
  private FibonacciLastDigit f;

  @Before
  public void initialize(){
    f = new FibonacciLastDigit();
  }

  @Test
  public void zero(){
    assertEquals(f.getFibonacciLastDigitNaive(0), BigInteger.valueOf(f.getFibonacciLastDigitFast(0)));
  }

  @Test
  public void small(){
    assertEquals(f.getFibonacciLastDigitNaive(3), BigInteger.valueOf(f.getFibonacciLastDigitFast(3)));
  }

  @Test
  public void medium(){
    assertEquals(f.getFibonacciLastDigitNaive(331), BigInteger.valueOf(f.getFibonacciLastDigitFast(331)));
  }

  @Test
  public void large(){
    assertEquals(5, f.getFibonacciLastDigitFast(50000));
  }

  @Test
  public void xlarge(){
    assertEquals(5, f.getFibonacciLastDigitFast(327305));
  }

  @Test
  public void max(){
    assertEquals(5, f.getFibonacciLastDigitFast(10000000));
  }
}
