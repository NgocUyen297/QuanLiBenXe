package com.uav.pojo;

import com.uav.pojo.Province;
import com.uav.pojo.Tram;
import com.uav.pojo.Ward;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T18:44:27")
@StaticMetamodel(District.class)
public class District_ { 

    public static volatile SingularAttribute<District, String> prefix;
    public static volatile CollectionAttribute<District, Tram> tramCollection;
    public static volatile SingularAttribute<District, String> name;
    public static volatile SingularAttribute<District, Integer> id;
    public static volatile SingularAttribute<District, Province> provinceId;
    public static volatile CollectionAttribute<District, Ward> wardCollection;

}