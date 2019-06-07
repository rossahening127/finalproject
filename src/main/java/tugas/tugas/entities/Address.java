/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RossaHening
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByName", query = "SELECT a FROM Address a WHERE a.name = :name")
    , @NamedQuery(name = "Address.findByIsdelete", query = "SELECT a FROM Address a WHERE a.isdelete = :isdelete")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isdelete")
    private String isdelete;
    @JoinColumn(name = "subdistrictid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subdistrict subdistrictid;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String isdelete) {
        this.id = id;
        this.isdelete = isdelete;
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

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public Subdistrict getSubdistrictid() {
        return subdistrictid;
    }

    public void setSubdistrictid(Subdistrict subdistrictid) {
        this.subdistrictid = subdistrictid;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.Address[ id=" + id + " ]";
    }
    
}
