/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tugas.tugas.entities.Job;
import tugas.tugas.entities.Province;
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.JobRepository;
import tugas.tugas.repositories.ProvinceRepository;
import tugas.tugas.repositories.ReligionRepository;
import tugas.tugas.services.JobService;
import tugas.tugas.services.ReligionService;

/**
 *
 * @author RossaHening
 */
@Controller
public class ProvinceController {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private JobService jobService;

    @GetMapping("/province")
    public String province(Model model) {
        model.addAttribute("dataPro", provinceRepository.getAll());
        return "province";
    }

    
    @PostMapping("/province/addData")
    public String addData(Province province) {
        province.setIsdelete("false");
        provinceRepository.save(province);
        return "redirect:/province";
    }

    @PostMapping("/province/update/{id}")
    public String updateData(@PathVariable("id") String id, Province province) {
        province.setIsdelete("false");
        provinceRepository.save(province);

        return "redirect:/province";
    }

    @GetMapping("/province/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Province province) {
        province.setIsdelete("true");
        provinceRepository.save(province);
        return "redirect:/province";
    }

}
