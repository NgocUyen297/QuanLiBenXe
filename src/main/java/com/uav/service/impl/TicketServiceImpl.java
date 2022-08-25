/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.service.impl;

import com.uav.pojo.Ticket;
import com.uav.repository.TicketRepository;
import com.uav.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class TicketServiceImpl  implements TicketService{
    
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public boolean addTicket(Ticket p) {
        return this.ticketRepository.addTicket(p);
    }
    
}
