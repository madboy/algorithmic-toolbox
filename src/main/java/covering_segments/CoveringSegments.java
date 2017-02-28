package covering_segments;

import java.util.*;

public class CoveringSegments {

  public static int[] optimalPoints(Segment[] segments) {
    // sort the segments based on the start point
    // pick the leftmost one
    // add new segments as long as their start is within the end
    // of the currently picked segment
    // set the point to the furthest segment start
    // if you reach a segment that starts after end pick that as the new segment

    System.out.println(Arrays.toString(segments));
    Arrays.sort(segments);
    System.out.println(Arrays.toString(segments));

    int[] points = new int[2 * segments.length];
    for (int i = 0; i < segments.length; i++) {
      points[2 * i] = segments[i].start;
      points[2 * i + 1] = segments[i].end;
    }
    return points;
  }

  public static class Segment implements Comparable<Segment>{
    int start, end;

    Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public String toString() {
      return String.format("[%d, %d]", start, end);
    }

    public int compareTo(Segment r) {
      if (this.start < r.start) {
        return -1;
      } else if (this.start == r.start) {
        return 0;
      }
      return 1;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Segment[] segments = new Segment[n];
    for (int i = 0; i < n; i++) {
      int start, end;
      start = scanner.nextInt();
      end = scanner.nextInt();
      segments[i] = new Segment(start, end);
    }
    int[] points = optimalPoints(segments);
    System.out.println(points.length);
    for (int point : points) {
      System.out.print(point + " ");
    }
  }
}
