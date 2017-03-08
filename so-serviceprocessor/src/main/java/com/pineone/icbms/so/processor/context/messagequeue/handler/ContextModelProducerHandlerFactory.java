package com.pineone.icbms.so.processor.context.messagequeue.handler;

/**
 * ContextModelProducerHandler factory.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class ContextModelProducerHandlerFactory {
    /**
     * return ContextModelProducerHandler instance.<BR/>
     *
     * @return ContextModelProducerHandler
     */
    public static ContextModelProducerHandler getContextModelProducerHandler(int id) {
        return new ContextModelProducerHandler(id);
    }
}
