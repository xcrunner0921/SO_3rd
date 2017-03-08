package com.pineone.icbms.so.processor.interfaces.registry;

import com.pineone.icbms.so.processor.interfaces.processor.IGenericProcessor;

/**
 * processor registry generic interface.<BR/>
 *
 * Created by uni4love on 2016. 11. 24..
 */
public interface IGenericProcessorRegistry<K, V> extends IProcessorRegistry<K, V> {
    /**
     * add a processor.<BR/>
     *
     * @param processor
     */
    public void addProcessor(IGenericProcessor processor);

    /**
     * return existence of processor<BR/>
     *
     * @param processor processor
     * @return true/false
     */
    public boolean existProcessor(IGenericProcessor processor);
}
