package com.pineone.icbms.so.processor.messagequeue.model;

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
    Timestamp expireDate;

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

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (createdDate != null)
            sb.append("createdDate = ").append(createdDate);
        if (expireDate != null)
            sb.append("expireDate = ").append(expireDate);
        return sb.toString();
    }
}
