package com.pineone.icbms.so.processor.messagequeue.handler;

/**
 * Message Queue handler interface.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public interface MessageQueueHandler {
    public enum TopicType {
        CONTEXT,
        ORCHESTRATION_SERVICE,
        VIRTUAL_OBJECT,
        DEVICE_CONTROL,
    }
}
