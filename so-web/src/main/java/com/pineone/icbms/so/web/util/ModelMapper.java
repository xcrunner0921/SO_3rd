package com.pineone.icbms.so.web.util;

import com.pineone.icbms.so.interfaces.sda.model.ContextInformationForIf;
import com.pineone.icbms.so.interfaces.sda.model.ContextModelForIf;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextInformationForMQ;
import com.pineone.icbms.so.processor.context.messagequeue.model.ContextModelForMQ;

import java.sql.Timestamp;

/**
 * Model mapper utility class.<BR/>
 *
 * Created by uni4love on 2016. 12. 26..
 */
public class ModelMapper {
    /**
     * convert ContextModelForIf to ContextModelForMQ.<BR/>
     *
     * @return ContextModelForMQ
     */
    public static ContextModelForMQ ContextModelForIf2ContextModelForMQ(ContextModelForIf contextModelForIf) {
        ContextModelForMQ cmForMQ = new ContextModelForMQ(contextModelForIf.getId(), contextModelForIf.getName());
        ContextInformationForMQ ciForMQ = null;
        for(ContextInformationForIf ci: contextModelForIf.getContextInformationList()) {
            ciForMQ = new ContextInformationForMQ(ci.getId(), ci.getName());
            ciForMQ.setUri(ci.getUri());
            cmForMQ.addContextInformation(ciForMQ);
        }
        //timestamp
        cmForMQ.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return cmForMQ;
    }
}
