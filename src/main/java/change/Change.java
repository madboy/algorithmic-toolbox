package change;

import java.util.Scanner;

public class Change {
  public static int numberOfCoins(int amount, int value) {
    int i = 0;
    while (amount >= value) {
        amount -= value;
        i++;
    }
    return i;
  }

  public static int getChange(int m) {
    // Change m into coins
    // Denominations 1 5 10
    // 1 <= m <= 1000
    // Return the minimum number of coins needed to give change
    // First use largest coin possible
    // Then next largest etc
    int tens = numberOfCoins(m, 10);
    m = m - tens*10;
    int fives = numberOfCoins(m, 5);
    m = m - fives*5;
    int ones = numberOfCoins(m, 1);
    return tens+fives+ones;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));
  }
}
