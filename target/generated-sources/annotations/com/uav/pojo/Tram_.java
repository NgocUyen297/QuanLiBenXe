package com.uav.pojo;

import com.uav.pojo.District;
import com.uav.pojo.Province;
import com.uav.pojo.Routestation;
import com.uav.pojo.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-23T21:35:18")
@StaticMetamodel(Tram.class)
public class Tram_ { 

    public static volatile SingularAttribute<Tram, Integer> idtram;
    public static volatile SingularAttribute<Tram, Province> idProvince;
    public static volatile SingularAttribute<Tram, District> districtid;
    public static volatile SingularAttribute<Tram, String> tenTram;
    public static volatile CollectionAttribute<Tram, Routestation> routestationCollection;
    public static volatile SingularAttribute<Tram, Ward> wardId;

}