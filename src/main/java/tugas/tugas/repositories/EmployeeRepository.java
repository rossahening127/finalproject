/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tugas.tugas.entities.Employee;


/**
 *
 * @author RossaHening
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    @Query(
    value="Select * from employee e where e.isdelete =\'false\'",
            nativeQuery = true )
    List<Employee> getAll();
    
    Employee findByemail(String email);
    
}
