/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.repository;

import com.uav.pojo.Routebuses;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public interface RouteBusesRepository {
    List<Routebuses> getRouteBuses(Map<String, String> params, int page);
    int countRBuses();
    boolean deleteRBuses(int id);
    boolean addRBuses(Routebuses p);
}
