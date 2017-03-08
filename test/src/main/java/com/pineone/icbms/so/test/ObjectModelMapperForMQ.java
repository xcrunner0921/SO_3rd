package com.pineone.icbms.so.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextInformationForMQ;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextModelForMQ;
import com.pineone.icbms.so.util.id.IdUtils;


/**
 * object mapper test.<BR/>
 *
 * Created by uni4love on 2016. 12. 15..
 */
public class ObjectModelMapperForMQ {
    /**
     * test context model.
     */
    private void testContextModelSerialize() {
        //context model
        ContextModelForMQ cm = new ContextModelForMQ(IdUtils.createRandomUUID(), "test ContextModelForMQ");

        int contextInformationCount = 2;
        //context information
        ContextInformationForMQ ci = null;
        for(int i=0; i<contextInformationCount; i++) {
            ci = new ContextInformationForMQ(IdUtils.createRandomUUID(), "test ContextInformation " + i);
            cm.addContextInformation(ci);
        }
        //obj mapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            String cmString = objectMapper.writeValueAsString(cm);
            System.out.println(cmString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * test main
     * @param args
     */
    public static void main(String[] args) {
        ObjectModelMapperForMQ mapper = new ObjectModelMapperForMQ();
        mapper.testContextModelSerialize();
    }
}
