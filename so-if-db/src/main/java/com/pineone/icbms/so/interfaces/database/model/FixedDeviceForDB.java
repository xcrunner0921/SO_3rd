package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * fixed_device model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 16..
 */
@Entity
@Table(name="fixed_device")
public class FixedDeviceForDB extends CommonEntity {
    @Column(name = "profile_id")
    Long profileId;

    @Column(name = "virtual_object_id")
    Long virtualObjectId;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getVirtualObjectId() {
        return virtualObjectId;
    }

    public void setVirtualObjectId(Long virtualObjectId) {
        this.virtualObjectId = virtualObjectId;
    }
}
