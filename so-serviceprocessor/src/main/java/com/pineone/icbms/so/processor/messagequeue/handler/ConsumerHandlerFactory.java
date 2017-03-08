package com.pineone.icbms.so.processor.messagequeue.handler;

/**
 * MessageQueue Consumer Handler factory.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class ConsumerHandlerFactory {
    /**
     * max count
     */
    private int MAX_COUNT = 5;

    /**
     * return ConsumerHandler instance.<BR/>
     *
     * @return ConsumerHandler
     */
    public static IConsumerHandler getConsumer(MessageQueueHandler.TopicType topicType, int id) {
        //implements..
        return null;
    }
}
