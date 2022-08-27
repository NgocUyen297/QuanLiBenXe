/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.service;

import java.util.List;
import com.uav.pojo.Users;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService{
    boolean addUser(Users user);
    List<Users> getUser (String username);
}
