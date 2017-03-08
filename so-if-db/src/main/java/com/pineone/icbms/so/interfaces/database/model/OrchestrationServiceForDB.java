package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Orchestration Service model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 13..
 */
@Entity
@Table(name="orchestration_service")
public class OrchestrationServiceForDB extends CommonEntity {
    @Column(name = "virtual_object_id")
    String virtualObjectId;

    @Column(name = "parent_id")
    String parentId;

    public String getVirtualObjectId() {
        return virtualObjectId;
    }

    public void setVirtualObjectId(String virtualObjectId) {
        this.virtualObjectId = virtualObjectId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

