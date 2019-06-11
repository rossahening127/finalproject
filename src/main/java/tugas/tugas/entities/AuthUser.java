/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author RossaHening
 */
@Entity
@Table(name = "auth_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUser.findAll", query = "SELECT a FROM AuthUser a")
    , @NamedQuery(name = "AuthUser.findById", query = "SELECT a FROM AuthUser a WHERE a.id = :id")
    , @NamedQuery(name = "AuthUser.findByIsdelete", query = "SELECT a FROM AuthUser a WHERE a.isdelete = :isdelete")
    , @NamedQuery(name = "AuthUser.findByLastupdate", query = "SELECT a FROM AuthUser a WHERE a.lastupdate = :lastupdate")})
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isdelete")
    private String isdelete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastupdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;
    @JoinColumn(name = "employeeid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeid;
    @JoinColumn(name = "roleid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role roleid;

    public AuthUser() {
    }

    public AuthUser(Integer id) {
        this.id = id;
    }

    public AuthUser(Integer id, String isdelete, Date lastupdate) {
        this.id = id;
        this.isdelete = isdelete;
        this.lastupdate = lastupdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
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
        if (!(object instanceof AuthUser)) {
            return false;
        }
        AuthUser other = (AuthUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.AuthUser[ id=" + id + " ]";
    }
    
}
