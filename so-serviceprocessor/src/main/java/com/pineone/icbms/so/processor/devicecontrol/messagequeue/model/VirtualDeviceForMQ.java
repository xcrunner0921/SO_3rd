package com.pineone.icbms.so.processor.devicecontrol.messagequeue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pineone.icbms.so.processor.messagequeue.model.ACommonForMQ;

/**
 * DeviceControl model for MQ.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value= JsonInclude.Include.NON_ABSENT, content= JsonInclude.Include.NON_EMPTY)
public class VirtualDeviceForMQ extends ACommonForMQ {
    /**
     * constructor<BR/>
     *
     * @param id   id
     * @param name name
     */
    public VirtualDeviceForMQ(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append("]");
        return sb.toString();
    }
}
