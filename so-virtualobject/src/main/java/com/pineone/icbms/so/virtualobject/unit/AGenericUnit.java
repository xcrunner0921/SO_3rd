package com.pineone.icbms.so.virtualobject.unit;

import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

/**
 * Unit abstract generic class.<BR/>
 *
 * Created by uni4love on 2016. 11. 27..
 */
abstract class AGenericUnit extends AGenericIdNameOwner implements IGenericUnit {
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
    public AGenericUnit(String id, String name) {
        super(id, name);
    }

    @Override
    public String getUri() {
        return uri;
    }

    /**
     * set location uri.<BR/>
     * @param uri uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("\nid = ").append(id);
        sb.append("\nname = ").append(name);
        sb.append("\nuri = ").append(uri);
        return sb.toString();
    }
}
