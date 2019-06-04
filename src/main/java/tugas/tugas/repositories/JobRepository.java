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
import tugas.tugas.entities.Religion;


/**
 *
 * @author RossaHening
 */
public interface JobRepository extends CrudRepository<Job, String> {
    @Query(
    value="Select * from job r where r.isdelete =\'false\'",
            nativeQuery = true )
    List<Religion> getAll();
}
