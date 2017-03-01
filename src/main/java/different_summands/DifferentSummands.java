package different_summands;

import java.util.*;

public class DifferentSummands {

  public static List<Integer> optimalSummands(int n) {
    // Boudaries 1 <= n 1000000000
    List<Integer> summands = new ArrayList<>();
    // Eat the number in 1 bit bigger each time sizes
    int remains = n;
    int l = 1;
    while (remains != 0) {
      if (2 * l < remains) {
        summands.add(l);
        remains -= l;
        l++;
        // we cannot divide the last part in new sizes so just gobble up all
      } else {
        summands.add(remains);
        break;
      }
    }

    Collections.sort(summands);

    return summands;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> summands = optimalSummands(n);
    System.out.println(summands.size());
    for (Integer summand : summands) {
      System.out.print(summand + " ");
    }
  }
}
