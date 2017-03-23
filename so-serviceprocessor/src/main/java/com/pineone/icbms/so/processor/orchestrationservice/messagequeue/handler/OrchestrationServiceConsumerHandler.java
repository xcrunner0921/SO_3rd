package com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model.OrchestrationServiceForMQ;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * OrchestrationService Consumer handler.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
public class OrchestrationServiceConsumerHandler extends AGenericConsumerHandler {
    /**
     * topic list
     */
    private static final List<String> TOPIC_LIST = Arrays.asList("orchestrationservice");

    /**
     * kafka producer group id by class name.<BR/>
     */
    private static final String GROUP_ID = OrchestrationServiceConsumerHandler.class.getSimpleName();

    /**
     * constructor.<BR/>
     */
    public OrchestrationServiceConsumerHandler(int id) {
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

            // -create a message From OrchestrationServiceForMQ for messageQueue
            // -publish to message queue
            //get a virtual object from orchestrationservice
            String receivedModelString = record.value();
            try {
                OrchestrationServiceForMQ orchestrationServiceForMQ = objectMapper.readValue(receivedModelString, OrchestrationServiceForMQ.class);
                new OrchestrationServiceHandler().handle(orchestrationServiceForMQ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

