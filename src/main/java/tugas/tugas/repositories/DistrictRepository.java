/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tugas.tugas.entities.District;

/**
 *
 * @author RossaHening
 */
public interface DistrictRepository extends CrudRepository<District, String> {

    @Query(
            value = "Select * from district d where d.isdelete =\'false\'",
            nativeQuery = true)
//    @Query(
//            value = "SELECT d.id, d.name, d.provinceid, d.isdelete\n"
//            + "FROM district d\n"
//            + "JOIN province p ON d.provinceid=p.id\n"
//            + "WHERE d.isdelete='false'",
//            nativeQuery = true)
    List<District> getAll();
    //nampilin output mana ca, output apa._.
    
}
