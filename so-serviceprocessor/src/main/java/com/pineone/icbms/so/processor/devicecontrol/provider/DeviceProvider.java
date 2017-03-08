package com.pineone.icbms.so.processor.devicecontrol.provider;

import com.pineone.icbms.so.devicecontrol.model.virtualdevice.IGenericVirtualDevice;
import com.pineone.icbms.so.processor.interfaces.database.DatabaseManager;
import com.pineone.icbms.so.processor.interfaces.provider.IDeviceControlProvider;

import java.util.List;

/**
 * Device provider implements.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class DeviceProvider implements IDeviceControlProvider {
    /**
     * Create
     *
     * @param iGenericVirtualDevice
     * @return ID
     */
    @Override
    public String create(IGenericVirtualDevice iGenericVirtualDevice) {
        return null;
    }

    /**
     * Retrecive
     *
     * @param s
     * @return M
     */
    @Override
    public IGenericVirtualDevice retreive(String s) {
        return null;
    }

    /**
     * Update
     *
     * @param iGenericVirtualDevice
     * @return model ID
     */
    @Override
    public String update(IGenericVirtualDevice iGenericVirtualDevice) {
        return null;
    }

    /**
     * delete
     *
     * @param iGenericVirtualDevice
     * @return model ID
     */
    @Override
    public String delete(IGenericVirtualDevice iGenericVirtualDevice) {
        return null;
    }

    /**
     * return IGenericVirtualDevice list from database.<BR/>
     *
     * @param functionalityUri functionality uri
     * @param locationUri location uri
     * @return IGenericVirtualDevice list
     */
    public List<IGenericVirtualDevice> getDeviceList(String functionalityUri, String locationUri) {
        return DatabaseManager.getInstance().getDeviceList(functionalityUri, locationUri);
    }
}
