package com.uav.pojo;

import com.uav.pojo.Buses;
import com.uav.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-27T23:58:30")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Date> creatdatetime;
    public static volatile SingularAttribute<Comment, String> context;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, Buses> bid;
    public static volatile SingularAttribute<Comment, Users> userid;

}