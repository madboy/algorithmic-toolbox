package fibonacci_last_digit;

import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    public static int getFibonacciLastDigitFast(int n) {
        if (n <= 1) {
            return n;
        }
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = (table[i - 1] + table[i - 2]) % 10;
        }
        return table[n];
    }

    public static BigInteger getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);

        BigInteger previous = BigInteger.valueOf(0);
        BigInteger current  = BigInteger.valueOf(1);

        for (int i = 0; i < n - 1; ++i) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
        }

        return current.mod(BigInteger.valueOf(10));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

