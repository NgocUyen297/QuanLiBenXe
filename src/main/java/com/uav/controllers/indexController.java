/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.service.BusesService;
import com.uav.service.ProvinceService;
import com.uav.service.RouteService;
import com.uav.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.uav.service.PlxeService;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author pc
 */

@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")

public class indexController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private BusesService busesService;
        
    @Autowired
    private UserService usersService;
    
    @Autowired
    private PlxeService plxeService;
    
    @Autowired
    private Environment env;

    
    @ModelAttribute
    public void commonAttr(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("users", this.usersService.getUsers());
        model.addAttribute("loaixe", this.plxeService.getPlxes());
        model.addAttribute("routes", this.routeService.getRoutes(params, 0));
        model.addAttribute("chuyenxe", this.busesService.getBuses(params, 0));
        model.addAttribute("provinces", this.provinceService.getProvinces());
    }
    
    @RequestMapping("/")
    public String index(Model model,@RequestParam Map<String, String> params) {
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int size = Integer.parseInt(env.getProperty("page.size").toString());
        model.addAttribute("page_size",size);
        model.addAttribute("routeCounter", this.routeService.countRoute());
        model.addAttribute("busesCounter", this.busesService.countBuses());
        return "index";
    }
    
}
