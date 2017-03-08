package com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model.OrchestrationServiceForMQ;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.handler.VirtualObjectProducerHandler;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.handler.VirtualObjectProducerHandlerFactory;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.model.VirtualObjectForMQ;
import com.pineone.icbms.so.util.id.IdUtils;
import com.pineone.icbms.so.virtualobject.IGenericVirtualObject;
import com.pineone.icbms.so.virtualobject.composite.IGenericCompositeVirtualObject;
import com.pineone.icbms.so.virtualobject.orchestrationservice.IGenericOrchestrationService;
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
            System.out.println("ConsumerRecord:" + this.id + ": " + record);

            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            }

            // -create a message From OrchestrationServiceForMQ for messageQueue
            // -publish to message queue
            //1. get a virtual object from orchestrationservice
            String receivedModelString = record.value();
            try {
                OrchestrationServiceForMQ orchestrationServiceForMQ = objectMapper.readValue(receivedModelString, OrchestrationServiceForMQ.class);
                //OS list
                for (IGenericOrchestrationService service : orchestrationServiceForMQ.getOrchestrationServiceList()) {
                    handleOrchestrationService(service);
                }
                //CVO list
                handleCompositeVirtualObject(orchestrationServiceForMQ.getCompositeVirtualObjectList());
                //VO list
                handleVirtualObject(orchestrationServiceForMQ.getVirtualObjectList());

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
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
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //create a message virtualobjectForMQ
        //test instance
        VirtualObjectForMQ modelForMQ = new VirtualObjectForMQ(IdUtils.createRandomUUID(), "test-virtualobject-for-mq");
        String cmString = null;
        try {
            //object to json
            cmString = objectMapper.writeValueAsString(modelForMQ);
            log.debug("event:virtualobject {}", cmString);
            //publish virtualobjectForMQ by producer
            VirtualObjectProducerHandler producerHandler = VirtualObjectProducerHandlerFactory.getVirtualObjectProducerHandler(0);
            producerHandler.send(cmString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

