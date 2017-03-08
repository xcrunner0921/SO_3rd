package com.pineone.icbms.so.state;

import java.util.HashMap;
import java.util.Map;

/**
 * state default class.<BR/>
 *
 * Created by uni4love on 2017. 1. 5..
 */
public class DefaultState<V> extends AGenericState<String, V> {
    /**
     * return interface for returning Store<BR/>
     *
     * @return Map
     */
    @Override
    public Map<String, V> createStore() {
        return new HashMap<String, V>();
    }
}