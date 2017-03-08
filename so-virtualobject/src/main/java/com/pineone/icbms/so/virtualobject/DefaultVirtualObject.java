package com.pineone.icbms.so.virtualobject;

import com.pineone.icbms.so.virtualobject.aspect.DefaultAspect;
import com.pineone.icbms.so.virtualobject.functionlity.DefaultFunctionality;

import java.util.UUID;

/**
 * Virtual Object default class.<BR/>
 * Created by uni4love on 2016. 11. 16..
 */
public class DefaultVirtualObject extends AGenericVirtualObject {

    /**
     * constructor<BR/>
     *
     * @param id id
     * @param name name
     */
    public DefaultVirtualObject(String id, String name) {
        super(id, name);
    }

    /**
     * test main.<BR/>
     *
     * @param args
     */
    public static void main(String[] args) {
        DefaultAspect aspect = new DefaultAspect(UUID.randomUUID().toString(), "Test Aspect");
        aspect.setUri("aspect://test-aspect/");
        DefaultFunctionality func = new DefaultFunctionality(UUID.randomUUID().toString(), "Test Functionality");
        func.setUri("func://test-functionality/");
        DefaultVirtualObject vo = new DefaultVirtualObject(UUID.randomUUID().toString(), "Test VirtualObject");
        vo.setAspect(aspect);
        vo.setFunctionality(func);
        System.out.println("VO: " + vo);
    }
}
