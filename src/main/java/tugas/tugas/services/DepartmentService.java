/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.services;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tugas.tugas.entities.Address;
import tugas.tugas.entities.Department;
import tugas.tugas.repositories.DepartmentRepository;

/**
 *
 * @author RossaHening
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository dr;
    
    public Iterable<Department> findAllDept() { //fungsi findAllActor ntar bisa dipanggil
        return dr.findAll();
    }

//    public List<Department> findAllDept() {
//        return dr.findDept();
//    }
}
