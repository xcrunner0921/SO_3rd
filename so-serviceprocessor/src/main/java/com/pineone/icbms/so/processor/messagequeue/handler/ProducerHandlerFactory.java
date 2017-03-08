package com.pineone.icbms.so.processor.messagequeue.handler;

/**
 * MessageQueue Producer Handler factory.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class ProducerHandlerFactory  {
    /**
     * max count
     */
    private int MAX_COUNT = 5;

    /**
     * return ProducerHandler instance.<BR/>
     *
     * @return ProducerHandler
     */
    public static IProducerHandler getProducerHandler(MessageQueueHandler.TopicType topicType, int id) {
        //implements
        return null;
    }
}
