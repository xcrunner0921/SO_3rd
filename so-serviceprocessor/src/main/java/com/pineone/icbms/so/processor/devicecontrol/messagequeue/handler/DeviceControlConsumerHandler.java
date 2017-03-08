package com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler;

import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DeviceControl Consumer handler.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
public class DeviceControlConsumerHandler extends AGenericConsumerHandler {
    /**
     * topic list
     */
    private static final List<String> TOPIC_LIST = Arrays.asList("devicecontrol");

    /**
     * kafka producer group id by class name.<BR/>
     */
    private static final String GROUP_ID = DeviceControlConsumerHandler.class.getSimpleName();

    /**
     * constructor.<BR/>
     */
    public DeviceControlConsumerHandler(int id) {
        super(id);
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

            //get DeviceDriver from database by devicemapper id
            //load devicemapper driver
            //run devicemapper execute method
        }
    }
}
