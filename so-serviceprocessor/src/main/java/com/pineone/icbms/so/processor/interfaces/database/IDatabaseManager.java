package com.pineone.icbms.so.processor.interfaces.database;

import com.pineone.icbms.so.devicecontrol.model.virtualdevice.IGenericVirtualDevice;
import com.pineone.icbms.so.interfaces.database.model.AspectForDB;
import com.pineone.icbms.so.interfaces.database.model.OrchestrationServiceForDB;
import com.pineone.icbms.so.interfaces.database.model.ProfileForDB;
import com.pineone.icbms.so.interfaces.database.model.VirtualObjectForDB;

import java.util.List;

/**
 * Database interface<BR/>
 *
 * Created by uni4love on 2017. 1. 8..
 */
public interface IDatabaseManager {

    ProfileForDB getProfileByContextModelId(String contextModelId);

    OrchestrationServiceForDB getOrchestrationServiceById(String id);

    AspectForDB getAspect(String virtualObjectId);

    VirtualObjectForDB getVirtualObjectById(String id);

    List<IGenericVirtualDevice> getDeviceList(String functionalityUri, String locationUri);


}
