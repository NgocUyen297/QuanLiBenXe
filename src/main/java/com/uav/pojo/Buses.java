/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b"),
    @NamedQuery(name = "Buses.findByBId", query = "SELECT b FROM Buses b WHERE b.bId = :bId"),
    @NamedQuery(name = "Buses.findByBusesName", query = "SELECT b FROM Buses b WHERE b.busesName = :busesName"),
    @NamedQuery(name = "Buses.findByBstatus", query = "SELECT b FROM Buses b WHERE b.bstatus = :bstatus"),
    @NamedQuery(name = "Buses.findByImage", query = "SELECT b FROM Buses b WHERE b.image = :image")})
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bId")
    private Integer bId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "BusesName")
    private String busesName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bstatus")
    private boolean bstatus;
    @Size(max = 500)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busesId")
    private Set<Ticket> ticketSet;
    @JoinColumn(name = "driverID", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users driverID;
    @JoinColumn(name = "loaixeID", referencedColumnName = "lid")
    @ManyToOne(optional = false)
    private Plxe loaixeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busesId")
    private Set<Routebuses> routebusesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "busesId")
    private Set<Busesstatus> busesstatusSet;

    public Buses() {
    }

    public Buses(Integer bId) {
        this.bId = bId;
    }

    public Buses(Integer bId, String busesName, boolean bstatus) {
        this.bId = bId;
        this.busesName = busesName;
        this.bstatus = bstatus;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getBusesName() {
        return busesName;
    }

    public void setBusesName(String busesName) {
        this.busesName = busesName;
    }

    public boolean getBstatus() {
        return bstatus;
    }

    public void setBstatus(boolean bstatus) {
        this.bstatus = bstatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    public Users getDriverID() {
        return driverID;
    }

    public void setDriverID(Users driverID) {
        this.driverID = driverID;
    }

    public Plxe getLoaixeID() {
        return loaixeID;
    }

    public void setLoaixeID(Plxe loaixeID) {
        this.loaixeID = loaixeID;
    }

    @XmlTransient
    public Set<Routebuses> getRoutebusesSet() {
        return routebusesSet;
    }

    public void setRoutebusesSet(Set<Routebuses> routebusesSet) {
        this.routebusesSet = routebusesSet;
    }

    @XmlTransient
    public Set<Busesstatus> getBusesstatusSet() {
        return busesstatusSet;
    }

    public void setBusesstatusSet(Set<Busesstatus> busesstatusSet) {
        this.busesstatusSet = busesstatusSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Buses[ bId=" + bId + " ]";
    }
    
}
