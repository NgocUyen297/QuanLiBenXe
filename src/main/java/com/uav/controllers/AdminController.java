/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Buses;
import com.uav.service.BusesService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pc
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BusesService busesService;

    @GetMapping("/buses")
    public String list(Model model) {
        model.addAttribute("buses", new Buses());
        return "buses";
    }

    @PostMapping("/buses")
    public String add(Model model, @ModelAttribute(value = "buses") @Valid Buses p,
            BindingResult r) {
        if (r.hasErrors()) {
            return "buses";
        }

        if (this.busesService.addBuses(p) == true) {
            return "redirect:/";
        }

        return "buses";
    }
}
