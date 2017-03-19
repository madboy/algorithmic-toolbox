package test_utils;

import java.util.Random;

public class TestUtils {

  public static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  public static int[] randomList(int length, int min, int max) {
    int[] l = new int[length];
    for (int i = 0; i < l.length; i++){
      l[i] = TestUtils.randInt(min, max);
    }
    return l;
  }
}
