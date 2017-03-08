package com.pineone.icbms.so.processor.messagequeue.handler;

import com.pineone.icbms.so.processor.Settings;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Producer handler generic abstract class.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
abstract public class AGenericProducerHandler extends AProducerHandler<Future<RecordMetadata>, String, String> {
    /**
     * constructor.<BR/>
     */
    public AGenericProducerHandler(int id) {
        super(id);
    }

    /**
     * producer options.<BR/>
     *
     * @return Properties
     */
    @Override
    public Map getPropertiesMap() {
        Map<String, Object> keyValueMap = new HashMap<String, Object>();
        keyValueMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Settings.BROKER_LIST);
        keyValueMap.put(ProducerConfig.ACKS_CONFIG, "all");
        keyValueMap.put(ProducerConfig.RETRIES_CONFIG, 0);
        keyValueMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        keyValueMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return keyValueMap;
    }

    /**
     * send a record to producer.<BR/>
     *
     * @param key key
     * @param value value
     */
    @Override
    public Future<RecordMetadata> send(String key, String value) {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(getTopic(), key, value);
        return producer.send(producerRecord);
    }

    /**
     * send a record to producer.<BR/>
     *
     * @param value value
     */
    public Future<RecordMetadata> send(String value) {
        return this.send(getTopic(), value);
    }

    /**
     * close the producer.
     */
    @Override
    public void close() {
        producer.close();
    }
}
