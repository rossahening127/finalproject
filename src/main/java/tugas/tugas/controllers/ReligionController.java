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
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.ReligionRepository;
import tugas.tugas.services.ReligionService;

/**
 *
 * @author RossaHening
 */
@Controller
public class ReligionController {

    @Autowired
    private ReligionRepository religionRepository;

    @Autowired
    private ReligionService religionService;

    
    @GetMapping("/religion")
    public String religion(Model model) {
        model.addAttribute("dataReli", religionRepository.getAll());
        return "religion";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        return "dashboard";
    }

    @PostMapping("/religion/addData")
    public String addData(Religion religion) {
        religion.setIsdelete("false");
        religionRepository.save(religion);

        return "redirect:/religion";
    }

    @PostMapping("/religion/update/{id}")
    public String updateData(@PathVariable("id") String id, @Valid Religion religion) {
        religion.setIsdelete("false");
        religionRepository.save(religion);

        return "redirect:/religion";
    }

    @GetMapping("/religion/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Religion religion) {
        religion.setIsdelete("true");

        religionRepository.save(religion);
        return "redirect:/religion";
    }

}
