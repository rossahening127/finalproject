/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.AccessEmp;
import tugas.tugas.entities.Address;
import tugas.tugas.repositories.AccessEmpRepository;
import tugas.tugas.repositories.AddressRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class AccessEmpService {
    
    @Autowired
    private AccessEmpRepository aer ;
      
    
    public Iterable<AccessEmp> findAllAer() { //fungsi findAllActor ntar bisa dipanggil
        return aer.findAll();
    }

    public List<AccessEmp> getAll() {
        return aer.getAll();
    }
}
