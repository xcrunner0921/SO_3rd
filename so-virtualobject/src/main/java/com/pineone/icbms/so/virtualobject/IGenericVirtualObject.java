package com.pineone.icbms.so.virtualobject;

import com.pineone.icbms.so.virtualobject.functionlity.IGenericFunctionality;
import com.pineone.icbms.so.virtualobject.aspect.IGenericAspect;

/**
 * Generic virtual object.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
public interface IGenericVirtualObject extends IVirtualObject<IGenericFunctionality, IGenericAspect> {
    /**
     * return functionality.<BR/>
     *
     * @return functionality
     */
    IGenericFunctionality getFunctionality();

    /**
     * return aspect.<BR/>
     *
     * @return aspect
     */
    IGenericAspect getAspect();
}
