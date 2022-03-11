//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class Consumer {
//    private static final int THREAD_COUNT = 10; //TODO:make quene length closer to 0
//    private final static String QUEUE_NAME = "myQueue";
//
//    // skier servlet and consumer deployed to ec2
//
//    public static void main(String[] argv) throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("35.163.110.224");
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        Connection connection = factory.newConnection();
//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//
//        for (int i = 0; i < THREAD_COUNT; i++) {
//            new Thread(new ConsumerThread(connection, map)).start();
//        }
//    }
//}
