package com.pineone.icbms.so.web.interfaces.api.context.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.interfaces.sda.model.ContextModelForIf;
import com.pineone.icbms.so.processor.context.messagequeue.handler.ContextModelProducerHandler;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextModelForMQ;
import com.pineone.icbms.so.web.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller for ContextModel<BR/>
 *
 * Created by uni4love on 2017. 1. 18..
 */
@RestController
@RequestMapping("/context/*")
public class ContextModelController {
    /**
     * logger
     */
    protected Logger log = LoggerFactory.getLogger(ContextModelController.class);

    /**
     * response for request "/context/cm, HTTP-method:POST".<BR/>
     *
     * @param contextModelForIf ContextModelForIf
     * @return created DeviceControlCallbackForDB id
     */
    @RequestMapping(value = "/cm", method = RequestMethod.POST)
    public String injectContextModel(@RequestBody ContextModelForIf contextModelForIf) {
        log.debug("ContextModelForMQ: {}", contextModelForIf);
        //implements...
        // create message From ContextModelForMQ for messageQueue
        // publish to message queue
        // ContextModelForIf --> ContextModelForMQ
        ContextModelForMQ cmForMQ = ModelMapper.ContextModelForIf2ContextModelForMQ(contextModelForIf);
        //object to json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String modelString = null;
        try {
            modelString = objectMapper.writeValueAsString(cmForMQ);
            log.warn("event:ContextModelForDB {}", modelString);
            //context model producer handler
            ContextModelProducerHandler producerHandler = new ContextModelProducerHandler(0);
            producerHandler.send(modelString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //추후 처리 결과를 정의하여 리턴함.
        return modelString;
    }
}
