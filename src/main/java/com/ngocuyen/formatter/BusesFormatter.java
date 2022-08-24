/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngocuyen.formatter;

import com.uav.pojo.Buses;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class BusesFormatter implements Formatter<Buses>{

    @Override
    public String print(Buses bus, Locale locale) {
        return String.valueOf(bus.getBid());
    }

    @Override
    public Buses parse(String string, Locale locale) throws ParseException {
        Buses b = new Buses();
        b.setBid(Integer.parseInt(string));
        return b;
    }
    
}
