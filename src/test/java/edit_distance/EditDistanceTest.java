package edit_distance;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EditDistanceTest {
  private EditDistance ed;

  @Before
  public void setUp() {
    ed = new EditDistance();
  }

  @Test
  public void simple() {
    int r = ed.editDistance("ab", "ab");
    assertEquals(0, r);
  }

  @Test
  public void someDifference() {
    int r = ed.editDistance("short", "ports");
    assertEquals(3, r);
  }

  @Test
  public void workedExamaple() {
    int r = ed.editDistance("editing", "distance");
    assertEquals(5, r);
  }
}
