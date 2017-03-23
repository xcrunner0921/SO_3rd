package com.pineone.icbms.so.processor.context.messagequeue.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.interfaces.database.model.ProfileForDB;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextModelForMQ;
import com.pineone.icbms.so.processor.interfaces.database.DatabaseManager;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler.OrchestrationServiceProducerHandler;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model.OrchestrationServiceForMQ;
import com.pineone.icbms.so.util.id.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ContextModel handler.<BR/>
 *
 * Created by uni4love on 2017. 1. 20..
 */
public class ContextModelHandler {
    /**
     * logger
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * create a OrchestrationService by ContextModel.<BR/>
     *
     * @param contextModelForMQ
     * @return OrchestrationServiceForMQ
     */
    public OrchestrationServiceForMQ handle(ContextModelForMQ contextModelForMQ) {
        //get a profile by context model id
        String contextModelId = contextModelForMQ.getId();
        ProfileForDB profileModel = DatabaseManager.getInstance().getProfileByContextModelId(contextModelId);
        //get a OrchestrationService by orchestrationservice id in profile
//        OrchestrationServiceForDB orchestrationServiceModel = DatabaseManager.getInstance().getOrchestrationServiceById(profileModel.getOrchestrationService().getId());
        //test instance
        OrchestrationServiceForMQ modelForMQ = new OrchestrationServiceForMQ(IdUtils.createRandomUUID(), "test-orchestrationservice-for-mq");
//        modelForMQ.setState(new DefaultState());

        //object to json
        String sendModelString = null;
        //publish orchestrationService by producer
        OrchestrationServiceProducerHandler producerHandler = null;
        try {
            ObjectMapper objectMapper = objectMapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).setSerializationInclusion(JsonInclude.Include.NON_NULL);
            sendModelString = objectMapper.writeValueAsString(modelForMQ);
            log.debug("event:orchestrationservice {}", sendModelString);
            producerHandler = new OrchestrationServiceProducerHandler(0);
            producerHandler.send(sendModelString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            if(producerHandler != null)
                producerHandler.close();
        }
        return modelForMQ;
    }


}
