package com.pineone.icbms.so.virtualobject.orchestrationservice;

import com.pineone.icbms.so.state.IGenericState;
import com.pineone.icbms.so.virtualobject.IGenericVirtualObject;
import com.pineone.icbms.so.virtualobject.composite.IGenericCompositeVirtualObject;

import java.util.List;

/**
 * Generic orchestrationservice interface.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
public interface IGenericOrchestrationService extends IOrchestrationService<IGenericVirtualObject> {
    /**
     * return orchestrationservice list.<BR/>
     *
     * @return orchestrationservice list
     */
    List<IGenericOrchestrationService> getOrchestrationServiceList();

    /**
     * return composite virtual object list.<BR/>
     *
     * @return composite virtual object list
     */
    List<IGenericCompositeVirtualObject> getCompositeVirtualObjectList();

    /**
     * return state.<BR/>
     *
     * @return state
     */
    IGenericState getState();
}
