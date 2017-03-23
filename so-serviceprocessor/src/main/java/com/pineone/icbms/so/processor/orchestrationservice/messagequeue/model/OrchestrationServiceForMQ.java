package com.pineone.icbms.so.processor.orchestrationservice.messagequeue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pineone.icbms.so.processor.messagequeue.model.ACommonForMQ;
import com.pineone.icbms.so.util.collection.CollectionUtils;
import com.pineone.icbms.so.virtualobject.DefaultVirtualObject;
import com.pineone.icbms.so.virtualobject.IGenericVirtualObject;
import com.pineone.icbms.so.virtualobject.composite.DefaultCompositeVirtualObject;
import com.pineone.icbms.so.virtualobject.composite.IGenericCompositeVirtualObject;
import com.pineone.icbms.so.virtualobject.orchestrationservice.DefaultOrchestrationService;
import com.pineone.icbms.so.virtualobject.orchestrationservice.IGenericOrchestrationService;

import java.util.List;

/**
 * OrchestrationService model for MQ.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value= JsonInclude.Include.NON_ABSENT, content= JsonInclude.Include.NON_EMPTY)
public class OrchestrationServiceForMQ extends ACommonForMQ {

    /**
     * orchestration service list
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected List<DefaultOrchestrationService> orchestrationServiceList;

    /**
     * composite virtual object list
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected List<DefaultCompositeVirtualObject> compositeVirtualObjectList;

    /**
     * virtual object list
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected List<DefaultVirtualObject> virtualObjectList;

    /**
     * constructor
     */
    public OrchestrationServiceForMQ() {
    }

    /**
     * constructor<BR/>
     *
     * @param id   id
     * @param name name
     */
    public OrchestrationServiceForMQ(String id, String name) {
        super(id, name);
    }

    public List<IGenericOrchestrationService> getOrchestrationServiceList() {
//        return orchestrationServiceList.stream().filter(element -> element instanceof IGenericOrchestrationService).collect(Collectors.toList());
        return CollectionUtils.castCollection(orchestrationServiceList, IGenericOrchestrationService.class);
    }

    public void setOrchestrationServiceList(List<DefaultOrchestrationService> orchestrationServiceList) {
        this.orchestrationServiceList = orchestrationServiceList;
    }

    public List<IGenericCompositeVirtualObject> getCompositeVirtualObjectList() {
//        return compositeVirtualObjectList.stream().filter(element -> element instanceof IGenericCompositeVirtualObject).collect(Collectors.toList());
        return CollectionUtils.castCollection(compositeVirtualObjectList, IGenericCompositeVirtualObject.class);
    }

    public void setCompositeVirtualObjectList(List<DefaultCompositeVirtualObject> compositeVirtualObjectList) {
        this.compositeVirtualObjectList = compositeVirtualObjectList;
    }

    public List<IGenericVirtualObject> getVirtualObjectList() {
//        return virtualObjectList.stream().filter(element -> element instanceof IGenericVirtualObject).collect(Collectors.toList());
        return CollectionUtils.castCollection(virtualObjectList, IGenericVirtualObject.class);
    }

    public void setVirtualObjectList(List<DefaultVirtualObject> virtualObjectList) {
        this.virtualObjectList = virtualObjectList;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        for (DefaultOrchestrationService os : orchestrationServiceList) {
            sb.append(",\nos: ").append(os);
        }
//        sb.append(",\nvirtualobject: ").append(virtualObject);
        sb.append("]");
        return sb.toString();
    }
}
