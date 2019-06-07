/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.Job;
import tugas.tugas.entities.Province;
import tugas.tugas.repositories.JobRepository;
import tugas.tugas.repositories.ProvinceRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class ProvinceService {
      
    @Autowired
    private ProvinceRepository pr;
    
     
    public Iterable<Province> findAllPro() { //fungsi findAllActor ntar bisa dipanggil
        return pr.findAll();
    }

    public List<Province> getAll() {
        return pr.getAll();
    }
    
    
    
}