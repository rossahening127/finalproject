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
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.JobRepository;
import tugas.tugas.repositories.ReligionRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class JobService {
      
    @Autowired
    private JobRepository js;
    
    public Iterable<Job> findAllJob() { //fungsi findAllActor ntar bisa dipanggil
        return js.findAll();
    }

    public List<Job> getAll() {
        return js.getAll();
    }
    
    
}