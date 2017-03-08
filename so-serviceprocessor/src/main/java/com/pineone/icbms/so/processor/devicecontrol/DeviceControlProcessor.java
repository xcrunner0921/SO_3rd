package com.pineone.icbms.so.processor.devicecontrol;

import com.pineone.icbms.so.processor.devicecontrol.messagequeue.handler.DeviceControlConsumerHandler;
import com.pineone.icbms.so.processor.interfaces.processor.AGenericProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * DeviceControlConsumerHandler runner.<BR/>
 *
 * Created by uni4love on 2017. 1. 12..
 */
public class DeviceControlProcessor extends AGenericProcessor {
    /**
     * handler count
     */
    private int HANDLER_COUNT = 3;

    /**
     * constructor
     */
    public DeviceControlProcessor() {

    }

    /**
     * constructor
     *
     * @param id id
     * @param name name
     */
    public DeviceControlProcessor(String id, String name) {
        super(id, name);
    }

    /**
     * begin Handler on thread.
     */
    @Override
    public void process() {
        ExecutorService executorService = Executors.newFixedThreadPool(HANDLER_COUNT);
        List<DeviceControlConsumerHandler> consumerList = new ArrayList<>();
        for (int i = 0; i < HANDLER_COUNT; i++) {
            DeviceControlConsumerHandler consumer = new DeviceControlConsumerHandler(i);
            consumerList.add(consumer);
            executorService.submit(consumer);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (DeviceControlConsumerHandler consumer : consumerList) {
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
}
