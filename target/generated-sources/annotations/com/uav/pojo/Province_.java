package com.uav.pojo;

import com.uav.pojo.District;
import com.uav.pojo.Route;
import com.uav.pojo.Tram;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-23T21:35:18")
@StaticMetamodel(Province.class)
public class Province_ { 

    public static volatile SingularAttribute<Province, String> code;
    public static volatile CollectionAttribute<Province, District> districtCollection;
    public static volatile CollectionAttribute<Province, Route> routeCollection;
    public static volatile CollectionAttribute<Province, Tram> tramCollection;
    public static volatile SingularAttribute<Province, String> name;
    public static volatile SingularAttribute<Province, Integer> id;
    public static volatile CollectionAttribute<Province, Route> routeCollection1;

}