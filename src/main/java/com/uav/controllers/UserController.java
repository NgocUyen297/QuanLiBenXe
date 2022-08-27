/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.controllers;

import com.uav.pojo.Users;
import com.uav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model)
    {
        model.addAttribute("user", new Users());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model,@ModelAttribute(value="user") Users user)
    {
        String errMsg = "";
        if(user.getPass().equals(user.getConfirmPassword()))
        {
            if(this.userDetailsService.addUser(user) == true)
            {
                return "redirect:/login";
            }
            else{
                errMsg = "Da co loi xay ra";
            }
        }else
        {
            errMsg = "Mat khau khong khop";
        }
            model.addAttribute("errMsg", errMsg);
        return "register";
    }
}
