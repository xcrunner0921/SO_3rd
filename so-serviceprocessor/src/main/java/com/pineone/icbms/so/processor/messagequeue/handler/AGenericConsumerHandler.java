package com.pineone.icbms.so.processor.messagequeue.handler;

import com.pineone.icbms.so.processor.Settings;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Consumer handler generic abstract class.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
abstract public class AGenericConsumerHandler extends AConsumerHandler<String, String> implements Runnable {
    /**
     * constructor.<BR/>
     */
    public AGenericConsumerHandler(int id) {
        super(id);
    }

    /**
     * handler options.<BR/>
     *
     * @return Properties
     */
    @Override
    public Map getPropertiesMap() {
        Map<String, String> keyValueMap = new HashMap<String, String>();
        keyValueMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Settings.BROKER_LIST);
        keyValueMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        keyValueMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return keyValueMap;
    }

    /**
     * Runnable interface implement.<BR/>
     */
    @Override
    public void run() {
        log.debug("The handler:{} thread started.", id);
        try {
            subscribe(getTopicList());
            while (running) {
                ConsumerRecords<String, String> records = getMessage();
                handle(records);
            }
        } catch (WakeupException e) {
            e.printStackTrace();
        } finally {
            close();
            log.info("The handler:{} closed.", id);
        }
    }
}
