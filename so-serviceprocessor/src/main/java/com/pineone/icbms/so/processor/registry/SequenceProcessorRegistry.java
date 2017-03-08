package com.pineone.icbms.so.processor.registry;

import com.pineone.icbms.so.processor.interfaces.processor.IGenericProcessor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * processor default class.<BR/>
 * <p>
 * Created by uni4love on 2016. 11. 24..
 */
public class SequenceProcessorRegistry extends AGenericProcessRegistry {
    /**
     * return interface for returning Store<BR/>
     *
     * @return Map
     */
    @Override
    protected Map<String, IGenericProcessor> createStore() {
        return new LinkedHashMap<String, IGenericProcessor>();
    }

    /**
     * add a processor.<BR/>
     *
     * @param processor
     */
    @Override
    public void addProcessor(IGenericProcessor processor) {
        addValue(processor.getName(), processor);
    }

    /**
     * add a processor.<BR/>
     *
     * @param key key
     * @param processor processor
     */
    public void addProcessor(String key, IGenericProcessor processor) {
        addValue(key, processor);
    }



    /**
     * return existence of processor<BR/>
     *
     * @param processor processor
     * @return true/false
     */
    @Override
    public boolean existProcessor(IGenericProcessor processor) {
        return this.store.containsKey(processor.getId());
    }

    /**
     * return existence of processor<BR/>
     *
     * @param processorName processor name
     * @return true/false
     */
    @Override
    public boolean existProcessor(String processorName) {
        return this.store.containsKey(processorName);
    }
}
