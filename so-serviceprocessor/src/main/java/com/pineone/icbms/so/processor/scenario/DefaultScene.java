package com.pineone.icbms.so.processor.scenario;

import com.pineone.icbms.so.processor.interfaces.scenario.ICut;
import com.pineone.icbms.so.processor.interfaces.scenario.IScene;
import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

import java.util.List;

/**
 * scene default class.<BR/>
 *
 * Created by uni4love on 2017. 1. 12..
 */
public class DefaultScene extends AGenericIdNameOwner implements IScene<DefaultCut> {
    /**
     * cut list
     */
    List<DefaultCut> cutList = null;

    /**
     * constructor
     */
    public DefaultScene() {
    }

    /**
     * return cut list.<BR/>
     *
     * @return List<ICut>
     */
    @Override
    public List<ICut> getCutList() {
        return null;
    }

    public void setCutList(List<DefaultCut> cutList) {
        this.cutList = cutList;
    }

    public void addCut(DefaultCut cut) {
        this.cutList.add(cut);
    }
}
