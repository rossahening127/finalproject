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
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id")
    , @NamedQuery(name = "Transaction.findByDateTransaction", query = "SELECT t FROM Transaction t WHERE t.dateTransaction = :dateTransaction")
    , @NamedQuery(name = "Transaction.findByTotalPrice", query = "SELECT t FROM Transaction t WHERE t.totalPrice = :totalPrice")
    , @NamedQuery(name = "Transaction.findByIsDelete", query = "SELECT t FROM Transaction t WHERE t.isDelete = :isDelete")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Column(name = "dateTransaction")
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;
    @Column(name = "totalPrice")
    private Integer totalPrice;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isDelete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction", fetch = FetchType.LAZY)
    private List<TransactionOfAsset> transactionOfAssetList;
    @JoinColumn(name = "supplier", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    public Transaction() {
    }

    public Transaction(String id) {
        this.id = id;
    }

    public Transaction(String id, String isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.Transaction[ id=" + id + " ]";
    }
    
}
