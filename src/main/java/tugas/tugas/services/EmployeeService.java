/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.Employee;
import tugas.tugas.entities.Subdistrict;
import tugas.tugas.repositories.EmployeeRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class EmployeeService {
      
    @Autowired
    private EmployeeRepository er;
    
    public Iterable<Employee> findAllEmp() { //fungsi findAllActor ntar bisa dipanggil
        return er.findAll();
    }

    public List<Employee> getAll() {
        return er.getAll();
    }
    
    
    
    
    
}
