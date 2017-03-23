package com.pineone.icbms.so.processor.virtualobject.messagequeue.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.model.VirtualObjectForMQ;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * VirtualObject Consumer handler.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
public class VirtualObjectConsumerHandler extends AGenericConsumerHandler {
    /**
     * topic list
     */
    private static final List<String> TOPIC_LIST = Arrays.asList("virtualobject");

    /**
     * kafka producer group id by class name.<BR/>
     */
    private static final String GROUP_ID = VirtualObjectConsumerHandler.class.getSimpleName();

    /**
     * constructor.<BR/>
     */
    public VirtualObjectConsumerHandler(int id) {
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
        ObjectMapper objectMapper = null;
        for (ConsumerRecord<String, String> record : records) {
            log.debug("ConsumerRecord: {}: {}");

            if (objectMapper == null) {
                objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }

            // -create message From ContextModelForMQ for messageQueue
            // -publish to message queue
            //1. get a devicemapper by virtual functionality with location from repository(database, sda)
            String receivedModelString = record.value();
            try {
                VirtualObjectForMQ virtualObjectForMQ = objectMapper.readValue(receivedModelString, VirtualObjectForMQ.class);
                new VirtualObjectHandler().handle(virtualObjectForMQ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
