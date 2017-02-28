package covering_segments;

import static org.junit.Assert.assertTrue;

//import java.util.Random;
import covering_segments.CoveringSegments.Segment;
import java.util.Arrays;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class CoveringSegmentsTest {

  private CoveringSegments cs;

  private static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  private void fillSegments(Segment[] segments, int min, int max) {
    for (int i = 0; i < segments.length; i++) {
      int start = randInt(min, max);
      int end = randInt(min, max);
      segments[i] = new Segment(start, end);
    }
  }

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
    int[] actual = cs.optimalPoints(segments);
    int[] expected = new int[]{3};
    assertTrue(String.format("%s != %s", Arrays.toString(expected), Arrays.toString(actual)),
               Arrays.equals(expected, actual));
  }

  @Test
  public void allInTheSamePlace() {
    Segment[] segments = new Segment[3];
    segments[0] = new Segment(2, 5);
    segments[1] = new Segment(2, 5);
    segments[2] = new Segment(2, 5);
    int[] actual = cs.optimalPoints(segments);
    int[] expected = new int[]{5};
    assertTrue(String.format("%s != %s", Arrays.toString(expected), Arrays.toString(actual)),
               Arrays.equals(expected, actual));
  }

  @Test
  public void multiSegment() {
    Segment[] segments = new Segment[4];
    segments[0] = new Segment(4, 7);
    segments[1] = new Segment(1, 3);
    segments[2] = new Segment(2, 5);
    segments[3] = new Segment(5, 6);
    int[] actual = cs.optimalPoints(segments);
    int[] expected = new int[]{3, 6};
    assertTrue(String.format("%s != %s", Arrays.toString(expected), Arrays.toString(actual)),
               Arrays.equals(expected, actual));
  }

  @Test
  public void nonOverlappingSegments() {
    Segment[] segments = new Segment[4];
    segments[0] = new Segment(1, 2);
    segments[1] = new Segment(3, 4);
    segments[2] = new Segment(5, 6);
    segments[3] = new Segment(7, 8);
    int[] actual = cs.optimalPoints(segments);
    int[] expected = new int[]{2, 4, 6, 8};
    assertTrue(String.format("%s != %s", Arrays.toString(expected), Arrays.toString(actual)),
               Arrays.equals(expected, actual));
  }

  @Test
  public void maximumValues(){
    Segment[] segments =  new Segment[100];
    fillSegments(segments, 0, 1000000000);
    cs.optimalPoints(segments);
  }
}
