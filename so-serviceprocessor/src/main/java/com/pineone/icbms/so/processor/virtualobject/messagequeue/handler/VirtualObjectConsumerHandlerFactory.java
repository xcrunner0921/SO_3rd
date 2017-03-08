package com.pineone.icbms.so.processor.virtualobject.messagequeue.handler;

/**
 * Created by uni4love on 2017. 1. 4..
 */
public class VirtualObjectConsumerHandlerFactory {
    /**
     * max count
     */
    private int MAX_COUNT = 5;

    /**
     * return VirtualObjectConsumerHandler instance.<BR/>
     *
     * @return VirtualObjectConsumerHandler
     */
    public static VirtualObjectConsumerHandler getVirtualObjectConsumerHandler(int id) {
        return new VirtualObjectConsumerHandler(id);
    }
}
