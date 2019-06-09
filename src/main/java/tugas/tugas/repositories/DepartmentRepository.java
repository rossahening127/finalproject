/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tugas.tugas.entities.Address;
import tugas.tugas.entities.Department;

/**
 *
 * @author RossaHening
 */
public interface DepartmentRepository extends CrudRepository<Department, String> {

//    @Query(
//            value = "select d.id, d.name, d.manager_id, d.isdelete\n"
//            + "from department d\n"
//            + "join employee e on d.manager_id=e.id\n"
//            + "where d.isdelete = 'false'",
//            nativeQuery = true)
//    List<Department> findDept();
//    
    @Query(
    value="Select * from department d where d.isdelete =\'false\'",
            nativeQuery = true )
    List<Department> getAll();

    //
}
