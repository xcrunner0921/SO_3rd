package com.pineone.icbms.so.processor.virtualobject.messagequeue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pineone.icbms.so.processor.messagequeue.model.ACommonForMQ;
import com.pineone.icbms.so.virtualobject.aspect.DefaultAspect;
import com.pineone.icbms.so.virtualobject.functionlity.DefaultFunctionality;

/**
 * VirtualObject model for MQ.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value= JsonInclude.Include.NON_ABSENT, content= JsonInclude.Include.NON_EMPTY)
public class VirtualObjectForMQ extends ACommonForMQ {

    /**
     * functionality
     */
    protected DefaultFunctionality functionality;

    /**
     * aspect
     */
    protected DefaultAspect aspect;

    /**
     * constructor<BR/>
     *
     * @param id   id
     * @param name name
     */
    public VirtualObjectForMQ(String id, String name) {
        super(id, name);
    }

    public DefaultFunctionality getFunctionality() {
        return functionality;
    }

    public void setFunctionality(DefaultFunctionality functionality) {
        this.functionality = functionality;
    }

    public DefaultAspect getAspect() {
        return aspect;
    }

    public void setAspect(DefaultAspect aspect) {
        this.aspect = aspect;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(",\nfunctionlity: ").append(functionality);
        sb.append(",\naspect: ").append(aspect);
        sb.append("]");
        return sb.toString();
    }
}
