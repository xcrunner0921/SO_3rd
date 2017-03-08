package com.pineone.icbms.so.processor.messagequeue.handler;

import com.pineone.icbms.so.util.property.PropertyUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * abstract class for Kafka Consumer.<BR/>
 * <p>
 * Created by uni4love on 2016. 1. 6..
 */
abstract public class AConsumerHandler<K, V> implements IConsumerHandler<ConsumerRecords<K, V>>{
    /**
     * logger
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * handler poll timeout.<BR/>
     * Long.MAX_VALUE was blocked.
     */
    protected static long POLL_TIMEOUT = 1000l;

    /**
     * handler running flag
     */
    protected boolean running = true;

    /**
     * id
     */
    protected final int id;

    /**
     * Kafka handler<BR/>
     */
    protected KafkaConsumer<K, V> consumer;


    /**
     * constructor.<BR/>
     */
    public AConsumerHandler(int id) {
        this.id = id;

        Properties properties = initProperties(getPropertiesMap());
        consumer = new KafkaConsumer<K, V>(properties);
    }

    /**
     * initialize properties<BR/>
     *
     * @return Properties
     */
    Properties initProperties(Map propertiesMap) {
        Properties properties = PropertyUtils.getProperties(propertiesMap);

        if (!properties.containsKey(ConsumerConfig.GROUP_ID_CONFIG))
            properties.put(ConsumerConfig.GROUP_ID_CONFIG, getGroupId());
        if (!properties.containsKey(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG))
            properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        if (!properties.containsKey(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG))
            //default value
            properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        if (!properties.containsKey(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG))
            properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        properties.put("acks", "all");
//        properties.put("block.on.buffer.full", "true");
//        properties.put("zookeeper.connect", Settings.ZOOKEEPER_LIST);
//        properties.put("zookeeper.session.timeout.ms", "500");
//        properties.put("zookeeper.sync.time.ms", "250");
//        properties.put("auto.commit.enable", "true");
//        properties.put("auto.commit.interval.ms", "60000");
//        properties.put("fetch.message.max.bytes", "31457280");        // 30MB
//        properties.put("auto.offset.reset", "smallest");
        //properties.put("auto.offset.reset", "largest");
        return properties;
    }


    @Override
    public void subscribe(Collection<String> topics) {
        consumer.subscribe(topics);
    }

    @Override
    public ConsumerRecords<K, V> getMessage() {
        return consumer.poll(POLL_TIMEOUT);
    }

    @Override
    public void close() {
        consumer.close();
    }

    /**
     * when shutdown, to do..<BR/>
     */
    public void shutdown() {
        consumer.wakeup();
        log.info("The handler:{} shutdown.", id);
    }

    /**
     * set running flag.<BR/>
     *
     * @param running running flag
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * return running flag.<BR/>
     *
     * @return running flag
     */
    public boolean getRunning() {
        return running;
    }

    /**
     * return Property map.<BR/>
     *
     * @return Map
     */
    abstract public Map getPropertiesMap();

    /**
     * return group id.<BR/>
     * @return group id
     */
    abstract public String getGroupId();

    /**
     * return topic list.<BR/>
     * @return topic list
     */
    abstract public List<String> getTopicList();

    /**
     * handle method.<BR/>
     *
     * @param records ConsumerRecords
     */
    public abstract void handle(ConsumerRecords<K, V> records);
}
