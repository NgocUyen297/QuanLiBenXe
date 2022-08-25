/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import com.uav.pojo.Routebuses;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface RoutebusesService {
    List<Routebuses> getRoutebuses(Map<String, String> params, int page);

    long countRoutebuses();

    boolean deleteRoutebuses(int id);

    boolean addRoutebuses(Routebuses p);
    
    Routebuses getRoutebusesById (int RoutebusesId);
    
    List<Routebuses> getRoutebusesByRouteId (int RoutefId);
}
