package com.pineone.icbms.so.processor.route;

import com.pineone.icbms.so.processor.interfaces.processor.IGenericProcessor;
import com.pineone.icbms.so.processor.registry.SequenceProcessorRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Process Line class.<BR/>
 *
 * This class support for processor, filter, rule process.<BR/>
 *
 * Created by uni4love on 2016. 11. 24..
 */
public class ProcessLine {
    /**
     * logger
     */
    private Logger log = LoggerFactory.getLogger(ProcessLine.class.getClass());

    /**
     * process registry
     */
    private SequenceProcessorRegistry processRegistry = new SequenceProcessorRegistry();

    /**
     * add a processor.<BR/>
     *
     * @param processor
     */
    public void addProcessor(IGenericProcessor processor) {
        this.processRegistry.addProcessor(processor);
    }

    /**
     * return a processor.<BR/>
     *
     * @param key key for a processor
     * @return processor
     */
    public IGenericProcessor getProcessor(String key) {
        return this.processRegistry.getValue(key);
    }

    /**
     * return existence of processor<BR/>
     *
     * @param processor processor
     * @return true/false
     */
    public boolean existProcessor(IGenericProcessor processor) {
        return this.processRegistry.existProcessor(processor.getId());
    }

    /**
     * return existence of processor<BR/>
     *
     * @param processorName processor name
     * @return true/false
     */
    public boolean existProcessor(String processorName) {
        return this.processRegistry.existProcessor(processorName);
    }
}
