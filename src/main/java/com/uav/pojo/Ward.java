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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "ward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ward.findAll", query = "SELECT w FROM Ward w"),
    @NamedQuery(name = "Ward.findById", query = "SELECT w FROM Ward w WHERE w.id = :id"),
    @NamedQuery(name = "Ward.findByName", query = "SELECT w FROM Ward w WHERE w.name = :name"),
    @NamedQuery(name = "Ward.findByPrefix", query = "SELECT w FROM Ward w WHERE w.prefix = :prefix"),
    @NamedQuery(name = "Ward.findByProvinceId", query = "SELECT w FROM Ward w WHERE w.provinceId = :provinceId")})
public class Ward implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "_name")
    private String name;
    @Size(max = 20)
    @Column(name = "_prefix")
    private String prefix;
    @Column(name = "_province_id")
    private Integer provinceId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pupWard")
    private Ticket ticket;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dWard")
    private Ticket ticket1;
    @JoinColumn(name = "_district_id", referencedColumnName = "id")
    @ManyToOne
    private District districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardId")
    private Collection<Tram> tramCollection;

    public Ward() {
    }

    public Ward(Integer id) {
        this.id = id;
    }

    public Ward(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket1() {
        return ticket1;
    }

    public void setTicket1(Ticket ticket1) {
        this.ticket1 = ticket1;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
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
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Ward[ id=" + id + " ]";
    }
    
}
