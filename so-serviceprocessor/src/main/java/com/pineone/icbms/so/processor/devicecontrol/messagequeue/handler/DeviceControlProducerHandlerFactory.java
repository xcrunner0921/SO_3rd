package com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler;

/**
 * DeviceControlProducerHandler factory<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class DeviceControlProducerHandlerFactory {
    /**
     * return DeviceControlProducerHandler instance.<BR/>
     *
     * @return DeviceControlProducerHandler
     */
    public static DeviceControlProducerHandler getDeviceControlProducerHandler(int id) {
        return new DeviceControlProducerHandler(id);
    }
}
