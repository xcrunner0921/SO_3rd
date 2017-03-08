package com.pineone.icbms.so.web.interfaces.api.authoring.controller;

import com.pineone.icbms.so.interfaces.database.model.VirtualObjectForDB;
import com.pineone.icbms.so.interfaces.database.repository.VirtualObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller for ProfileForDB.<BR/>
 *
 * Created by uni4love on 2017. 1. 13..
 */
@RestController
@RequestMapping("/vo/*")
public class VirtualObjectController {
    /**
     * repository(DAO)
     */
    private VirtualObjectRepository repository;

    /**
     * constructor.<BR/>
     *
     * @param repository VirtualObjectRepository
     */
    @Autowired
    public VirtualObjectController(VirtualObjectRepository repository) {
        this.repository = repository;
    }

    /**
     * response for request "/vo, HTTP-method:POST".<BR/>
     * @param vo VirtualObjectForDB
     * @return created VirtualObjectForDB id
     */
    @RequestMapping(method = RequestMethod.POST)
    public String createVirtualObject(VirtualObjectForDB vo) {
        //implements...
        return null;
    }

    /**
     * response for request "/vo/{id}" .<BR/>
     * @param id VirtualObjectForDB id
     * @return VirtualObjectForDB
     */
    @RequestMapping(value = "/{id}")
    public VirtualObjectForDB getVirtualObject(@RequestParam("id") String id) {
        VirtualObjectForDB vo = repository.findOne(id);
        return vo;
    }

    /**
     * response for request "/vo".<BR/>
     * @return VirtualObjectForDB list
     */
    @RequestMapping()
    public List<VirtualObjectForDB> getProfileList() {
        List<VirtualObjectForDB> voList = repository.findAll();
        return voList;
    }

    /**
     * response for request "/vo, HTTP-method:PATCH(update)".<BR/>
     * @param vo VirtualObjectForDB
     * @return updated VirtualObjectForDB id
     */
    @RequestMapping(method=RequestMethod.PATCH)
    public String updateVirtualObject(VirtualObjectForDB vo) {
        //implements...
        return null;
    }

    /**
     * response for request "/vo/{id}, HTTP-method:DELETE".<BR/>
     * @param id VirtualObjectForDB id
     * @return deleted VirtualObjectForDB id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteVirtualObject(@RequestParam("id") String id) {
        repository.delete(id);
        return id;
    }

    /**
     * response for request "/vo/{id}, HTTP-method:POST, 'register'".<BR/>
     * @param id VirtualObjectForDB id
     * @return registed VirtualObjectForDB id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String registerVirtualObject(String id) {
        //implements...
        return null;
    }
}
