package different_summands;

import java.util.*;

public class DifferentSummands {

  public static List<Integer> optimalSummands(int n) {
    // Boudaries 1 <= n 1000000000
    // Divide the number by 2
    List<Integer> summands = new ArrayList<>();
    int remains = n;
    while (remains != 0) {
      if (remains <= 2) { // for two and below we cannot make it any smaller
        summands.add(remains);
        break;
      }
//      int half = remains /2;
      int half = remains - remains/2;
//      if (half % 2 != 0){ // if it's odd we can add it directly
        summands.add(half);
//      } else { // else we should be more greedy
//        half += 1;
//        summands.add(half);
//      }
      remains -= half;
//      if ((remains % 2) != 0) {
//        int half = remains/2 + 1;
//        summands.add(half);
//        remains -= half;
//      } else {
//        int half = remains /2;
//        if ((remains - half) == half && (remains % 2) != 0) { //equal parts left which we cannot have
//          half += 1;
//        }
//        summands.add(half);
//        remains -= half;
//      }
    }

    Collections.sort(summands);

    //write your code here
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

