//import com.rabbitmq.client.Channel;
//import java.util.NoSuchElementException;
//import org.apache.commons.pool2.impl.GenericObjectPool;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//
//public class ChannelPool{
//    private GenericObjectPool<Channel> internalPool;
//    public static GenericObjectPoolConfig defaultConfig;
//    private static final int INITIAL_POOL_SIZE = 10;
//
//    static {
//        defaultConfig = new GenericObjectPoolConfig();
//        defaultConfig.setMaxTotal(INITIAL_POOL_SIZE);
//        defaultConfig.setBlockWhenExhausted(false);
//    }
//
//    public ChannelPool() throws Exception {
//        this(defaultConfig, new ChannelFactory());
//    }
//
//    public ChannelPool(final GenericObjectPoolConfig poolConfig, ChannelFactory factory) {
//
//        this.internalPool = new GenericObjectPool<Channel>(factory, poolConfig);
//    }
//
//    private void closeInternalPool() throws Exception {
//        try {
//            internalPool.close();
//        } catch (Exception e) {
//            throw new Exception("Could not destroy the pool", e);
//        }
//    }
//
//    public void returnChannel(Channel channel) throws Exception {
//        try {
//            if (channel.isOpen()) {
//                internalPool.returnObject(channel);
//            } else {
//                internalPool.invalidateObject(channel);
//            }
//        } catch (Exception e) {
//            throw new Exception("Could not return the resource to the pool", e);
//        }
//    }
//
//    public Channel getChannel() throws Exception {
//        try {
//            return internalPool.borrowObject();
//        } catch (NoSuchElementException nse) {
//            if (null == nse.getCause()) { // The exception was caused by an exhausted pool
//                throw new Exception("Could not get a resource since the pool is exhausted", nse);
//            }
//            // Otherwise, the exception was caused by the implemented activateObject() or ValidateObject()
//            throw new Exception("Could not get a resource from the pool", nse);
//        } catch (Exception e) {
//            throw new Exception("Could not get a resource from the pool", e);
//        }
//    }
//}