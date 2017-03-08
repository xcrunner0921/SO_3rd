package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Function model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 16..
 */
@Entity
@Table(name = "functionality")
public class FunctionalityForDB extends CommonEntity {
    @Column(name = "uri")
    String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
