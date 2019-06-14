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
@Table(name = "transaction_of_asset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionOfAsset.findAll", query = "SELECT t FROM TransactionOfAsset t")
    , @NamedQuery(name = "TransactionOfAsset.findById", query = "SELECT t FROM TransactionOfAsset t WHERE t.id = :id")
    , @NamedQuery(name = "TransactionOfAsset.findByQuantity", query = "SELECT t FROM TransactionOfAsset t WHERE t.quantity = :quantity")
    , @NamedQuery(name = "TransactionOfAsset.findBySubTotal", query = "SELECT t FROM TransactionOfAsset t WHERE t.subTotal = :subTotal")
    , @NamedQuery(name = "TransactionOfAsset.findByUnitPrice", query = "SELECT t FROM TransactionOfAsset t WHERE t.unitPrice = :unitPrice")
    , @NamedQuery(name = "TransactionOfAsset.findByIsDelete", query = "SELECT t FROM TransactionOfAsset t WHERE t.isDelete = :isDelete")})
public class TransactionOfAsset implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "subTotal")
    private Integer subTotal;
    @Column(name = "unitPrice")
    private Integer unitPrice;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isDelete")
    private String isDelete;
    @JoinColumn(name = "asset", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asset asset;
    @JoinColumn(name = "transaction", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Transaction transaction;

    public TransactionOfAsset() {
    }

    public TransactionOfAsset(String id) {
        this.id = id;
    }

    public TransactionOfAsset(String id, String isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
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

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
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
        if (!(object instanceof TransactionOfAsset)) {
            return false;
        }
        TransactionOfAsset other = (TransactionOfAsset) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.TransactionOfAsset[ id=" + id + " ]";
    }
    
}
