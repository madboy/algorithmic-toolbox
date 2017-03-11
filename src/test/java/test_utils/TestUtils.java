package test_utils;

import java.util.Random;

/**
 * Created by kato on 11/03/17.
 */
public class TestUtils {

  public static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }
}
