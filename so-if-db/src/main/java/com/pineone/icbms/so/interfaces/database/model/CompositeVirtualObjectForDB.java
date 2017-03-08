package com.pineone.icbms.so.interfaces.database.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Composite Virtual Object model for authoring.<BR/>
 * Created by uni4love on 2017. 1. 13..
 */
@Entity
@Table(name="composite_virtual_object")
public class CompositeVirtualObjectForDB extends CommonEntity {

//    @OneToMany(mappedBy="composite_virtual_object"), cascade = CascadeType.ALL)
//    List<VirtualObjectForDB> virtualObjectList;
//
//    public List<VirtualObjectForDB> getVirtualObjectList() {
//        return virtualObjectList;
//    }
//
//    public void setVirtualObjectList(List<VirtualObjectForDB> virtualObjectList) {
//        this.virtualObjectList = virtualObjectList;
//    }
}
