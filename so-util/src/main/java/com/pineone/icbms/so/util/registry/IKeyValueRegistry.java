package com.pineone.icbms.so.util.registry;

/**
 * Key-value Registry interface<BR/>
 *
 * Created by uni4love on 2016. 11. 16..
 */
public interface IKeyValueRegistry<K, V> extends IRegistry {
    /**
     * register a key-value set.<BR/>
     *
     * @param key   key for value
     * @param value value
     */
    void addValue(K key, V value);

    /**
     * remove key-value<BR/>
     *
     * @param key key: class name(ex: class name with full package name)
     * @return removed value
     */
    V removeValue(K key);

    /**
     * get value<BR/>
     *
     * @param key key for value
     * @return value
     */
    V getValue(K key);
}
