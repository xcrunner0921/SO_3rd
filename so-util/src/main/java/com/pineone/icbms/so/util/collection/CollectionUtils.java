package com.pineone.icbms.so.util.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection Utiltity class.<BR/>
 *
 * Created by uni4love on 2017. 1. 16..
 */
public class CollectionUtils {
    /**
     * cast List by TYPE.<BR/>
     *
     * @param srcList source list
     * @param clas Class type to cast
     * @param <T> Type
     * @return casted List
     */
    public static <T> List<T> castCollection(List srcList, Class<T> clas) {
        List<T> list = new ArrayList<T>();
        for (Object obj : srcList) {
            if (obj != null && clas.isAssignableFrom(obj.getClass()))
                list.add(clas.cast(obj));
        }
        return list;
    }
}
