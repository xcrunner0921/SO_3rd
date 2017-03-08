package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DeviceControlCallbackForDB model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 13..
 */
@Entity
@Table(name="device_control_callback")
public class DeviceControlCallbackForDB extends CommonEntity {
    @Column(name = "orchestration_service_id", nullable = false)
    String parentId;

    @Column(name = "virtual_object_id", nullable = false)
    String virtualObjectId;

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

