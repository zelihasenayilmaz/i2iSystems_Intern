
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class OInsert {

    public static void main(String[] args) {
        String dbURL = "jdbc:oracle:thin:@localhost:49161:xe";
        String user = "system";
        String password = "oracle";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(dbURL, user, password);
            Statement stmt = connection.createStatement();
            System.out.println("Connected to Oracle database server.");

            Random random = new Random();
            long start = System.nanoTime();
            for(int i = 0; i < 20000; i++){
                stmt.executeUpdate("INSERT INTO RANDOMNUMBER VALUES("+i+","+random.nextInt(20000)+")");
            }
            long elapsedTime = System.nanoTime() - start;
            double seconds = (double)elapsedTime / 1_000_000_000.0;
            System.out.println(seconds);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}