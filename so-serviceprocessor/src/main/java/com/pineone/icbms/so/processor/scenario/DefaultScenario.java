package com.pineone.icbms.so.processor.scenario;

import com.pineone.icbms.so.processor.interfaces.scenario.IScenario;
import com.pineone.icbms.so.processor.interfaces.scenario.IScenarioContext;
import com.pineone.icbms.so.processor.interfaces.scenario.IScene;
import com.pineone.icbms.so.virtualobject.common.AGenericIdNameOwner;

import java.util.List;

/**
 * Scenario default class.<BR/>
 *
 * Created by uni4love on 2017. 1. 12..
 */
public class DefaultScenario extends AGenericIdNameOwner implements IScenario {

    /**
     * scene list
     */
    List<IScene> sceneList = null;

    /**
     * scenario context
     */
    IScenarioContext scenarioContext = null;

    /**
     * constructor
     */
    public DefaultScenario() {
    }

    /**
     * return a ScenarioContext.<BR/>
     *
     * @return ScenarioContext
     */
    @Override
    public IScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public void setScenarioContext(IScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    /**
     * return scene list.<BR/>
     *
     * @return List<IScene>
     */
    @Override
    public List<IScene> getSceneList() {
        return null;
    }

    public void setSceneList(List<IScene> sceneList) {
        this.sceneList = sceneList;
    }

    public void addScene(IScene scene) {
        this.sceneList.add(scene);
    }


}
