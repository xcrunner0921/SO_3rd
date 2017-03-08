package com.pineone.icbms.so.virtualobject.composite;

import com.pineone.icbms.so.virtualobject.IVirtualObject;
import com.pineone.icbms.so.virtualobject.aspect.IGenericAspect;
import com.pineone.icbms.so.virtualobject.common.IGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.functionlity.IGenericFunctionality;

import java.util.List;

/**
 * Composite Virtual Object interface.<BR/>
 *
 * Created by uni4love on 2016. 11. 17..
 */
public interface ICompositeVirtualObject<VIRTUALOBJECT extends IVirtualObject> extends IVirtualObject<IGenericFunctionality, IGenericAspect>, IGenericIdNameOwner {
    /**
     * return virtual object list.<BR/>
     * @return virtual object list
     */
    List<VIRTUALOBJECT> getVirtualObjectList();
}
