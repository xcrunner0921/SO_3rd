package com.pineone.icbms.so.processor.context.messagequeue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pineone.icbms.so.processor.messagequeue.model.ACommonForMQ;

/**
 * ContextInformation model for MQ.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value= JsonInclude.Include.NON_ABSENT, content= JsonInclude.Include.NON_EMPTY)
public class ContextInformationForMQ extends ACommonForMQ {
    /**
     * uri
     */
    protected String uri;

    /**
     * constructor<BR/>
     *
     * @param id   id
     * @param name name
     */
    public ContextInformationForMQ(String id, String name) {
        super(id, name);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(", uri: ").append(uri);
        sb.append("]");
        return sb.toString();
    }
}
