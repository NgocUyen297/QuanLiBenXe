package com.uav.pojo;

import com.uav.pojo.District;
import com.uav.pojo.Tram;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T18:44:27")
@StaticMetamodel(Ward.class)
public class Ward_ { 

    public static volatile SingularAttribute<Ward, District> districtId;
    public static volatile SingularAttribute<Ward, String> prefix;
    public static volatile CollectionAttribute<Ward, Tram> tramCollection;
    public static volatile SingularAttribute<Ward, String> name;
    public static volatile SingularAttribute<Ward, Integer> id;
    public static volatile SingularAttribute<Ward, Integer> provinceId;

}