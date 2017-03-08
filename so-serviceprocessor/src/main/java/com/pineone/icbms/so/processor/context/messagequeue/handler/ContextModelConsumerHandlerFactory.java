package com.pineone.icbms.so.processor.context.messagequeue.handler;

/**
 * ContextModelConsumerHandler factory.<BR/>
 * <p>
 * Created by uni4love on 2017. 1. 4..
 */
public class ContextModelConsumerHandlerFactory {
    /**
     * max count
     */
    private int MAX_COUNT = 5;

    /**
     * return ContextModelConsumerHandler instance.<BR/>
     *
     * @return ContextModelConsumer
     */
    public static ContextModelConsumerHandler getContextModelConsumer(int id) {
        return new ContextModelConsumerHandler(id);
    }
}
