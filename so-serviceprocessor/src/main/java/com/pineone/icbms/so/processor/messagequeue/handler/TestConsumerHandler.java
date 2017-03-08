package com.pineone.icbms.so.processor.messagequeue.handler;

import com.pineone.icbms.so.processor.Settings;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Message Consumer Handler test class.<BR/>
 * Created by uni4love on 2016. 12. 14..
 */
public class TestConsumerHandler extends AGenericConsumerHandler {
    /**
     * group id
     */
    private static final String GROUP_ID = TestConsumerHandler.class.getSimpleName();

    /**
     * topic list
     */
    private static final List<String> TOPIC_LIST = Arrays.asList("producer-tutorial");

    /**
     * constructor
     *
     * @param id id
     */
    public TestConsumerHandler(int id) {
        super(id);
    }

    /**
     * producer options.<BR/>
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
     * return group id.<BR/>
     *
     * @return group id
     */
    @Override
    public String getGroupId() {
        return GROUP_ID;
    }

    /**
     * return topic list.<BR/>
     *
     * @return topic list
     */
    @Override
    public List<String> getTopicList() {
        return TOPIC_LIST;
    }

    /**
     * handle method.<BR/>
     *
     * @param records ConsumerRecords
     */
    @Override
    public void handle(ConsumerRecords<String, String> records) {
        for (ConsumerRecord<String, String> record : records) {
            Map<String, Object> data = new HashMap<>();
            data.put("partition", record.partition());
            data.put("offset", record.offset());
            data.put("key", record.key());
            data.put("value", record.value());
            System.out.println(this.id + ": " + data);
        }
    }

//    /**
//     * test main
//     * @param args
//     */
//    public static void main(String[] args) {
//        int testConsumerHandlerCount = 3;
//        ExecutorService executorService = Executors.newFixedThreadPool(testConsumerHandlerCount);
//        List<TestConsumerHandler> consumerList = new ArrayList<>();
//        for (int i = 0; i < testConsumerHandlerCount; i++) {
//            TestConsumerHandler consumer = new TestConsumerHandler(i);
//            consumerList.add(consumer);
//            executorService.submit(consumer);
//        }
//
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                for (TestConsumerHandler consumer : consumerList) {
//                    consumer.shutdown();
//                }
//                executorService.shutdown();
//                try {
//                    executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
}
