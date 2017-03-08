package com.pineone.icbms.so.processor.virtualobject.messagequeue.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.devicecontrol.model.virtualdevice.IGenericVirtualDevice;
import com.pineone.icbms.so.processor.interfaces.database.DatabaseManager;
import com.pineone.icbms.so.processor.messagequeue.handler.AGenericConsumerHandler;
import com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler.DeviceControlProducerHandler;
import com.pineone.icbms.so.processor.devicecontrol.messagequeue.model.VirtualDeviceForMQ;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.model.VirtualObjectForMQ;
import com.pineone.icbms.so.util.id.IdUtils;
import com.pineone.icbms.so.virtualobject.functionlity.IGenericFunctionality;
import com.pineone.icbms.so.virtualobject.location.IGenericLocation;
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
            System.out.println("ConsumerRecord:" + this.id + ": " + record);

            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            }

            // -create message From ContextModelForMQ for messageQueue
            // -publish to message queue
            //1. get a devicemapper by virtual functionality with location from repository(database, sda)
            String receivedModelString = record.value();
            try {
                VirtualObjectForMQ virtualObjectForMQ = objectMapper.readValue(receivedModelString, VirtualObjectForMQ.class);
                IGenericFunctionality functionality = virtualObjectForMQ.getFunctionality();
                //from process context
                IGenericLocation location = null;
                List<IGenericVirtualDevice> deviceList = DatabaseManager.getInstance().getDeviceList(functionality.getUri(), location.getUri());
                //2. create a VirtualDeviceForMQ
                //test instance
                VirtualDeviceForMQ modelForMQ = new VirtualDeviceForMQ(IdUtils.createRandomUUID(), "test-devicecontrol-for-mq");
                //3. publish VirtualDeviceForMQ by producer
                //object to json
                String sendModelString = null;
                try {
                    sendModelString = objectMapper.writeValueAsString(modelForMQ);
                    log.debug("event:devicecontrol {}", sendModelString);
                    DeviceControlProducerHandler producerHandler = new DeviceControlProducerHandler(0);
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
