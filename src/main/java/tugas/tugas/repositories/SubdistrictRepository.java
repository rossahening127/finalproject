/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.repositories;

import org.springframework.data.repository.CrudRepository;
import tugas.tugas.entities.Religion;
import tugas.tugas.entities.Subdistrict;

/**
 *
 * @author RossaHening
 */
public interface SubdistrictRepository extends CrudRepository<Subdistrict, String> {
    
}
