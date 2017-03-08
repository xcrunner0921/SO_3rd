package com.pineone.icbms.so.processor.registry;

import com.pineone.icbms.so.processor.interfaces.processor.IGenericProcessor;
import com.pineone.icbms.so.processor.interfaces.registry.IGenericProcessorRegistry;
import com.pineone.icbms.so.util.registry.AGenericKeyValueRegistry;

/**
 * Abstract Generic processor registry<BR/>
 *
 * Created by uni4love on 2016. 11. 24..
 */
abstract public class AGenericProcessRegistry
        extends AGenericKeyValueRegistry<String, IGenericProcessor>
        implements IGenericProcessorRegistry<String, IGenericProcessor> {

     /**
     * return existence of processor<BR/>
     *
     * @param processorName processor name
     * @return true/false
     */
    abstract public boolean existProcessor(String processorName);
}
