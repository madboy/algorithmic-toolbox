package covering_segments;

import java.util.*;

public class CoveringSegments {

  public static class Segment implements Comparable<Segment> {

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

  public static int[] optimalPoints(Segment[] segments) {
    // Boundaries:
    // 1 <= n <= 100; 0 <= ai <= bi <= 1000000000
    // sort the segments based on the start point
    // pick the leftmost one
    // add new segments as long as their start is within the end
    // of the currently picked segment
    // set the point to the furthest segment start
    // if you reach a segment that starts after end pick that as the new segment
    // is start < end always?
    Arrays.sort(segments);
    int[] points = new int[2 * segments.length];
    int point = 0;
    int currentEnd = 0;

    for (int i = 0; i < segments.length; i++) {
      // This could be brought outside of the loop
      // but for now it helps with the thinking
      if (i == 0) {
        currentEnd = segments[i].end;
        points[point] = segments[i].end;
        point++;
      } else {
        if (segments[i].start <= currentEnd) {
          // This segment can be skipped;
          // but we should update the end if it's to the left of the currentEnd
          // And since we're past the first point is should be safe to update
          // the position of the previous point.
          if (segments[i].end < currentEnd) {
            points[point-1] = segments[i].end;
            currentEnd = segments[i].end;
          }
        } else {
          points[point] = segments[i].end;
          currentEnd = segments[i].end;
          point++;
        }
      }
    }
    points = Arrays.copyOf(points, point);
    return points;
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
