/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RossaHening
 */
@Entity
@Table(name = "confirmation_token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfirmationToken.findAll", query = "SELECT c FROM ConfirmationToken c")
    , @NamedQuery(name = "ConfirmationToken.findByTokenId", query = "SELECT c FROM ConfirmationToken c WHERE c.tokenId = :tokenId")
    , @NamedQuery(name = "ConfirmationToken.findByConfirmationToken", query = "SELECT c FROM ConfirmationToken c WHERE c.confirmationToken = :confirmationToken")
    , @NamedQuery(name = "ConfirmationToken.findByCreatedDate", query = "SELECT c FROM ConfirmationToken c WHERE c.createdDate = :createdDate")})
public class ConfirmationToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "token_id")
    private Integer tokenId;
    @Size(max = 255)
    @Column(name = "confirmation_token")
    private String confirmationToken;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "employeeid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeid;

    public ConfirmationToken() {
    }

    public ConfirmationToken(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public ConfirmationToken(Employee employeeid) {
        this.employeeid = employeeid;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

       
    
    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenId != null ? tokenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfirmationToken)) {
            return false;
        }
        ConfirmationToken other = (ConfirmationToken) object;
        if ((this.tokenId == null && other.tokenId != null) || (this.tokenId != null && !this.tokenId.equals(other.tokenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.ConfirmationToken[ tokenId=" + tokenId + " ]";
    }

}
