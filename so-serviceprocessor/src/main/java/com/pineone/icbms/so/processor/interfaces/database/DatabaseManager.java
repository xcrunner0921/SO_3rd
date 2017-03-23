package com.pineone.icbms.so.processor.interfaces.database;

import com.pineone.icbms.so.devicecontrol.model.virtualdevice.IGenericVirtualDevice;
import com.pineone.icbms.so.interfaces.database.model.AspectForDB;
import com.pineone.icbms.so.interfaces.database.model.OrchestrationServiceForDB;
import com.pineone.icbms.so.interfaces.database.model.ProfileForDB;
import com.pineone.icbms.so.interfaces.database.model.VirtualObjectForDB;

import java.util.List;

/**
 * Database Manager implements.<BR/>
 *
 * Created by uni4love on 2017. 1. 8..
 */
public final class DatabaseManager implements IDatabaseManager {

    /**
     * singleton holder
     */
    private static final class SingletonHolder {
        static final DatabaseManager singleton = new DatabaseManager();
    }

    /**
     * constructor
     */
    private DatabaseManager() {}

    /**
     * return singleton instance.<BR/>
     *
     * @return singleton instance
     */
    public static DatabaseManager getInstance() {
//        return SingletonHolder.singleton;
        return new DatabaseManager();
    }

    @Override
    public ProfileForDB getProfileByContextModelId(String contextModelId) {
        //implements..
        return null;
    }

    @Override
    public OrchestrationServiceForDB getOrchestrationServiceById(String id) {
        //implements..
        return null;
    }

    @Override
    public AspectForDB getAspect(String virtualObjectId) {
        //implements..
        return null;
    }

    @Override
    public VirtualObjectForDB getVirtualObjectById(String id) {
        //implements..
        return null;
    }

    @Override
    public List<IGenericVirtualDevice> getDeviceList(String functionalityUri, String locationUri) {
        //implements..
        return null;
    }
}
