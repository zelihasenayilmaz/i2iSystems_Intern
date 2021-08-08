import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FiboPrime {

    public static  boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    public static boolean isFibonacci(int n)
    {
        return isPerfectSquare(5 * n * n + 4) ||
                isPerfectSquare(5 * n * n - 4);
    }

    private static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }
        for (int i=2; i<number/2; i++) {
            if (number % 1 ==0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFiboAndPrime(int number) {
        return isPrime(number) && isFibonacci(number);

    }

}
