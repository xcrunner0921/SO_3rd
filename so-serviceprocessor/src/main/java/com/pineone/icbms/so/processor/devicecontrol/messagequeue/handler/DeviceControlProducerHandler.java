package com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler;

import com.pineone.icbms.so.processor.messagequeue.handler.AGenericProducerHandler;

/**
 * VirtualDeviceForMQ Producer handler.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
public class DeviceControlProducerHandler extends AGenericProducerHandler {
    /**
     * topic list
     */
    private static final String TOPIC = "devicecontrol";

    /**
     * kafka producer group id by class name.<BR/>
     */
    private static final String GROUP_ID = DeviceControlProducerHandler.class.getSimpleName();

    /**
     * constructor.<BR/>
     */
    public DeviceControlProducerHandler(int id) {
        super(id);
    }

    /**
     * return topic.<BR/>
     *
     * @return topic
     */
    @Override
    public String getTopic() {
        return TOPIC;
    }
}
