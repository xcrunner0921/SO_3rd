package com.pineone.icbms.so.virtualobject.common;

/**
 * abstract Generic id-name owner.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
abstract public class AGenericUriOwner implements IGenericUriOwner {
    /**
     * uri
     */
    protected String uri = null;

    @Override
    public String getUri() {
        return this.uri;
    }

    public void setId(String uri) {
        this.uri = uri;
    }
}
