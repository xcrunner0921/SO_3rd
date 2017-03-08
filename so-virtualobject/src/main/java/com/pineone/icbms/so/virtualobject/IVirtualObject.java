package com.pineone.icbms.so.virtualobject;

import com.pineone.icbms.so.virtualobject.common.IGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.common.IVirtualEntity;

/**
 * Virtual Object interface.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
public interface IVirtualObject<FUNCTIONALITY, ASPECT> extends IVirtualEntity, IGenericIdNameOwner {
    /**
     * return functionality.<BR/>
     *
     * @return functionality
     */
    FUNCTIONALITY getFunctionality();

    /**
     * return aspect.<BR/>
     *
     * @return aspect
     */
    ASPECT getAspect();
}
