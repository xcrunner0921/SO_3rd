package com.pineone.icbms.so.processor.interfaces.processor;

import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

/**
 * processor abstract generic class.<BR/>
 *
 * Created by uni4love on 2016. 11. 24..
 */
abstract public class AGenericProcessor extends AGenericIdNameOwner implements IGenericProcessor {

    /**
     * constructor
     */
    public AGenericProcessor() {
    }

    /**
     * constructor
     *
     * @param id id
     * @param name name
     */
    public AGenericProcessor(String id, String name) {
        super(id, name);
    }
}
