import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Scanner;

public class FiboDynamic {

    //Top-down
    public static int fiboMemoization(int n, int[] cache) {
        if (cache[n] == 0) {
            if (n < 2) {
                cache[n] = n;
            } else {
                cache[n] = fiboMemoization(n - 1, cache) + fiboMemoization(n - 2, cache);
            }
        }
        return cache[n];
    }

    public static int fiboRecursion(int n) {
        if (n<2) {
            return n;
        }
        return fiboRecursion(n-1) + fiboRecursion(n-2);
    }

    //Bottom-up
    public static int fiboTabular(int n) {
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static int fibonacci(int n) {
        int[] F = new int[n+1];
        F[0] = 0;
        F[1] = 1;
        for(int i = 2; i <= n; ++i) {
            F[i] = F[i-2] + F[i-1];
        }
        return F[n];
    }

    public static void main(String[] args) throws InterruptedException {

        Logger log = Logger.getLogger(FiboDynamic.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");

        log.debug("The program is started.");
        System.out.println("\n");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();

        long startTime, endTime, elapsedTime;

        startTime = System.nanoTime();
        log.info("Top-down Approach");
        System.out.println("Fibonacci Memoization Result: " + fiboMemoization(number, new int[number+1]));
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        log.info("Elapsed time for memoization is calculated.");
        System.out.println("Elapsed Time for Fibonacci Memoization: " +elapsedTime);

        System.out.println("\n");
        Thread.sleep(1000);

        startTime = System.nanoTime();
        log.info("Recursive");
        System.out.println("Fibonacci Recursion Result: " + fiboRecursion(number));
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        log.info("Elapsed time for recursion is calculated.");
        System.out.println("Elapsed Time for Fibonacci Recursion: " + elapsedTime);

        System.out.println("\n");
        Thread.sleep(1000);

        startTime = System.nanoTime();
        log.info("Bottom-up Approach");
        System.out.println("Fibonacci Tabular Result: " + fiboTabular(number));
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        log.info("Elapsed time for tabulation is calculated.");
        System.out.println("Elapsed Time for Fibonacci Tabular: " + elapsedTime);

        System.out.println("\n");
        Thread.sleep(1000);

        startTime = System.nanoTime();
        log.info("Fibonacci");
        System.out.println("Fibonacci Result: " + fibonacci(number));
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        log.info("Elapsed time for fibonacci is calculated.");
        System.out.println("Elapsed Time for Fibonacci: " + elapsedTime);

        System.out.println("\n");
        log.debug("Program finished.");

    }
}
