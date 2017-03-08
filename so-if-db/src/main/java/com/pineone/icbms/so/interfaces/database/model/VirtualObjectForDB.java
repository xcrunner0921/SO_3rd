package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Virtual Object model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 13..
 */
@Entity
@Table(name="virtual_object")
public class VirtualObjectForDB extends CommonEntity {

    @Column(name="functionality_id")
    String functionalityId;

    @Column(name="aspect_id")
    String aspectId;

    public String getFunctionalityId() {
        return functionalityId;
    }

    public void setFunctionalityId(String functionalityId) {
        this.functionalityId = functionalityId;
    }

    public String getAspectId() {
        return aspectId;
    }

    public void setAspect(String aspectId) {
        this.aspectId = aspectId;
    }
}
