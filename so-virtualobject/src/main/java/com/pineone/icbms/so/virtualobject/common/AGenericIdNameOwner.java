package com.pineone.icbms.so.virtualobject.common;

/**
 * abstract Generic id-name owner.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
abstract public class AGenericIdNameOwner implements IGenericIdNameOwner {
    /**
     * id
     */
    protected String id = null;

    /**
     * name
     */
    protected String name = null;

    /**
     * constuctor
     */
    public AGenericIdNameOwner() {
    }

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericIdNameOwner(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
