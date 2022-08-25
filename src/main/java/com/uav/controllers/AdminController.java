/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Buses;
import com.uav.pojo.Route;
import com.uav.pojo.Routebuses;
import com.uav.service.BusesService;
import com.uav.service.RouteBusesService;
import com.uav.service.RouteService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pc
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private Environment env;

    @Autowired
    private RouteService routeService;

    @Autowired
    private BusesService busesService;

    @Autowired
    private RouteBusesService routebusesService;


//ĐƯỜNG DẪN WEB THÊM CHUYẾN XE
    @GetMapping("/buses")
    public String list(Model model) {
        model.addAttribute("buses", new Buses());
        return "buses";
    }

    @PostMapping("/buses")
    public String add(@ModelAttribute(value = "buses") @Valid Buses p,
            BindingResult r) {

        if (r.hasErrors()) {
            return "buses";
        }

        if (this.busesService.addBuses(p) == true) {
            return "redirect:/admin/buses";
        }

        return "buses";
    }

//ĐƯỜNG DẪN THÊM CHUYẾN XE CHO TUYẾN XE
    @GetMapping("/routebuses")
    public String listRB(Model model,@RequestParam Map<String, String> params) {
        model.addAttribute("routebuses", new Routebuses());
        model.addAttribute("routebuses2", this.routebusesService.getRouteBuses(params, 0));
        return "routebuses";
    }
    
    @PostMapping("/routebuses")
    public String addRB(@ModelAttribute(value = "routebuses") @Valid Routebuses k,
            BindingResult r) {

        if (r.hasErrors()) {
            return "routebuses";
        }

        if (this.routebusesService.addRBuses(k) == true) {
            return "redirect:/admin/routebuses";
        }

        return "routebuses";
    }


    
    
//Nháp
    @GetMapping("/listbuses")
    public String list(Model model, @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int size = Integer.parseInt(env.getProperty("page.size").toString());
        model.addAttribute("routebuses", this.routebusesService.getRouteBuses(params, 0));
        return "listbuses";
    }
}
