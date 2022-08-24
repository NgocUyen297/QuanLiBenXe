/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uav.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTid", query = "SELECT t FROM Ticket t WHERE t.tid = :tid"),
    @NamedQuery(name = "Ticket.findByUsername", query = "SELECT t FROM Ticket t WHERE t.username = :username"),
    @NamedQuery(name = "Ticket.findByAmount", query = "SELECT t FROM Ticket t WHERE t.amount = :amount"),
    @NamedQuery(name = "Ticket.findByTotal", query = "SELECT t FROM Ticket t WHERE t.total = :total"),
    @NamedQuery(name = "Ticket.findByTstatusPay", query = "SELECT t FROM Ticket t WHERE t.tstatusPay = :tstatusPay"),
    @NamedQuery(name = "Ticket.findByPickupStationId", query = "SELECT t FROM Ticket t WHERE t.pickupStationId = :pickupStationId"),
    @NamedQuery(name = "Ticket.findByArriveStationId", query = "SELECT t FROM Ticket t WHERE t.arriveStationId = :arriveStationId")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "total")
    private Integer total;
    @Column(name = "TstatusPay")
    private Short tstatusPay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pickupStationId")
    private int pickupStationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arriveStationId")
    private int arriveStationId;
    
    @JoinColumn(name = "userId", referencedColumnName = "userid")
    @ManyToOne
    private Users userId;
    
    @JoinColumn(name = "busesId", referencedColumnName = "bid")
    @ManyToOne
    private Buses busesId;
    

    public Ticket() {
    }

    public Ticket(Integer tid) {
        this.tid = tid;
    }

    public Ticket(Integer tid, int pickupStationId, int arriveStationId) {
        this.tid = tid;
        this.pickupStationId = pickupStationId;
        this.arriveStationId = arriveStationId;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Short getTstatusPay() {
        return tstatusPay;
    }

    public void setTstatusPay(Short tstatusPay) {
        this.tstatusPay = tstatusPay;
    }

    public int getPickupStationId() {
        return pickupStationId;
    }

    public void setPickupStationId(int pickupStationId) {
        this.pickupStationId = pickupStationId;
    }

    public int getArriveStationId() {
        return arriveStationId;
    }

    public void setArriveStationId(int arriveStationId) {
        this.arriveStationId = arriveStationId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Buses getBusesId() {
        return busesId;
    }

    public void setBusesId(Buses busesId) {
        this.busesId = busesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uav.pojo.Ticket[ tid=" + tid + " ]";
    }
    
}
