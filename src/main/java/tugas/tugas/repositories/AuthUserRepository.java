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
import tugas.tugas.entities.Address;
import tugas.tugas.entities.AuthUser;

/**
 *
 * @author RossaHening
 */
@Repository
public interface AuthUserRepository extends CrudRepository<AuthUser, Integer>{
    @Query(
    value="Select * from auth_user a where a.isdelete =\'false\'",
            nativeQuery = true )
    List<Address> getAll();
}
