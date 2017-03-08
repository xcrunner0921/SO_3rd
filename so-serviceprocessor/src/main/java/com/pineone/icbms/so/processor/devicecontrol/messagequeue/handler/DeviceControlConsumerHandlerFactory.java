package com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler;

/**
 * DeviceControlConsumerHandler factory.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class DeviceControlConsumerHandlerFactory {
    /**
     * max count
     */
    private int MAX_COUNT = 5;

    /**
     * return ContextModelConsumerHandler instance.<BR/>
     *
     * @return ContextModelConsumerHandler
     */
    public static DeviceControlConsumerHandler getDeviceControlConsumer(int id) {
        return new DeviceControlConsumerHandler(id);
    }
}
