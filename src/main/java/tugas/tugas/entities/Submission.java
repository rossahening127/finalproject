/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RossaHening
 */
@Entity
@Table(name = "submission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s")
    , @NamedQuery(name = "Submission.findById", query = "SELECT s FROM Submission s WHERE s.id = :id")
    , @NamedQuery(name = "Submission.findByDateOfSubmission", query = "SELECT s FROM Submission s WHERE s.dateOfSubmission = :dateOfSubmission")
    , @NamedQuery(name = "Submission.findByTypeOfAsset", query = "SELECT s FROM Submission s WHERE s.typeOfAsset = :typeOfAsset")
    , @NamedQuery(name = "Submission.findByName", query = "SELECT s FROM Submission s WHERE s.name = :name")
    , @NamedQuery(name = "Submission.findByStatus", query = "SELECT s FROM Submission s WHERE s.status = :status")
    , @NamedQuery(name = "Submission.findByFileOfSubmission", query = "SELECT s FROM Submission s WHERE s.fileOfSubmission = :fileOfSubmission")
    , @NamedQuery(name = "Submission.findByIsDelete", query = "SELECT s FROM Submission s WHERE s.isDelete = :isDelete")})
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "dateOfSubmission")
    @Temporal(TemporalType.DATE)
    private Date dateOfSubmission;
    @Size(max = 50)
    @Column(name = "typeOfAsset")
    private String typeOfAsset;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fileOfSubmission")
    private String fileOfSubmission;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "submissionId", fetch = FetchType.LAZY)
    private List<SubmissionOfAsset> submissionOfAssetList;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeId;

    public Submission() {
    }

    public Submission(String id) {
        this.id = id;
    }

    public Submission(String id, String name, String status, String fileOfSubmission, String isDelete) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.fileOfSubmission = fileOfSubmission;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public String getTypeOfAsset() {
        return typeOfAsset;
    }

    public void setTypeOfAsset(String typeOfAsset) {
        this.typeOfAsset = typeOfAsset;
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

    public String getFileOfSubmission() {
        return fileOfSubmission;
    }

    public void setFileOfSubmission(String fileOfSubmission) {
        this.fileOfSubmission = fileOfSubmission;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<SubmissionOfAsset> getSubmissionOfAssetList() {
        return submissionOfAssetList;
    }

    public void setSubmissionOfAssetList(List<SubmissionOfAsset> submissionOfAssetList) {
        this.submissionOfAssetList = submissionOfAssetList;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.Submission[ id=" + id + " ]";
    }
    
}
