package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Context Information model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 13..
 */
@Entity
@Table(name="context_information")
public class ContextInformationForDB extends CommonEntity {
    @Column(name = "uri")
    String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
