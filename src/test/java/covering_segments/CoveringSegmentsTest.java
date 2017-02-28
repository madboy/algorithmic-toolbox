package covering_segments;

import static org.junit.Assert.assertTrue;

//import java.util.Random;
import covering_segments.CoveringSegments.Segment;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class CoveringSegmentsTest {
  private CoveringSegments cs;
  @Before
  public void init() {
    cs = new CoveringSegments();
  }

  @Test
  public void simple() {
    Segment[] segments = new Segment[3];
    segments[0] = new Segment(2, 5);
    segments[1] = new Segment(1, 3);
    segments[2] = new Segment(3, 6);
    System.out.println(Arrays.toString(cs.optimalPoints(segments)));
  }
}
