/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "province")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findById", query = "SELECT p FROM Province p WHERE p.id = :id"),
    @NamedQuery(name = "Province.findByName", query = "SELECT p FROM Province p WHERE p.name = :name"),
    @NamedQuery(name = "Province.findByCode", query = "SELECT p FROM Province p WHERE p.code = :code")})
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "_name")
    private String name;
    @Size(max = 20)
    @Column(name = "_code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
    private Collection<Route> routeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startingpoint")
    private Collection<Route> routeCollection1;
    @OneToMany(mappedBy = "provinceId")
    private Collection<District> districtCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProvince")
    private Collection<Tram> tramCollection;

    public Province() {
    }

    public Province(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection1() {
        return routeCollection1;
    }

    public void setRouteCollection1(Collection<Route> routeCollection1) {
        this.routeCollection1 = routeCollection1;
    }

    @XmlTransient
    public Collection<District> getDistrictCollection() {
        return districtCollection;
    }

    public void setDistrictCollection(Collection<District> districtCollection) {
        this.districtCollection = districtCollection;
    }

    @XmlTransient
    public Collection<Tram> getTramCollection() {
        return tramCollection;
    }

    public void setTramCollection(Collection<Tram> tramCollection) {
        this.tramCollection = tramCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Province[ id=" + id + " ]";
    }
    
}
