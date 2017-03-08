package com.pineone.icbms.so.virtualobject.aspect;

/**
 * Aspect default class.<BR/>
 * Created by uni4love on 2016. 11. 27..
 */
public class DefaultAspect extends AGenericAspect {
    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public DefaultAspect(String id, String name) {
        super(id, name);
    }

    /**
     * constructor
     * @param uri uri
     */
    public DefaultAspect(String id, String name, String uri) {
        this(id, name);
        this.uri = uri;
    }
}
