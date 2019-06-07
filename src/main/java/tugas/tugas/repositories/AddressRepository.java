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



/**
 *
 * @author RossaHening
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {
     @Query(
    value="Select * from address a where a.isdelete =\'false\'",
            nativeQuery = true )
    List<Address> getAll();
}