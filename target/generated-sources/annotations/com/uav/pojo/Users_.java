package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Busesstatus;
import com.uav.pojo.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-23T21:35:18")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, Integer> sdt;
    public static volatile SingularAttribute<Users, String> pass;
    public static volatile CollectionAttribute<Users, Busesstatus> busesstatusCollection;
    public static volatile SingularAttribute<Users, String> rode;
    public static volatile SingularAttribute<Users, Integer> userid;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, Date> createdAt;
    public static volatile CollectionAttribute<Users, Ticket> ticketCollection;
    public static volatile SingularAttribute<Users, Date> yearofbirth;
    public static volatile CollectionAttribute<Users, Buses> busesCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}