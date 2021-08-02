import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Member {
    public static void main(String[] args) {

        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        System.out.println("Instance Started");
        IMap<Object,Object> map = instance.getMap("mapTest");
        BlockingQueue<String> queue = instance.getQueue("Queue");

        try {
            System.out.println(queue.take());
            Random random = new Random();
            long start = System.nanoTime();
            for (int i = 0; i < 20000; i++) {
                map.put(i, random.nextInt(20000));

            }
            long end = System.nanoTime() - start;
            double seconds = (double)end / 1000000000.0;
            System.out.println(seconds);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
