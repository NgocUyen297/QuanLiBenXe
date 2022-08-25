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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
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
    @NamedQuery(name = "Ticket.findBySeats", query = "SELECT t FROM Ticket t WHERE t.seats = :seats"),
    @NamedQuery(name = "Ticket.findByTstatusPay", query = "SELECT t FROM Ticket t WHERE t.tstatusPay = :tstatusPay")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "seats")
    private String seats;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TstatusPay")
    private short tstatusPay;
    @JoinColumn(name = "busesId", referencedColumnName = "bid")
    @ManyToOne(optional = false)
    private Buses busesId;
    @JoinColumn(name = "pupDistrict", referencedColumnName = "id")
    @OneToOne(optional = false)
    private District pupDistrict;
    @JoinColumn(name = "dDistrict", referencedColumnName = "id")
    @OneToOne(optional = false)
    private District dDistrict;
    @JoinColumn(name = "userId", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "pupWard", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Ward pupWard;
    @JoinColumn(name = "dWard", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Ward dWard;

    public Ticket() {
    }

    public Ticket(Integer tid) {
        this.tid = tid;
    }

    public Ticket(Integer tid, String username, int amount, int total, String seats, short tstatusPay) {
        this.tid = tid;
        this.username = username;
        this.amount = amount;
        this.total = total;
        this.seats = seats;
        this.tstatusPay = tstatusPay;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public short getTstatusPay() {
        return tstatusPay;
    }

    public void setTstatusPay(short tstatusPay) {
        this.tstatusPay = tstatusPay;
    }

    public Buses getBusesId() {
        return busesId;
    }

    public void setBusesId(Buses busesId) {
        this.busesId = busesId;
    }

    public District getPupDistrict() {
        return pupDistrict;
    }

    public void setPupDistrict(District pupDistrict) {
        this.pupDistrict = pupDistrict;
    }

    public District getDDistrict() {
        return dDistrict;
    }

    public void setDDistrict(District dDistrict) {
        this.dDistrict = dDistrict;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Ward getPupWard() {
        return pupWard;
    }

    public void setPupWard(Ward pupWard) {
        this.pupWard = pupWard;
    }

    public Ward getDWard() {
        return dWard;
    }

    public void setDWard(Ward dWard) {
        this.dWard = dWard;
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
