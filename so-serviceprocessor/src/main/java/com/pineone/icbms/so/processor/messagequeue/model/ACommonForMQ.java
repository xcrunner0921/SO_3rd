package com.pineone.icbms.so.processor.messagequeue.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pineone.icbms.so.state.DefaultState;
import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

import java.sql.Timestamp;

/**
 * This class have handler properties for MQ.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
abstract public class ACommonForMQ extends AGenericIdNameOwner {
    /**
     * message created date
     */
    Timestamp createdDate;

    /**
     * message expire date
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Timestamp expireDate;

    /**
     * priority
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    int priority;

    /**
     * state
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected DefaultState<String> state;

    /**
     * constructor
     */
    public ACommonForMQ() {
    }

    /**
     * constructor
     */
    public ACommonForMQ(String id, String name) {
        super(id, name);
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    public DefaultState getState() {
        return state;
    }

    public void setState(DefaultState<String> state) {
        this.state = state;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(state != null)
            sb.append("state: ").append(state);
        if (createdDate != null)
            sb.append("createdDate = ").append(createdDate);
        if (expireDate != null)
            sb.append("expireDate = ").append(expireDate);
        return sb.toString();
    }
}
