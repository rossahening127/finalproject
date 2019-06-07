/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tugas.tugas.entities.Job;
import tugas.tugas.entities.Province;


/**
 *
 * @author RossaHening
 */
public interface ProvinceRepository extends CrudRepository<Province, String> {
    @Query(
    value="Select * from province p where p.isdelete =\'false\'",
            nativeQuery = true )
    List<Province> getAll();
}