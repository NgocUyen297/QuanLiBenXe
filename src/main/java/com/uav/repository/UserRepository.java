/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.uav.repository;

import java.util.List;
import com.uav.pojo.Users;

public interface UserRepository {
    boolean addUser(Users user);
    List<Users> getUser (String username);
    
}
