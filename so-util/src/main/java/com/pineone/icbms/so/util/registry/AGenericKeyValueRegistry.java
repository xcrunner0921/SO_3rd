package com.pineone.icbms.so.util.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;

/**
 * Key-value registry abstract generic class.<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
abstract public class AGenericKeyValueRegistry<K, V> implements IGenericKeyValueRegistry<K, V>, Serializable {
    /**
     * key-value store
     */
    protected Map<K, V> store = null;

    /**
     * registry name
     */
    protected String name = null;

    /**
     * logger
     */
    transient protected Logger log = getLogger();

    /**
     * constructor
     */
    public AGenericKeyValueRegistry() {
        store = createStore();
    }

    public AGenericKeyValueRegistry(String name) {
        this();
        this.name = name;
    }

    /**
     * add a key-value set.<BR/>
     *
     * @param value value
     */
    @Override
    public void addValue(K key, V value) {
        if (store.containsKey(key)) {
            log.warn(
                    "The key exists already in registry: {}, this item is skipped.",
                    key);
        } else {
            store.put(key, value);
            log.info("The value registered to registry by key {}", key);
        }
    }

    /**
     * remove a value<BR/>
     *
     * @param key key(ex: class name with full package name)
     * @return removed value
     */
    @Override
    public synchronized V removeValue(K key) {
        if (!store.containsKey(key)) {
            log.warn("The value NOT exists in registry: {}", key);
        }
        return store.remove(key);
    }

    /**
     * return value by key<BR/>
     *
     * @param key key(ex: class name with full package name)
     * @return value
     */
    @Override
    public V getValue(K key) {
        if (!store.containsKey(key)) {
            log.warn("The value NOT exists: {}", key);
        }
        return store.get(key);
    }

    /**
     * registry name
     *
     * @return registry name
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("store: " + store);
        return sb.toString();
    }

    /**
     * get logger instance.<BR/>
     */
    private Logger getLogger() {
        if (log == null) {
            log = LoggerFactory.getLogger(getClass());
        }
        return log;
    }

    /**
     * return interface for returning Store<BR/>
     *
     * @return Map
     */
    abstract protected Map<K, V> createStore();
}
