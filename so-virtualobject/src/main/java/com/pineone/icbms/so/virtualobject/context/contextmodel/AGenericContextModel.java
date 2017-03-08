package com.pineone.icbms.so.virtualobject.context.contextmodel;

import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.context.contextinformation.IGenericContextInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * generic context model abstract class.<BR/>
 *
 * Created by uni4love on 2016. 11. 23..
 */
abstract public class AGenericContextModel extends AGenericIdNameOwner implements IGenericContextModel {
    /**
     * uri
     */
    protected String uri;

    /**
     * context information list
     */
    protected List<IGenericContextInformation> contextInformationList = new ArrayList<IGenericContextInformation>();

    /**
     * construcotr
     */
    public AGenericContextModel() {
    }

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericContextModel(String id, String name) {
        super(id, name);
    }

    /**
     * return Context Information list.<BR/>
     *
     * @return Context Information list
     */
    @Override
    public List<IGenericContextInformation> getContextInformationList() {
        return contextInformationList;
    }

    public void setContextInformationList(List<IGenericContextInformation> contextInformationList) {
        this.contextInformationList = contextInformationList;
    }

    public void addContextInformation(IGenericContextInformation contextInformation) {
        this.contextInformationList.add(contextInformation);
    }

    @Override
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
        for(IGenericContextInformation ci: contextInformationList) {
            sb.append(ci);
        }
        sb.append("]");
        return sb.toString();
    }
}
