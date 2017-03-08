package com.pineone.icbms.so.processor.virtualobject.messagequeue.handler;

/**
 * VirtualObjectProducerHandler factory.<BR/>
 * Created by uni4love on 2017. 1. 4..
 */
public class VirtualObjectProducerHandlerFactory {
    /**
     * return VirtualObjectProducerHandler instance.<BR/>
     *
     * @return VirtualObjectProducerHandler
     */
    public static VirtualObjectProducerHandler getVirtualObjectProducerHandler(int id) {
        return new VirtualObjectProducerHandler(id);
    }
}
