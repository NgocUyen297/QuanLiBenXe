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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
    @NamedQuery(name = "District.findById", query = "SELECT d FROM District d WHERE d.id = :id"),
    @NamedQuery(name = "District.findByName", query = "SELECT d FROM District d WHERE d.name = :name"),
    @NamedQuery(name = "District.findByPrefix", query = "SELECT d FROM District d WHERE d.prefix = :prefix")})
public class District implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "_name")
    private String name;
    @Size(max = 20)
    @Column(name = "_prefix")
    private String prefix;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pupDistrict")
    private Ticket ticket;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dDistrict")
    private Ticket ticket1;
    @JoinColumn(name = "_province_id", referencedColumnName = "id")
    @ManyToOne
    private Province provinceId;
    @OneToMany(mappedBy = "districtId")
    private Collection<Ward> wardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtid")
    private Collection<Tram> tramCollection;

    public District() {
    }

    public District(Integer id) {
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

    public Province getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Province provinceId) {
        this.provinceId = provinceId;
    }

    @XmlTransient
    public Collection<Ward> getWardCollection() {
        return wardCollection;
    }

    public void setWardCollection(Collection<Ward> wardCollection) {
        this.wardCollection = wardCollection;
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
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.District[ id=" + id + " ]";
    }
    
}
