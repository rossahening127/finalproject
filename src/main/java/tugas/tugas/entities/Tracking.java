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
 * @author RossaHening
 */
@Entity
@Table(name = "tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracking.findAll", query = "SELECT t FROM Tracking t")
    , @NamedQuery(name = "Tracking.findById", query = "SELECT t FROM Tracking t WHERE t.id = :id")
    , @NamedQuery(name = "Tracking.findByName", query = "SELECT t FROM Tracking t WHERE t.name = :name")
    , @NamedQuery(name = "Tracking.findByStatus", query = "SELECT t FROM Tracking t WHERE t.status = :status")
    , @NamedQuery(name = "Tracking.findByDateOfPocess", query = "SELECT t FROM Tracking t WHERE t.dateOfPocess = :dateOfPocess")
    , @NamedQuery(name = "Tracking.findByIsDelete", query = "SELECT t FROM Tracking t WHERE t.isDelete = :isDelete")
    , @NamedQuery(name = "Tracking.findBySubmissionId", query = "SELECT t FROM Tracking t WHERE t.submissionId = :submissionId")})
public class Tracking implements Serializable {

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
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Column(name = "dateOfPocess")
    @Temporal(TemporalType.DATE)
    private Date dateOfPocess;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isDelete")
    private String isDelete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "submission_id")
    private String submissionId;

    public Tracking() {
    }

    public Tracking(String id) {
        this.id = id;
    }

    public Tracking(String id, String isDelete, String submissionId) {
        this.id = id;
        this.isDelete = isDelete;
        this.submissionId = submissionId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfPocess() {
        return dateOfPocess;
    }

    public void setDateOfPocess(Date dateOfPocess) {
        this.dateOfPocess = dateOfPocess;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
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
        if (!(object instanceof Tracking)) {
            return false;
        }
        Tracking other = (Tracking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.Tracking[ id=" + id + " ]";
    }
    
}
