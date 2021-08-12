import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class BigONotation {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(BigONotation.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");

        log.debug("The program is started.");

        int[] array = {4, 3, 8, 8, 35, 35, 12};
        log.info("Array is created.");
        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {                         // 1, n+1, n = 2n+2
            for (int j = i + 1; j < array.length; j++ ) {                // 1, n, n-1 = n(2n)
                if (array[i] == array[j]) {                              // n * n
                    log.info("Duplicates number is found.");             // T(n) = 3n^2 + 2n + 2
                    System.out.println(array[j]);                        // O(n) = n^2
                    System.out.println("\n");
                }
            }
        }
        log.debug("Program is finished.");
    }
}
