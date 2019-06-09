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
import tugas.tugas.entities.Employee;
import tugas.tugas.entities.Subdistrict;
import tugas.tugas.repositories.EmployeeRepository;
import tugas.tugas.services.EmployeeService;

/**
 *
 * @author RossaHening
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeService employeeService;
    
     @GetMapping("/employee")
    public String subdistrict(Model model) {
        model.addAttribute("dataEmp", employeeRepository.getAll());
        return "employee";
    }

    @PostMapping("/employee/addData")
    public String addData(Employee employee) {
        employee.setIsdelete("false");
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @PostMapping("/employee/update/{id}")
    public String updateData(@PathVariable("id") String id, Employee employee) {
        employee.setIsdelete("false");
        employeeRepository.save(employee);

        return "redirect:/employee";
    }

    @GetMapping("/employee/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Employee employee) {
        employee.setIsdelete("true");
        employeeRepository.save(employee);
        return "redirect:/employee";
    }
}
