/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.Address;
import tugas.tugas.repositories.AddressRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class AddressService {
      
    @Autowired
    private AddressRepository ar;
    
    
    public Iterable<Address> findAllAdd() { //fungsi findAllActor ntar bisa dipanggil
        return ar.findAll();
    }

    public List<Address> getAll() {
        return ar.getAll();
    }
    
}
