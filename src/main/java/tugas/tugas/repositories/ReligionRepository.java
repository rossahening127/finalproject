/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tugas.tugas.entities.Religion;

/**
 *
 * @author RossaHening
 */
public interface ReligionRepository extends CrudRepository<Religion, String> {
    @Query(
    value="Select * from religion r where r.isdelete =\'false\'",
            nativeQuery = true )
    List<Religion> getAll();
    
//    @Modifying
//    @Query(
//    value= "UPDATE `religion` SET `isdelete` = 'true' WHERE `religion`.`id` = '?'", 
//            nativeQuery = true)
//    
//    
//    public String softDelete(String id);
    
            
    //bikin query fungsi soft delete, mengganti value isdelete dari false menjadi true"
    //int updateIsDelete(@Param ("isDelete") enum isDelete);
           // update RssFeedEntry feedEntry set religion.isDelete =:isDelete where feedEntry.id =:entryId
    //String updateIsDelete(@Param("id") String id, @Param("isDelete") String isDelete);
    
//    public String softDelete(String id);
    
//    public void softDelete(String id) {
//	roleRepository.softDelete(id);
//    }
}