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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByDateofbirth", query = "SELECT e FROM Employee e WHERE e.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Employee.findByHiredate", query = "SELECT e FROM Employee e WHERE e.hiredate = :hiredate")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByIsdelete", query = "SELECT e FROM Employee e WHERE e.isdelete = :isdelete")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Column(name = "hiredate")
    @Temporal(TemporalType.DATE)
    private Date hiredate;
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "isdelete")
    private String isdelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid", fetch = FetchType.LAZY)
    private List<AuthUser> authUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid", fetch = FetchType.LAZY)
    private List<AccessOfEmp> accessOfEmpList;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Department> departmentList;
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Address addressId;
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Job jobId;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee managerId;
    @JoinColumn(name = "religion_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Religion religionId;
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String lastname, String email, String isdelete) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.isdelete = isdelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    @XmlTransient
    public List<AuthUser> getAuthUserList() {
        return authUserList;
    }

    public void setAuthUserList(List<AuthUser> authUserList) {
        this.authUserList = authUserList;
    }

    @XmlTransient
    public List<AccessOfEmp> getAccessOfEmpList() {
        return accessOfEmpList;
    }

    public void setAccessOfEmpList(List<AccessOfEmp> accessOfEmpList) {
        this.accessOfEmpList = accessOfEmpList;
    }

    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public void setManagerId(Employee managerId) {
        this.managerId = managerId;
    }

    public Religion getReligionId() {
        return religionId;
    }

    public void setReligionId(Religion religionId) {
        this.religionId = religionId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.tugas.entities.Employee[ id=" + id + " ]";
    }
    
}
