package com.pineone.icbms.so.virtualobject.orchestrationservice;

import com.pineone.icbms.so.virtualobject.IGenericVirtualObject;
import com.pineone.icbms.so.state.IGenericState;
import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.composite.IGenericCompositeVirtualObject;

import java.util.List;

/**
 * Generic orchestrationservice abstract class.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
abstract public class AGenericOrchestrationService extends AGenericIdNameOwner
        implements IGenericOrchestrationService, java.io.Serializable {
    /**
     * orchestrationservice list
     */
    protected List<IGenericOrchestrationService> orchestrationServiceList = null;

    /**
     * composite virtual object list
     */
    protected List<IGenericCompositeVirtualObject> compositeVirtualObjectList = null;

    /**
     * virtual object: composite or general
     */
    protected List<IGenericVirtualObject> virtualObjectList;

    /**
     * state
     */
    protected IGenericState state = null;

    /**
     * constructor<BR/>
     *
     * @param id   id
     * @param name name
     */
    public AGenericOrchestrationService(String id, String name) {
        super(id, name);
    }

    @Override
    public List<IGenericOrchestrationService> getOrchestrationServiceList() {
        return orchestrationServiceList;
    }

    /**
     * return virtual object.<BR/>
     *
     * @return virtual object
     */
    @Override
    public List<IGenericCompositeVirtualObject> getCompositeVirtualObjectList() {
        return compositeVirtualObjectList;
    }

    /**
     * return virtual object.<BR/>
     *
     * @return virtual object
     */
    @Override
    public List<IGenericVirtualObject> getVirtualObjectList() {
        return virtualObjectList;
    }

    @Override
    public IGenericState getState() {
        return state;
    }

//    /**
//     * interface for returning Store<BR/>
//     *
//     * @return Map
//     */
//    protected abstract Map createStore();
}
