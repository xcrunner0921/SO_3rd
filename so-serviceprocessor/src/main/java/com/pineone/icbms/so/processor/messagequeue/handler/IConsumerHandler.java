package com.pineone.icbms.so.processor.messagequeue.handler;

import java.util.Collection;

/**
 * Producer handler interface.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public interface IConsumerHandler<M> {
    /**
     * ubscribe to the given list of topics.<BR/>
     *
     * @param topics topic list
     */
    void subscribe(Collection<String> topics);

    /**
     * read message and return.<BR/>
     *
     * @return T messages
     */
    M getMessage();

    /**
     * handle method.<BR/>
     *
     * @param records ConsumerRecords
     */
//    void handle(ConsumerRecords<K, V> records);

    /**
     * consumer close method.<BR/>
     */
    void close();
}
