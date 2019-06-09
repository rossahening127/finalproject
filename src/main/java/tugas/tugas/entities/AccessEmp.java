/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author RossaHening
 */
@Entity
@Table(name = "access_emp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessEmp.findAll", query = "SELECT a FROM AccessEmp a")
    , @NamedQuery(name = "AccessEmp.findById", query = "SELECT a FROM AccessEmp a WHERE a.id = :id")
    , @NamedQuery(name = "AccessEmp.findByName", query = "SELECT a FROM AccessEmp a WHERE a.name = :name")
    , @NamedQuery(name = "AccessEmp.findByIsdelete", query = "SELECT a FROM AccessEmp a WHERE a.isdelete = :isdelete")})
public class AccessEmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isdelete")
    private String isdelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessid", fetch = FetchType.LAZY)
    private List<AccessOfEmp> accessOfEmpList;

    public AccessEmp() {
    }

    public AccessEmp(String id) {
        this.id = id;
    }

    public AccessEmp(String id, String isdelete) {
        this.id = id;
        this.isdelete = isdelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @XmlTransient
    public List<AccessOfEmp> getAccessOfEmpList() {
        return accessOfEmpList;
    }

    public void setAccessOfEmpList(List<AccessOfEmp> accessOfEmpList) {
        this.accessOfEmpList = accessOfEmpList;
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
        if (!(object instanceof AccessEmp)) {
            return false;
        }
        AccessEmp other = (AccessEmp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.AccessEmp[ id=" + id + " ]";
    }
    
}
