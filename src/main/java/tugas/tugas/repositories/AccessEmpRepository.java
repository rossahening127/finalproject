/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tugas.tugas.entities.AccessEmp;
import tugas.tugas.entities.District;

/**
 *
 * @author RossaHening
 */
public interface AccessEmpRepository extends CrudRepository<AccessEmp, String>{
    @Query(
            value = "Select * from access_emp a where a.isdelete =\'false\'",
            nativeQuery = true)
     List<AccessEmp> getAll();
    
}
