package com.pineone.icbms.so.interfaces.database.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * handler entity model.<BR/>
 * Created by uni4love on 2017. 1. 13..
 */
@MappedSuperclass
public class CommonEntity extends AbstractPersistable<String> {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    String id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "createdDate", nullable = false)
    Timestamp createdDate;

    @Column(name = "modifiedDate", nullable = false)
    Timestamp modifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
