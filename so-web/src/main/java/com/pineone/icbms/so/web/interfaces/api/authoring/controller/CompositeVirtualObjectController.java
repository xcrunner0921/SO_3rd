package com.pineone.icbms.so.web.interfaces.api.authoring.controller;

import com.pineone.icbms.so.interfaces.database.model.CompositeVirtualObjectForDB;
import com.pineone.icbms.so.interfaces.database.repository.CompositeVirtualObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller for CompositeVirtualObjectForDB.<BR/>
 *
 * Created by uni4love on 2017. 1. 13..
 */
@RestController
@RequestMapping("/cvo/*")
public class CompositeVirtualObjectController {
    /**
     * repository(DAO)
     */
    private CompositeVirtualObjectRepository repository;

    /**
     * constructor.<BR/>
     *
     * @param repository
     */
    @Autowired
    public CompositeVirtualObjectController(CompositeVirtualObjectRepository repository) {
        this.repository = repository;
    }

    /**
     * response for request "/cvo, HTTP-method:POST".<BR/>
     * @param cvo CompositeVirtualObjectForDB
     * @return created CompositeVirtualObjectForDB id
     */
    @RequestMapping(method = RequestMethod.POST)
    public String createCompositeVirtualObject(CompositeVirtualObjectForDB cvo) {
        //implements...
        return null;
    }

    /**
     * response for request "/cvo/{id}" .<BR/>
     * @param id CompositeVirtualObjectForDB id
     * @return CompositeVirtualObjectForDB
     */
    @RequestMapping(value = "/{id}")
    public CompositeVirtualObjectForDB getCompositeVirtualObject(@RequestParam("id") String id) {
        CompositeVirtualObjectForDB cvo = repository.findOne(id);
        return cvo;
    }

    /**
     * response for request "/cvo".<BR/>
     * @return CompositeVirtualObjectForDB list
     */
    @RequestMapping()
    public List<CompositeVirtualObjectForDB> getProfileList() {
        List<CompositeVirtualObjectForDB> cvoList = repository.findAll();
        return cvoList;
    }

    /**
     * response for request "/cvo, HTTP-method:PATCH(update)".<BR/>
     * @param cvo CompositeVirtualObjectForDB
     * @return updated profile id
     */
    @RequestMapping(method=RequestMethod.PATCH)
    public String updateCompositeVirtualObject(CompositeVirtualObjectForDB cvo) {
        //implements...
        return null;
    }

    /**
     * response for request "/cvo/{id}, HTTP-method:DELETE".<BR/>
     * @param id CompositeVirtualObjectForDB id
     * @return deleted CompositeVirtualObjectForDB id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCompositeVirtualObject(@RequestParam("id") String id) {
        repository.delete(id);
        return id;
    }

    /**
     * response for request "/cvo/{id}, HTTP-method:POST, 'register'".<BR/>
     * @param id CompositeVirtualObjectForDB id
     * @return registed CompositeVirtualObjectForDB id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String registerCompositeVirtualObject(String id) {
        //implements...
        return null;
    }
}
