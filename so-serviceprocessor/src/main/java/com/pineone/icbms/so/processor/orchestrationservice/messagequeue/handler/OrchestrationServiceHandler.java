package com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model.OrchestrationServiceForMQ;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.handler.VirtualObjectProducerHandler;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.handler.VirtualObjectProducerHandlerFactory;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.model.VirtualObjectForMQ;
import com.pineone.icbms.so.util.id.IdUtils;
import com.pineone.icbms.so.virtualobject.IGenericVirtualObject;
import com.pineone.icbms.so.virtualobject.composite.IGenericCompositeVirtualObject;
import com.pineone.icbms.so.virtualobject.orchestrationservice.IGenericOrchestrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * OrchestrationService handler.<BR/>
 *
 * Created by uni4love on 2017. 1. 20..
 */
public class OrchestrationServiceHandler {
    /**
     * logger
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * OrchestrationServiceForMQ process
     *
     * @param orchestrationServiceForMQ OrchestrationServiceForMQ message
     */
    public void handle(OrchestrationServiceForMQ orchestrationServiceForMQ){
        //OS list
        for (IGenericOrchestrationService service : orchestrationServiceForMQ.getOrchestrationServiceList()) {
            handleOrchestrationService(service);
        }
        //CVO list
        handleCompositeVirtualObject(orchestrationServiceForMQ.getCompositeVirtualObjectList());
        //VO list
        handleVirtualObject(orchestrationServiceForMQ.getVirtualObjectList());
    }

    /**
     * OS list process
     * @param list OS list
     */
    private void handleOrchestrationService(List<IGenericOrchestrationService> list) {
        for(IGenericOrchestrationService os: list) {
            handleOrchestrationService(os);
        }
    }

    /**
     * OS process
     * @param os OrchestrationService
     */
    private void handleOrchestrationService(IGenericOrchestrationService os) {
        //OS list
        handleOrchestrationService(os.getOrchestrationServiceList());
        //CVO list
        handleCompositeVirtualObject(os.getCompositeVirtualObjectList());
        //VO list
        handleVirtualObject(os.getVirtualObjectList());

    }

    /**
     * CVO list process
     * @param list CVO list
     */
    private void handleCompositeVirtualObject(List<IGenericCompositeVirtualObject> list) {
        for(IGenericCompositeVirtualObject cvo: list) {
            handleCompositeVirtualObject(cvo);
        }
    }

    /**
     * CVO process
     * @param cvo composite virtual object
     */
    private void handleCompositeVirtualObject(IGenericCompositeVirtualObject cvo) {
        handleVirtualObject(cvo.getVirtualObjectList());
    }

    /**
     * VO list process
     *
     * @param list VO list
     */
    private void handleVirtualObject(List<IGenericVirtualObject> list) {
        for (IGenericVirtualObject vo : list) {
            handleVirtualObject(vo);
        }
    }

    /**
     * VO process
     *
     * @param vo virtual object
     */
    private void handleVirtualObject(IGenericVirtualObject vo) {
        //create a message virtualobjectForMQ
        //test instance
        VirtualObjectForMQ modelForMQ = new VirtualObjectForMQ(IdUtils.createRandomUUID(), "test-virtualobject-for-mq");
        String cmString = null;
        VirtualObjectProducerHandler producerHandler = null;
        try {
            //object to json
            cmString = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(modelForMQ);
            log.debug("event:virtualobject {}", cmString);
            //publish virtualobjectForMQ by producer
            producerHandler = VirtualObjectProducerHandlerFactory.getVirtualObjectProducerHandler(0);
            producerHandler.send(cmString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            if(producerHandler != null)
                producerHandler.close();
        }
    }
}
