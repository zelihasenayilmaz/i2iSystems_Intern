import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciPrime {
    public static void main(String[] args) {

        Logger log = Logger.getLogger(FibonacciPrime.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");

        log.debug("The program is started.");

    //Prime Numbers
        int i;
        int count;
        System.out.println("Prime numbers between 0 and 15 are: ");

        List<Integer> listPrime = new ArrayList<>();
        for(int j = 2; j <= 15; j++) {
            count = 0;
            for(i = 1; i <= j; i++) {
                if(j % i == 0) {
                    count++;
                }
            } if(count == 2) {
                listPrime.add(j);
            }
        }

        log.info("Prime numbers list is reated.");
        System.out.println(listPrime);


        //Fibonacci Series
        int num1 = 0;
        int num2 = 1;
        count = 0;
        System.out.println("Fibonacci series between 0 and 15 are: ");

        List<Integer> listFib = new ArrayList<>();
        while (count < 15) {
            listFib.add(num1);
            int n = num1 + num2;
            num1 = num2;
            num2 = n;
            count++;

        }

        log.info("Fibonacci list is created.");
        System.out.println(listFib);

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter a Number: ");
        int number = input.nextInt();

        if(listFib.contains(number) && listPrime.contains(number)) {
            log.info("Number in Prime and Fibonacci lists is returned. Number is " + number);
            System.out.println("Number is in Prime Number and Fibonacci Series lists.");
        } else if (listFib.contains(number) && !(listPrime.contains(number))) {
            log.info("Number only in Fibonacci list is returned. Number is" + number);
            System.out.println("Number is only in Fibonacci Series list.");
        } else if (!(listFib.contains(number)) && listPrime.contains(number)) {
            log.info("Number only in Prime Number list is returned. Number is " + number);
            System.out.println("Number is only in Prime Numbers list.");
        } else {
            log.info("Number not found in lists is returned. Number is " + number);
            System.out.println("Number can not found in Fibonacci and Prime Numbers lists.");
        }
        log.debug("Program finished.");
    }
}
