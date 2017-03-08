package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * ProfileForDB model for authoring.<BR/>
 * 
 * Created by uni4love on 2017. 1. 13..
 */
@Entity
@Table(name="profile")
public class ProfileForDB extends CommonEntity {

    @JoinColumn(name = "id")
    ContextModelForDB contextModel;

    @JoinColumn(name = "id")
    OrchestrationServiceForDB orchestrationService;

    @Column(name = "location_id")
    String locationId;

    @Column
    boolean eneabled;

    public ContextModelForDB getContextModel() {
        return contextModel;
    }

    public void setContextModel(ContextModelForDB contextModel) {
        this.contextModel = contextModel;
    }

    public OrchestrationServiceForDB getOrchestrationService() {
        return orchestrationService;
    }

    public void setOrchestrationService(OrchestrationServiceForDB orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public boolean isEneabled() {
        return eneabled;
    }

    public void setEneabled(boolean eneabled) {
        this.eneabled = eneabled;
    }
}
