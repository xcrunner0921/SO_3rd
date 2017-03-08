package com.pineone.icbms.so.interfaces.sda.handle;

import java.util.List;

/**
 * SDA system interface implements.<BR/>
 *
 * Created by uni4love on 2017. 1. 23.
 */
public class SdaClient {
    /**
     * retreive functionality list.<BR/>
     *
     * @param locationUri location uri
     * @return functionality list
     */
    public Object retreiveFunctionlaityListByLocation(String locationUri) {
        //implements..
        return null;
    }

    /**
     * retreive aspect.<BR/>
     *
     * @param functionalityUri functionality uri
     * @return aspect
     */
    public Object retreiveAspectByFunctionality(String functionalityUri) {
        //implements..
        return null;
    }

    /**
     * retreive unit.<BR/>
     *
     * @param aspectUri aspect uri
     * @return unit
     */
    public Object retreiveUnit(String aspectUri) {
        //implements..
        return null;
    }

    /**
     * retreive devicemapper list.<BR/>
     *
     * @param functionalityUri functionality uri
     * @param locationUri location uri
     * @return devicemapper list
     */
    public List<Object> retreiveDeviceList(String functionalityUri, String locationUri) {
        //implements..
        return null;
    }

    /**
     * retreive operation list.<BR/>
     *
     * @param deviceUri devicemapper uri
     * @return operation list
     */
    public List<Object> retreiveOperationList(String deviceUri) {
        //implements..
        return null;
    }
}
