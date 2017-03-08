package com.pineone.icbms.so.devicecontrol.model.virtualdevice;

import com.pineone.icbms.so.devicecontrol.model.virtualdevice.driver.IGenericDeviceDriver;

/**
 * generic virtual devicemapper interface.<BR/>
 *
 * Created by uni4love on 2017. 1. 11..
 */
public interface IGenericVirtualDevice extends IVirtualDevice {
    /**
     * devicemapper driver
     * @return devicemapper driver
     */
    IGenericDeviceDriver getDeviceDriver();
}
