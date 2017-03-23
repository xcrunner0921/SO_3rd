package com.pineone.icbms.so.processor.virtualobject.messagequeue.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.devicecontrol.model.virtualdevice.IGenericVirtualDevice;
import com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler.DeviceControlProducerHandler;
import com.pineone.icbms.so.processor.devicecontrol.messagequeue.model.VirtualDeviceForMQ;
import com.pineone.icbms.so.processor.interfaces.database.DatabaseManager;
import com.pineone.icbms.so.processor.virtualobject.messagequeue.model.VirtualObjectForMQ;
import com.pineone.icbms.so.util.id.IdUtils;
import com.pineone.icbms.so.virtualobject.functionlity.IGenericFunctionality;
import com.pineone.icbms.so.virtualobject.location.IGenericLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Virtual Object handler.<BR/>
 *
 * Created by uni4love on 2017. 1. 20..
 */
public class VirtualObjectHandler {
    /**
     * logger
     */
    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * virtual object handle.<BR/>
     *
     * @param virtualObjectForMQ
     */
    public void handle(VirtualObjectForMQ virtualObjectForMQ) {
        IGenericFunctionality functionality = virtualObjectForMQ.getFunctionality();
        //from process context
        IGenericLocation location = null;
        List<IGenericVirtualDevice> deviceList = DatabaseManager.getInstance().getDeviceList(functionality.getUri(), location.getUri());
        //create a VirtualDeviceForMQ
        //test instance
        VirtualDeviceForMQ modelForMQ = new VirtualDeviceForMQ(IdUtils.createRandomUUID(), "test-devicecontrol-for-mq");
        //publish VirtualDeviceForMQ by producer
        //object to json
        String sendModelString = null;
        DeviceControlProducerHandler producerHandler = null;
        try {
            sendModelString = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(modelForMQ);
            log.debug("event:devicecontrol {}", sendModelString);
            producerHandler = new DeviceControlProducerHandler(0);
            producerHandler.send(sendModelString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } finally {
            if(producerHandler != null)
                producerHandler.close();
        }
    }
}
