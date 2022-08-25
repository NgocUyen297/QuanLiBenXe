/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Buses;
import com.uav.pojo.Route;
import com.uav.pojo.Routebuses;
import com.uav.pojo.Ticket;
import com.uav.service.BusesService;
import com.uav.service.RouteService;
import com.uav.service.RouteBusesService;
import com.uav.service.RoutestationService;
import com.uav.service.TicketService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    
    @Autowired
    private RouteService routeService;
    
    @Autowired
    private RoutestationService routestationService;
    
    @Autowired
    private RouteBusesService routebusesService;
    @Autowired
    private TicketService ticketService;
    
    @Autowired
    private BusesService  busesService;
    
    
    @GetMapping("/route/{routeId}")
    public String RouteDetail(Model model,@PathVariable(value="routeId") int routeId){
        Route rId = this.routeService.getRouteById(routeId);
        model.addAttribute("startingpoint", rId.getStartingpoint().getName());
        model.addAttribute("destination", rId.getDestination().getName());
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        
        model.addAttribute("routeBuses", this.routebusesService.getRoutebusesByRouteId(routeId));
       
        return "route-details";
    }
    
    @GetMapping("/route/{routeId}/{routeBusID}")
    public String SoleTicket(Model model, @PathVariable(value="routeId") int routeId,
                                          @PathVariable(value="routeBusID") int routeBusID,
                                          @RequestParam(value="soghe", required = false, defaultValue = "") String soghe)
    {
        model.addAttribute("route", this.routeService.getRouteById(routeId));
        model.addAttribute("routeBus", this.routebusesService.getRoutebusesById(routeBusID));
        model.addAttribute("pickupStations", this.routestationService.getPickupStationByRouteId(routeId));
        model.addAttribute("arriveStations", this.routestationService.getArriveStationByRouteId(routeId));
        model.addAttribute("ticket", new Ticket());
        
        return "sole-ticket";
    }
    
    @RequestMapping(value = "/route/addTicket/{busId}/{routeBusID}", method = RequestMethod.POST)
    public String addTicket(ModelMap model,
                            @ModelAttribute(value = "ticket") Ticket ticket,
                            HttpServletRequest request,
                            @PathVariable(value="busId") int busId,
                            @PathVariable(value="routeBusID") int routeBusID)
    {
       
        Buses bus = this.busesService.getBusById(busId);
        ticket.setBusesId(bus);
        System.out.println("============================================="+routeBusID);
        Routebuses routBus = this.routebusesService.getRoutebusesById(routeBusID);
        System.out.println("============================================="+routBus);
        int price = routBus.getPrice();
        System.out.println("====================" + price);
        int amount = ticket.getAmount();
        System.out.println("=============================" + amount);
        int total = ticket.getAmount() * routBus.getPrice();
        ticket.setTotal(total);
        this.ticketService.addTicket(ticket);
        return "redirect:/route/1";
    }
}
