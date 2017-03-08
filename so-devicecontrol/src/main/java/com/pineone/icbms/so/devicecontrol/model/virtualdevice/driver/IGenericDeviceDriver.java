package com.pineone.icbms.so.devicecontrol.model.virtualdevice.driver;

/**
 * Device Driver generic interface.<BR/>
 *
 * Created by uni4love on 2017. 1. 15..
 */
public interface IGenericDeviceDriver<RESC> extends IDeviceDriver {
    /**
     * devicemapper control method
     */
    void control(RESC ... resource);
}
