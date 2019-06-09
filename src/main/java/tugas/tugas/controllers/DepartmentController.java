/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tugas.tugas.entities.Department;
import tugas.tugas.repositories.DepartmentRepository;
import tugas.tugas.services.DepartmentService;

/**
 *
 * @author RossaHening
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private DepartmentService departmentService;
    
//    @GetMapping("/department")
//    public String district(Model model) {
//        model.addAttribute("dataDept", departmentService.findAllDept());
//        return "department";
//    }
    @GetMapping("/department")
    public String district(Model model) {
        model.addAttribute("dataDept", departmentRepository.getAll());
        return "department";
    }
    
   
    @PostMapping("/department/addData")
    public String addData(Department department) {
        department.setIsdelete("false");
        departmentRepository.save(department);
        return "redirect:/department";
    }

    @PostMapping("/department/update/{id}")
    public String updateData(@PathVariable("id") String id, Department department) {
        department.setIsdelete("false");
        departmentRepository.save(department);
        return "redirect:/department";
    }

    @GetMapping("/department/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Department department) {
        department.setIsdelete("true");
        departmentRepository.save(department);
        return "redirect:/department";
    }

}
