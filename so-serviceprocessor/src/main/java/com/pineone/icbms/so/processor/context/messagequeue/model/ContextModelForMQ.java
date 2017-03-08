package com.pineone.icbms.so.processor.context.messagequeue.model;

import com.pineone.icbms.so.processor.messagequeue.model.ACommonForMQ;

import java.util.ArrayList;
import java.util.List;

/**
 * ContextInformation model for MQ.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
public class ContextModelForMQ extends ACommonForMQ {
    /**
     * uri
     */
    protected String uri;

    /**
     * context information list
     */
    protected List<ContextInformationForMQ> contextInformationList;

    /**
     * constructor<BR/>
     *
     * @param id   id
     * @param name name
     */
    public ContextModelForMQ(String id, String name) {
        super(id, name);
        contextInformationList = new ArrayList<>();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<ContextInformationForMQ> getContextInformationList() {
        return contextInformationList;
    }

    public void setContextInformationList(List<ContextInformationForMQ> contextInformationList) {
        this.contextInformationList = contextInformationList;
    }

    public void addContextInformation(ContextInformationForMQ contextInformation) {
        this.contextInformationList.add(contextInformation);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(", uri = ").append(uri);
        for(ContextInformationForMQ ci:contextInformationList) {
            sb.append(",\ncontextinformation: ").append(ci);
        }
        sb.append(super.toString());
        sb.append("]");
        return sb.toString();
    }
}
