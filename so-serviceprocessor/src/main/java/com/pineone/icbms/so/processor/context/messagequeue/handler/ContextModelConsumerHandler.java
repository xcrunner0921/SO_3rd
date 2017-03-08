package com.pineone.icbms.so.processor.context.messagequeue.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pineone.icbms.so.interfaces.database.model.OrchestrationServiceForDB;
import com.pineone.icbms.so.interfaces.database.model.ProfileForDB;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextModelForMQ;
import com.pineone.icbms.so.processor.interfaces.database.DatabaseManager;
import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler.OrchestrationServiceProducerHandler;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model.OrchestrationServiceForMQ;
import com.pineone.icbms.so.util.id.IdUtils;
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
            System.out.println("ConsumerRecord:" + this.id + ": " + record);

            // -create message From ContextModelForMQ for messageQueue
            // -publish to message queue
            //1. get a profile by context model id
            String receivedModelString = record.value();
            try {
                ContextModelForMQ contextModelForMQ = objectMapper.readValue(receivedModelString, ContextModelForMQ.class);
                String contextModelId = contextModelForMQ.getId();
                ProfileForDB profileModel = DatabaseManager.getInstance().getProfileByContextModelId(contextModelId);
                //2. get a OrchestrationService by orchestrationservice id in profile
                OrchestrationServiceForDB orchestrationServiceModel = DatabaseManager.getInstance().getOrchestrationServiceById(profileModel.getOrchestrationService().getId());
                //3. publish orchestrationService by producer
                //test instance
                OrchestrationServiceForMQ modelForMQ = new OrchestrationServiceForMQ(IdUtils.createRandomUUID(), "test-orchestrationservice-for-mq");
                //object to json
                String sendModelString = null;
                try {
                    sendModelString = objectMapper.writeValueAsString(modelForMQ);
                    log.debug("event:orchestrationservice {}", sendModelString);
                    OrchestrationServiceProducerHandler producerHandler = new OrchestrationServiceProducerHandler(0);
                    producerHandler.send(sendModelString);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

