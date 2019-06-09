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
import tugas.tugas.entities.AccessEmp;
import tugas.tugas.entities.District;
import tugas.tugas.repositories.AccessEmpRepository;
import tugas.tugas.services.AccessEmpService;

/**
 *
 * @author RossaHening
 */
@Controller
public class AccessEmpController {
    @Autowired
    private AccessEmpRepository accessEmpRepository;
    
    @Autowired
    private AccessEmpService accessEmpService;
    
    @GetMapping("/accessemp")
    public String accessemp(Model model) {
        model.addAttribute("dataAe", accessEmpRepository.getAll());
//        model.addAttribute("dataPro", provinceRepository.findAll());
        return "accessemp";
    }
    
   
    @PostMapping("/accessemp/addData")
    public String addData(AccessEmp accessEmp) {
        accessEmp.setIsdelete("false");
        accessEmpRepository.save(accessEmp);
        return "redirect:/accessemp";
    }

    @PostMapping("/accessemp/update/{id}")
    public String updateData(@PathVariable("id") String id, AccessEmp accessEmp) {
        accessEmp.setIsdelete("false");
        accessEmpRepository.save(accessEmp);
        return "redirect:/accessemp";
    }

    @GetMapping("/accessemp/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, AccessEmp accessEmp) {
        accessEmp.setIsdelete("true");
        accessEmpRepository.save(accessEmp);
        return "redirect:/accessemp";
    }
}
