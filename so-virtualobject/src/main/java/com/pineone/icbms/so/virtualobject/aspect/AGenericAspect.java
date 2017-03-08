package com.pineone.icbms.so.virtualobject.aspect;

import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

/**
 * abstract Generic Aspect.<BR/>
 * Created by uni4love on 2016. 11. 27..
 */
abstract class AGenericAspect extends AGenericIdNameOwner implements IGenericAspect {
    /**
     * location uri
     */
    protected String uri;

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericAspect(String id, String name) {
        super(id, name);
    }

    @Override
    public String getUri() {
        return uri;
    }

    /**
     * set location uri.<BR/>
     *
     * @param uri uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(", uri = ").append(uri);
        sb.append("]");
        return sb.toString();
    }
}
