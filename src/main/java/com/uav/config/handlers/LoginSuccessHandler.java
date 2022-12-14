/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.config.handlers;

import com.uav.pojo.Users;
import com.uav.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    
    @Autowired
    private UserService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication a ) throws IOException, ServletException {
        Users user = this.userDetailsService.getUser(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", user);
        response.sendRedirect("http://localhost:8080/QuanLyBenXe/");
    }
    
}
