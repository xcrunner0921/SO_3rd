package com.pineone.icbms.so.state;

import com.pineone.icbms.so.util.registry.AGenericKeyValueRegistry;

/**
 * State abstract class.<BR/>
 * <p>
 * Created by uni4love on 2016. 12. 8..
 */
abstract public class AGenericState<K, V> extends AGenericKeyValueRegistry<K, V> implements IGenericState<K, V> {

}
