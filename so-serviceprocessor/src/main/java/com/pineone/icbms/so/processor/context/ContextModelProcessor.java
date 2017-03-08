package com.pineone.icbms.so.processor.context;

import com.pineone.icbms.so.processor.context.messagequeue.handler.ContextModelConsumerHandler;
import com.pineone.icbms.so.processor.interfaces.processor.AGenericProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ContextModelConsumerHandler runner.<BR/>
 *
 * Created by uni4love on 2017. 1. 12..
 */
public class ContextModelProcessor extends AGenericProcessor {
    /**
     * handler count
     */
    private int HANDLER_COUNT = 3;

    /**
     * constructor
     */
    public ContextModelProcessor() {

    }

    /**
     * constructor
     *
     * @param id id
     * @param name name
     */
    public ContextModelProcessor(String id, String name) {
        super(id, name);
    }

    /**
     * called method before process()
     */
    @Override
    public void beforeProcess() {

    }

    /**
     * called method after process()
     */
    @Override
    public void afterProcess() {

    }

    /**
     * begin Handler on thread.
     */
    public void process() {
        //executorservice
        ExecutorService executorService = Executors.newFixedThreadPool(HANDLER_COUNT);
        //handler list
        List<ContextModelConsumerHandler> consumerList = new ArrayList<>();
        for (int i = 0; i < HANDLER_COUNT; i++) {
            ContextModelConsumerHandler consumer = new ContextModelConsumerHandler(i);
            consumerList.add(consumer);
            //execute a thread
            executorService.submit(consumer);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (ContextModelConsumerHandler consumer : consumerList) {
                    consumer.shutdown();
                }
                executorService.shutdown();
                try {
                    executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
