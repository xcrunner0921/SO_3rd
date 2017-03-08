package com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler;

/**
 * OrchestrationServiceConsumerHandler factory.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class OrchestrationServiceConsumerHandlerFactory {
    /**
     * max count
     */
    private int MAX_COUNT = 5;

    /**
     * return OrchestrationServiceConsumerHandler instance.<BR/>
     *
     * @return OrchestrationServiceConsumerHandler
     */
    public static OrchestrationServiceConsumerHandler getOrchestrationServiceConsumerHandler(int id) {
        return new OrchestrationServiceConsumerHandler(id);
    }
}
