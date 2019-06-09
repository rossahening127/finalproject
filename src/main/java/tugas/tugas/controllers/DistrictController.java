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
import tugas.tugas.entities.District;
import tugas.tugas.repositories.DistrictRepository;
import tugas.tugas.repositories.ProvinceRepository;
import tugas.tugas.services.DistrictService;


/**
 *
 * @author RossaHening
 */
@Controller
public class DistrictController { //cha udah di run belom
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private ProvinceRepository provinceRepository;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/district")
    public String district(Model model) {
        model.addAttribute("dataDis", districtRepository.getAll());
//        model.addAttribute("dataPro", provinceRepository.findAll());
        return "district";
    }
    
   
    @PostMapping("/district/addData")
    public String addData(District district) {
        district.setIsdelete("false");
        districtRepository.save(district);
        return "redirect:/district";
    }

    @PostMapping("/district/update/{id}")
    public String updateData(@PathVariable("id") String id, District district) {
        district.setIsdelete("false");
        districtRepository.save(district);
        return "redirect:/district";
    }

    @GetMapping("/district/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, District district) {
        district.setIsdelete("true");
        districtRepository.save(district);
        return "redirect:/district";
    }

}
