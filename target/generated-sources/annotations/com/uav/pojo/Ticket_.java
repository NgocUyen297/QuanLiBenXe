package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.District;
import com.uav.pojo.Users;
import com.uav.pojo.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-23T21:35:18")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Short> tstatusPay;
    public static volatile SingularAttribute<Ticket, Integer> amount;
    public static volatile SingularAttribute<Ticket, Integer> total;
    public static volatile SingularAttribute<Ticket, Ward> pupWard;
    public static volatile SingularAttribute<Ticket, Buses> busesId;
    public static volatile SingularAttribute<Ticket, Ward> dWard;
    public static volatile SingularAttribute<Ticket, District> pupDistrict;
    public static volatile SingularAttribute<Ticket, District> dDistrict;
    public static volatile SingularAttribute<Ticket, String> seats;
    public static volatile SingularAttribute<Ticket, Users> userId;
    public static volatile SingularAttribute<Ticket, Integer> tid;
    public static volatile SingularAttribute<Ticket, String> username;

}