/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Routebuses;
import com.uav.repository.RoutebusesRepository;
import com.uav.service.RoutebusesService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class RoutebusesServiceImpl implements RoutebusesService {
    
    @Autowired
    private RoutebusesRepository routebusesRepository;

    @Override
    public List<Routebuses> getRoutebuses(Map<String, String> params, int page) {
        return this.routebusesRepository.getRoutebuses(params, page);
    }

    @Override
    public long countRoutebuses() {
        return this.routebusesRepository.countRoutebuses();
    }

    @Override
    public boolean deleteRoutebuses(int id) {
        return this.routebusesRepository.deleteRoutebuses(id);
    }

    @Override
    public boolean addRoutebuses(Routebuses p) {
        return this.routebusesRepository.addRoutebuses(p);
    }

    @Override
    public Routebuses getRoutebusesById(int RoutebusesId) {
        return this.routebusesRepository.getRoutebusesById(RoutebusesId);
    }

    @Override
    public List<Routebuses> getRoutebusesByRouteId(int RouteId) {
        return this.routebusesRepository.getRoutebusesByRouteId(RouteId);
    }
    
}
