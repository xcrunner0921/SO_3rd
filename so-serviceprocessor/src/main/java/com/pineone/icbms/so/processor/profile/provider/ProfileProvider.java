package com.pineone.icbms.so.processor.profile.provider;

import com.pineone.icbms.so.interfaces.database.model.ProfileForDB;
import com.pineone.icbms.so.processor.interfaces.database.DatabaseManager;
import com.pineone.icbms.so.processor.interfaces.profile.IGenericProfile;
import com.pineone.icbms.so.processor.interfaces.provider.IProfileProvider;

/**
 * Profile provider implements.<BR/>
 *
 * Created by uni4love on 2017. 1. 4..
 */
public class ProfileProvider implements IProfileProvider {
    /**
     * Create
     *
     * @param iGenericProfile
     * @return ID
     */
    @Override
    public String create(IGenericProfile iGenericProfile) {
        return null;
    }

    /**
     * Retreive
     *
     * @param s
     * @return M
     */
    @Override
    public IGenericProfile retreive(String s) {
        return null;
    }

    /**
     * Update
     *
     * @param iGenericProfile
     * @return model ID
     */
    @Override
    public String update(IGenericProfile iGenericProfile) {
        return null;
    }

    /**
     * Delete
     *
     * @param iGenericProfile
     * @return model ID
     */
    @Override
    public String delete(IGenericProfile iGenericProfile) {
        return null;
    }

    /**
     * return ProfileForDB from database.<BR/>
     *
     * @param contextModelId context model id
     * @return ProfileForDB
     */
    public ProfileForDB getProfileByContextModelId(String contextModelId) {
        return DatabaseManager.getInstance().getProfileByContextModelId(contextModelId);
    }
}
