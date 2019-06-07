/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.District;

import tugas.tugas.repositories.DistrictRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class DistrictService {
      
    @Autowired
    private DistrictRepository dr;
    
    public Iterable<District> findAllDis() { //fungsi findAllActor ntar bisa dipanggil
        return dr.findAll();
    }

    public List<District> getAll() {
        return dr.getAll();
    }
    
    
    
}