package flume;


import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.FlumeException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientConfigurationConstants;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlumeClient {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FlumeClient.class);
    
    private RpcClient rpcClient = null;
    
    private static long timeout = RpcClientConfigurationConstants.DEFAULT_REQUEST_TIMEOUT_MILLIS;
    
    private static Properties props = new Properties();
    
    public FlumeClient() {
        try {
            props.setProperty(RpcClientConfigurationConstants.CONFIG_HOSTS, "h1");
            props.setProperty(RpcClientConfigurationConstants.CONFIG_HOSTS_PREFIX + "h1",
                 "10.10.50.188:15555" );
            props.setProperty(RpcClientConfigurationConstants.CONFIG_CONNECT_TIMEOUT, String.valueOf(timeout));
            props.setProperty(RpcClientConfigurationConstants.CONFIG_REQUEST_TIMEOUT, String.valueOf(timeout));
            rpcClient = RpcClientFactory.getInstance(props);
        } catch (FlumeException e) {
            String errormsg = "锟斤拷锟接碉拷Flume锟斤拷锟斤拷锟斤拷锟斤拷锟�" + e.getMessage();
            LOGGER.error(errormsg);
            throw e;
        }
    }
    public static void main(String[] args) {
    	FlumeClient client = new FlumeClient();
         for(int i=0;i<100;i++){
    	client.sendDataToFlume(UUID.randomUUID().toString()+"_"+i);
     }
         client.close();
	}
    /**
     * 锟斤拷锟斤拷锟斤拷锟�
     * 
     * @param data 锟斤拷锟�
     */
    public synchronized void sendDataToFlume(String data) {
        if (rpcClient == null) {
            try {
                rpcClient = RpcClientFactory.getInstance(props);
            } catch (FlumeException e) {
                String errormsg = "锟斤拷锟接碉拷Flume锟斤拷锟斤拷锟斤拷锟斤拷锟�" + e.getMessage();
                LOGGER.error(errormsg);
                throw e;
            }
            if (rpcClient == null) {
                String errorMsg = "Flume锟斤拷锟斤拷锟届常锟斤拷锟睫凤拷锟斤拷锟斤拷荽锟斤拷涞紽lume锟斤拷锟斤拷锟斤拷!";
                LOGGER.error(errorMsg);
                throw new FlumeException(errorMsg);
            }
        }
        
        if (!rpcClient.isActive()) {
            close();
            try {
                rpcClient = RpcClientFactory.getInstance(props);
            } catch (FlumeException e) {
                LOGGER.error(e.getMessage());
                throw e;
            }
        }
        
        Map<String, String> hdrs = new HashMap<String, String>();
        Event event = EventBuilder.withBody(data, Charset.forName("UTF8"), hdrs);
        // Send the event
        try {
            rpcClient.append(event);
        } catch (EventDeliveryException e) {
            String msg = "EventDeliveryException.";
            LOGGER.error(msg);
            rpcClient.close();
            throw new FlumeException(msg + " Exception follows.", e);
        }
    }
    
    /**
     * Flume锟角凤拷锟斤拷锟斤拷
     * 
     * @return 锟角凤拷锟斤拷锟斤拷
     */
    public boolean isActive() {
        return rpcClient.isActive();
    }
    
    /**
     * 锟截憋拷Flume锟斤拷锟斤拷
     */
    public void close() {
        // Any append calls after this will result in an Exception.
        if (rpcClient != null) {
            try {
                rpcClient.close();
            } catch (FlumeException ex) {
                LOGGER.error("FlumeException", ex);
                throw ex;
            } finally {
                rpcClient = null;
            }
        } else {
            String errorMsg = "FlumeException";
            LOGGER.error(errorMsg);
            throw new FlumeException(errorMsg);
        }
    }
}
