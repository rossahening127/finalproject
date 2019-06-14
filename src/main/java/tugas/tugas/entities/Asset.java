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
 * @author RossaHening
 */
@Entity
@Table(name = "asset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asset.findAll", query = "SELECT a FROM Asset a")
    , @NamedQuery(name = "Asset.findById", query = "SELECT a FROM Asset a WHERE a.id = :id")
    , @NamedQuery(name = "Asset.findByName", query = "SELECT a FROM Asset a WHERE a.name = :name")
    , @NamedQuery(name = "Asset.findByTotal", query = "SELECT a FROM Asset a WHERE a.total = :total")
    , @NamedQuery(name = "Asset.findByLocation", query = "SELECT a FROM Asset a WHERE a.location = :location")
    , @NamedQuery(name = "Asset.findByUnitPrice", query = "SELECT a FROM Asset a WHERE a.unitPrice = :unitPrice")
    , @NamedQuery(name = "Asset.findByIsDelete", query = "SELECT a FROM Asset a WHERE a.isDelete = :isDelete")})
public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Column(name = "total")
    private Integer total;
    @Size(max = 50)
    @Column(name = "location")
    private String location;
    @Column(name = "unitPrice")
    private Integer unitPrice;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asset", fetch = FetchType.LAZY)
    private List<TransactionOfAsset> transactionOfAssetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetId", fetch = FetchType.LAZY)
    private List<SubmissionOfAsset> submissionOfAssetList;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category categoryId;

    public Asset() {
    }

    public Asset(String id) {
        this.id = id;
    }

    public Asset(String id, String name, String isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<TransactionOfAsset> getTransactionOfAssetList() {
        return transactionOfAssetList;
    }

    public void setTransactionOfAssetList(List<TransactionOfAsset> transactionOfAssetList) {
        this.transactionOfAssetList = transactionOfAssetList;
    }

    @XmlTransient
    public List<SubmissionOfAsset> getSubmissionOfAssetList() {
        return submissionOfAssetList;
    }

    public void setSubmissionOfAssetList(List<SubmissionOfAsset> submissionOfAssetList) {
        this.submissionOfAssetList = submissionOfAssetList;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.Asset[ id=" + id + " ]";
    }
    
}
