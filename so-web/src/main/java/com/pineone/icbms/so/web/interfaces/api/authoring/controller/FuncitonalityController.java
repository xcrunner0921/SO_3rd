package com.pineone.icbms.so.web.interfaces.api.authoring.controller;

import com.pineone.icbms.so.interfaces.database.model.FunctionalityForDB;
import com.pineone.icbms.so.interfaces.database.repository.FunctionalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller for functionality.<BR/>
 *
 * Created by uni4love on 2017. 1. 13..
 */
@RestController
@RequestMapping("/functionality/*")
public class FuncitonalityController {
    /**
     * repository(DAO)
     */
    private FunctionalityRepository repository;

    /**
     * constructor.<BR/>
     *
     * @param repository FunctionalityRepository
     */
    @Autowired
    public FuncitonalityController(FunctionalityRepository repository) {
        this.repository = repository;
    }

    /**
     * response for request "/functionality, HTTP-method:POST".<BR/>
     * @param functionality FunctionalityForDB
     * @return created FunctionalityForDB id
     */
    @RequestMapping(method = RequestMethod.POST)
    public String createFunctionality(FunctionalityForDB functionality) {
        //implements...
        return null;
    }

    /**
     * response for request "/functionality/{id}" .<BR/>
     * @param id FunctionalityForDB id
     * @return FunctionalityForDB
     */
    @RequestMapping(value = "/{id}")
    public FunctionalityForDB getProfile(@RequestParam("id") String id) {
        FunctionalityForDB functionality = repository.findOne(id);
        return functionality;
    }

    /**
     * response for request "/functionality".<BR/>
     * @return FunctionalityForDB list
     */
    @RequestMapping()
    public List<FunctionalityForDB> getFunctionalityList() {
        List<FunctionalityForDB> functionalityList = repository.findAll();
        return functionalityList;
    }

    /**
     * response for request "/functionality, HTTP-method:PATCH(update)".<BR/>
     * @param functionality FunctionalityForDB
     * @return updated FunctionalityForDB id
     */
    @RequestMapping(method=RequestMethod.PATCH)
    public String updateFunctionality(FunctionalityForDB functionality) {
        //implements...
        return null;
    }

    /**
     * response for request "/functionality/{id}, HTTP-method:DELETE".<BR/>
     * @param id FunctionalityForDB id
     * @return deleted FunctionalityForDB id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteFunctionality(@RequestParam("id") String id) {
        repository.delete(id);
        return id;
    }

    /**
     * response for request "/functionality/{id}, HTTP-method:POST, 'register'".<BR/>
     * @param id FunctionalityForDB id
     * @return registed FunctionalityForDB id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String registerFunctionality(String id) {
        //implements...
        return null;
    }
}
