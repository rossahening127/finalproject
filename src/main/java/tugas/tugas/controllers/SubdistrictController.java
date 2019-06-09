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

import tugas.tugas.entities.Subdistrict;

import tugas.tugas.repositories.SubdistrictRepository;

import tugas.tugas.services.SubdistrictService;

/**
 *
 * @author RossaHening
 */
@Controller
public class SubdistrictController {

    @Autowired
    private SubdistrictRepository subdistrictRepository;

    @Autowired
    private SubdistrictService subdistrictService;

    @GetMapping("/subdistrict")
    public String subdistrict(Model model) {
        model.addAttribute("dataSub", subdistrictRepository.getAll());
        return "subdistrict";
    }

    @PostMapping("/subdistrict/addData")
    public String addData(Subdistrict subdistrict) {
        subdistrict.setIsdelete("false");
        subdistrictRepository.save(subdistrict);
        return "redirect:/subdistrict";
    }

    @PostMapping("/subdistrict/update/{id}")
    public String updateData(@PathVariable("id") String id, Subdistrict subdistrict) {
        subdistrict.setIsdelete("false");
        subdistrictRepository.save(subdistrict);

        return "redirect:/subdistrict";
    }

    @GetMapping("/subdistrict/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Subdistrict subdistrict) {
        subdistrict.setIsdelete("true");
        subdistrictRepository.save(subdistrict);
        return "redirect:/subdistrict";
    }

}
