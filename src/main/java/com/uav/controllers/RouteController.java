/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Route;
import com.uav.pojo.Routebuses;
import com.uav.service.RouteService;
import com.uav.service.RoutebusesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteController {
    
    @Autowired
    private RouteService routeService;
    
    @Autowired
    private RoutebusesService routebusesService;
    
    @GetMapping("/route/{routeId}")
    public String RouteDetail(Model model,@PathVariable(value="routeId") int routeId){
        Route rId = this.routeService.getRouteById(routeId);
        model.addAttribute("startingpoint", rId.getStartingpoint().getName());
        model.addAttribute("destination", rId.getDestination().getName());
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        
        model.addAttribute("routeBuses", this.routebusesService.getRoutebusesByRouteId(routeId));
       
        return "route-details";
    }
}
