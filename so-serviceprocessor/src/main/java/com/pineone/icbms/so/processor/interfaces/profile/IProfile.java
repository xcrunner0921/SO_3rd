package com.pineone.icbms.so.processor.interfaces.profile;

import com.pineone.icbms.so.virtualobject.common.IGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.context.contextmodel.IContextModel;
import com.pineone.icbms.so.virtualobject.orchestrationservice.IOrchestrationService;

/**
 * Profile interface.<BR/>
 * Created by uni4love on 2016. 11. 17..
 */
public interface IProfile extends IGenericIdNameOwner
{
    /**
     * return context model.<BR/>
     * @return context model
     */
    IContextModel getContextModel();

    /**
     * return orchestration processor.<BR/>
     * @return orchestration processor
     */
    IOrchestrationService getOrchestrationService();
}
