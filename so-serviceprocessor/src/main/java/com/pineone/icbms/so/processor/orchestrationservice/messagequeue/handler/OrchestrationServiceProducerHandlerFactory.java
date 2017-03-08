package com.pineone.icbms.so.processor.orchestrationservice.messagequeue.handler;

/**
 * OrchestrationServiceProducerHandler factory.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class OrchestrationServiceProducerHandlerFactory {
    /**
     * return OrchestrationServiceProducerHandler instance.<BR/>
     *
     * @return OrchestrationServiceProducerHandler
     */
    public static OrchestrationServiceProducerHandler getOrchestrationServiceProducerHandler(int id) {
        return new OrchestrationServiceProducerHandler(id);
    }
}
