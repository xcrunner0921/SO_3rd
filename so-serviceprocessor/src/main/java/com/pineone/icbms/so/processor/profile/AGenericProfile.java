package com.pineone.icbms.so.processor.profile;

import com.pineone.icbms.so.devicecontrol.model.virtualdevice.IGenericVirtualDevice;
import com.pineone.icbms.so.processor.interfaces.profile.IGenericProfile;
import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;
import com.pineone.icbms.so.virtualobject.context.contextmodel.IGenericContextModel;
import com.pineone.icbms.so.virtualobject.location.IGenericLocation;
import com.pineone.icbms.so.virtualobject.orchestrationservice.IGenericOrchestrationService;

import java.util.List;

/**
 * Generic profile abstract class.<BR/>
 * Created by uni4love on 2016. 11. 17..
 */
abstract public class AGenericProfile extends AGenericIdNameOwner implements IGenericProfile {

    /**
     * context model
     */
    protected IGenericContextModel contextModel;

    /**
     * orchestrationservice
     */
    protected IGenericOrchestrationService orchestrationService;

    /**
     * location
     */
    protected IGenericLocation location;

    /**
     * devicemapper list
     */
    protected List<IGenericVirtualDevice> deviceList;

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public AGenericProfile(String id, String name) {
        super(id, name);
    }

    /**
     * return context model.<BR/>
     *
     * @return context model
     */
    @Override
    public IGenericContextModel getContextModel() {
        return contextModel;
    }

    /**
     * return orchestrationservice<BR/>
     *
     * @return orchestrationservice
     */
    @Override
    public IGenericOrchestrationService getOrchestrationService() {
        return orchestrationService;
    }

    /**
     * return location.<BR/>
     *
     * @return location
     */
    @Override
    public IGenericLocation getLocation() {
        return location;
    }

    /**
     * return devicemapper list.<BR/>
     *
     * @return devicemapper list
     */
    public List<IGenericVirtualDevice> getDeviceList() {
        return deviceList;
    }

    /**
     * set orchestrationservice<BR/>
     *
     * @param orchestrationService
     */
    public void setOrchestrationService(IGenericOrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    /**
     * set context model.<BR/>
     *
     * @param contextModel
     */
    public void setContextModel(IGenericContextModel contextModel) {
        this.contextModel = contextModel;
    }

    /**
     * set location.<BR/>
     *
     * @param location
     */
    public void setLocation(IGenericLocation location) {
        this.location = location;
    }
}
