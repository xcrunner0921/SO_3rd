package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ScheduleContextForDB model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 16..
 */
@Entity
@Table(name = "schedule_context")
public class ScheduleContextForDB extends CommonEntity {

    @Column(name = "schedule", nullable = false)
    String schedule;

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
