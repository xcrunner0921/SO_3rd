package com.pineone.icbms.so.virtualobject;

import com.pineone.icbms.so.virtualobject.aspect.IGenericAspect;
import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.functionlity.IGenericFunctionality;

import java.io.Serializable;

/**
 * abstract Generic virtual object.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
abstract public class AGenericVirtualObject extends AGenericIdNameOwner implements IGenericVirtualObject, Serializable {
    /**
     * functionality
     */
    protected IGenericFunctionality functionality = null;

    /**
     * aspect
     */
    protected IGenericAspect aspect = null;

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericVirtualObject(String id, String name) {
        super(id, name);
    }

    @Override
    public IGenericFunctionality getFunctionality() {
        return functionality;
    }

    public void setFunctionality(IGenericFunctionality functionality) {
        this.functionality = functionality;
    }

    @Override
    public IGenericAspect getAspect() {
        return aspect;
    }

    public void setAspect(IGenericAspect aspect) {
        this.aspect = aspect;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(",\nfunctionlity: ").append(functionality);
        sb.append(",\naspect: ").append(aspect);
        sb.append("]");
        return sb.toString();
    }
}
