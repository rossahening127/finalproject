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
@Table(name = "submission_of_asset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubmissionOfAsset.findAll", query = "SELECT s FROM SubmissionOfAsset s")
    , @NamedQuery(name = "SubmissionOfAsset.findById", query = "SELECT s FROM SubmissionOfAsset s WHERE s.id = :id")
    , @NamedQuery(name = "SubmissionOfAsset.findByIsDelete", query = "SELECT s FROM SubmissionOfAsset s WHERE s.isDelete = :isDelete")})
public class SubmissionOfAsset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isDelete")
    private String isDelete;
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asset assetId;
    @JoinColumn(name = "submission_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Submission submissionId;

    public SubmissionOfAsset() {
    }

    public SubmissionOfAsset(String id) {
        this.id = id;
    }

    public SubmissionOfAsset(String id, String isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Asset getAssetId() {
        return assetId;
    }

    public void setAssetId(Asset assetId) {
        this.assetId = assetId;
    }

    public Submission getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Submission submissionId) {
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
        if (!(object instanceof SubmissionOfAsset)) {
            return false;
        }
        SubmissionOfAsset other = (SubmissionOfAsset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.SubmissionOfAsset[ id=" + id + " ]";
    }
    
}
