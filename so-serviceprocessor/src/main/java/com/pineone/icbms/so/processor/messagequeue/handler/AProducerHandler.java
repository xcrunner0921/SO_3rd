package com.pineone.icbms.so.processor.messagequeue.handler;

import com.pineone.icbms.so.util.property.PropertyUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;

/**
 * abstract class for Kafka Producer.<BR/>
 * <p>
 * Created by uni4love on 2016. 1. 6..
 */
abstract public class AProducerHandler<T, K, V> implements IProducerHandler<T, K, V> /*, Runnable*/ {
    /**
     * logger
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * id
     */
    private final int id;

    /**
     * Kafka producer<BR/>
     */
    protected KafkaProducer<K, V> producer;

    /**
     * constructor.<BR/>
     */
    public AProducerHandler(int id) {
        this.id = id;

        Properties properties = initProperties(getPropertiesMap());
        producer = new KafkaProducer<K, V>(properties);
    }

    /**
     * initialize properties<BR/>
     *
     * @return Properties
     */
    Properties initProperties(Map propertiesMap) {
        Properties properties = PropertyUtils.getProperties(propertiesMap);
        return properties;
    }

    /**
     * return Property map.<BR/>
     *
     * @return Map
     */
    abstract public Map getPropertiesMap();

    /**
     * return topic.<BR/>
     *
     * @return topic
     */
    abstract public String getTopic();
}
