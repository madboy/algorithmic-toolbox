import java.util.*;
import java.io.*;
import java.util.Random;
import java.util.Arrays;

public class MaxPairwiseProduct {
  static long getMaxPairwiseProduct(int[] numbers) {
    long result = 0;
    int n = numbers.length;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if ((long) numbers[i] * (long) numbers[j] > result) {
          result = (long) numbers[i] * (long) numbers[j];
        }
      }
    }
    return result;
  }

  static long getMaxPairwiseProductFaster(int[] numbers) {
    int n = numbers.length;

    int firstMax = -1;
    for (int i = 0; i < n; i++) {
      if (firstMax == -1 || numbers[i] > numbers[firstMax]) {
        firstMax = i;
      }
    }

    int secondMax = -1;
    for (int j = 0; j < n; j++) {
      if ((j != firstMax) && (secondMax == -1 || (numbers[j] > numbers[secondMax]))) {
        secondMax = j;
      }
    }

    long result = (long) numbers[firstMax] * numbers[secondMax];
    return result;
  }

  public static void main(String[] args) {
    //        stressTest();

    realMain();
  }

  private static void stressTest() {
    while (true) {

      int n = randInt(2, 1000);
      System.out.println(n);
      int[] numbers = new int[n];
      for (int i = 0; i < n; i++) {
        numbers[i] = randInt(0, 99999);
      }
      long r1 = getMaxPairwiseProduct(numbers);
      long r2 = getMaxPairwiseProductFaster(numbers);
      if (r1 != r2) {
        System.out.println(Arrays.toString(numbers));
        System.out.printf("Wrong answer: %d %d\n", r1, r2);
        break;
      } else {
        System.out.println("OK");
      }
    }
  }

  private static int randInt(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  private static void realMain() {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextInt();
    }
    System.out.println(getMaxPairwiseProductFaster(numbers));
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
