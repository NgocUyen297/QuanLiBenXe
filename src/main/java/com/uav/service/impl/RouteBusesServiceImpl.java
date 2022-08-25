/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Routebuses;
import com.uav.repository.RouteBusesRepository;
import com.uav.service.RouteBusesService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class RouteBusesServiceImpl implements RouteBusesService {

    @Autowired
    private RouteBusesRepository routebusesRepository;

    @Override
    public List<Routebuses> getRouteBuses(Map<String, String> params, int page) {
        return this.routebusesRepository.getRouteBuses(params, page);
    }

    @Override
    public int countRBuses() {
        return this.routebusesRepository.countRBuses();
    }

    @Override
    public boolean deleteRBuses(int id) {
        return this.routebusesRepository.deleteRBuses(id);
    }

    @Override
    public boolean addRBuses(Routebuses p) {
        return this.routebusesRepository.addRBuses(p);
    }

}
