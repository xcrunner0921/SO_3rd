package com.pineone.icbms.so.processor.context.messagequeue.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextModelForMQ;
import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model.OrchestrationServiceForMQ;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * ContextModelForMQ Consumer handler.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
public class ContextModelConsumerHandler extends AGenericConsumerHandler {
    /**
     * topic list
     */
    private static final List<String> TOPIC_LIST = Arrays.asList("contextmodel");

    /**
     * kafka handler group id by class name.<BR/>
     */
    private static final String GROUP_ID = ContextModelConsumerHandler.class.getSimpleName();

    /**
     * constructor.<BR/>
     */
    public ContextModelConsumerHandler(int id) {
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

            // -create message From ContextModelForMQ for messageQueue
            // -publish to message queue
            if (objectMapper == null) {
                objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).setSerializationInclusion(JsonInclude.Include.NON_NULL);
            }

            String receivedModelString = record.value();
            try {
                ContextModelForMQ contextModelForMQ = objectMapper.readValue(receivedModelString, ContextModelForMQ.class);
//                //create a scenario
//                DefaultScene scene = new DefaultScene();
//                DefaultScenario scenario = new DefaultScenario();
//                scenario.addScene(scene);
                //get orchestrationService from contextmodel
                OrchestrationServiceForMQ modelForMQ = new ContextModelHandler().handle(contextModelForMQ);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

