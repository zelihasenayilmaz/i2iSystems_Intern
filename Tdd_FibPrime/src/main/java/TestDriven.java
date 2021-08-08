import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;


public class TestDriven {

    Logger log = LogManager.getLogger(TestDriven.class);

    @Test
    void isFibPrime() {

        log.debug("Test is started.");

        int[] numbers = {2, 3, 5};
        //int[] numbers={1,2,3,5,8,10}; //Test fail.
        for (int i = 0; i < numbers.length; i++) {
            assertTrue(FiboPrime.isFiboAndPrime(numbers[i]));
            log.info("The program is successful.");
        }

    }

}
