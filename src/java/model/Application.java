/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lion
 */
@Entity
@Table(name = "APPLICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findByName", query = "SELECT a FROM Application a WHERE a.name = :name"),
    @NamedQuery(name = "Application.findByIc", query = "SELECT a FROM Application a WHERE a.ic = :ic"),
    @NamedQuery(name = "Application.findByGender", query = "SELECT a FROM Application a WHERE a.gender = :gender"),
    @NamedQuery(name = "Application.findByAddress", query = "SELECT a FROM Application a WHERE a.address = :address"),
    @NamedQuery(name = "Application.findByContactnum", query = "SELECT a FROM Application a WHERE a.contactnum = :contactnum"),
    @NamedQuery(name = "Application.findByStatus", query = "SELECT a FROM Application a WHERE a.status = :status"),
    @NamedQuery(name = "Application.findByDate", query = "SELECT a FROM Application a WHERE a.date = :date"),
    @NamedQuery(name = "Application.findByDenied", query = "SELECT a FROM Application a WHERE a.status = 'False'"),
    @NamedQuery(name = "Application.findByUnapprove", query = "SELECT a FROM Application a WHERE a.status IS NULL")})
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "IC")
    private String ic;
    @Size(max = 15)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "CONTACTNUM")
    private String contactnum;
    @Column(name = "STATUS")
    private Boolean status;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Application() {
    }

    public Application(String name, String ic, String gender, String address, String contactnum) {
        this.name = name;
        this.ic = ic;
        this.gender = gender;
        this.address = address;
        this.contactnum = contactnum;
        this.status = null;
        this.date = new Date();        
        
    }

    public Application(String ic) {
        this.ic = ic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ic != null ? ic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.ic == null && other.ic != null) || (this.ic != null && !this.ic.equals(other.ic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Application[ ic=" + ic + " ]";
    }
    
}
