import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Queue;

public class Client {
    public static void main(String[] args) {

        ClientConfig config = new ClientConfig();
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Object,Object> map = client.getMap("mapTest");

        Queue<String> queue = client.getQueue("Queue");
        queue.add("Sent from client");


        long start = System.nanoTime();
        Object random = 0;
        for(int i= 0; i < 20000; i++)
        {
            random = map.get(i);
        }
        long end = System.nanoTime() - start;
        double seconds = (double)end / 1000000000.0;
        System.out.println(seconds);

        client.shutdown();

    }
}