package com.pineone.icbms.so.processor.interfaces.profile;

import com.pineone.icbms.so.virtualobject.location.IGenericLocation;

/**
 * Generic profile interface.<BR/>
 * Created by uni4love on 2016. 11. 17..
 */
public interface IGenericProfile extends IProfile {
    /**
     * return location.<BR/>
     * @return location
     */
    IGenericLocation getLocation();
}
