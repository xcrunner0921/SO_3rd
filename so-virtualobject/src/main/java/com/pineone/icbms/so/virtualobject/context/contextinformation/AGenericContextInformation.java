package com.pineone.icbms.so.virtualobject.context.contextinformation;

import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

/**
 * generic context information abstract class.<BR/>
 *
 * Created by uni4love on 2016. 11. 26..
 */
abstract public class AGenericContextInformation extends AGenericIdNameOwner implements IGenericContextInformation {
    /**
     * uri
     */
    protected String uri;

    /**
     * constructor
     */
    public AGenericContextInformation() {
    }

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericContextInformation(String id, String name) {
        super(id, name);
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
        sb.append("]");
        return sb.toString();
    }
}
