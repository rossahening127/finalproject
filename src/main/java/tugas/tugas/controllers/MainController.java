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
public class MainController {
    @Autowired
    private ReligionRepository religionRepository;
    
     @Autowired
    private ReligionService religionService;
    
//    @GetMapping("/")
//    public String index(Model model) {
//     
//        return "index";                
//    } 
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
     
//    @GetMapping("/")
//    public String index(Model model) {
//     
//        model.addAttribute("dataReli", religionService.getAll());
//        return "index";                
//    }
//    
    @GetMapping("/religion")
    public String religion(Model model) {
     
        model.addAttribute("dataReli", religionRepository.getAll());
        return "religion";   //index              
    }
    
    
//     @GetMapping("/delete/{id}")
//    public String deleteData(@PathVariable("id") Short id, Model model) {
////        Short ids = id;
////        int idActor = ids.intValue();
//        Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        actorRepository.delete(actor);
//        model.addAttribute("dataActor", actorRepository.findAll());
//        return "index";
//    }

//    @PostMapping("/update/{id}")
//    public String upadateData(@PathVariable("id") Short id, @Valid Actor actor, Model model) {
//        actorRepository.save(actor);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
//    }

//    @RequestMapping("/update/{id}")
//    public String upadateData(@PathVariable("id") Short id, @Valid Actor actor, Model model) {
//        actorRepository.save(actor);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
//    }
    
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") Short id, Model model) {
//// int ids = id;
////        Short ids = id;
////        int idActor = ids.intValue();
//        Actor actor = actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id" + id));
//        model.addAttribute("actor", actor);
//        return "updateActor";
//    }

    @PostMapping("/addData")
    public String addData(@Valid Religion religion) {
        religionRepository.save(religion);
//        model.addAttribute("dataReli", religionService.findAllReligion());
        return "redirect:/religion";
    }
    
    @PostMapping("/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Religion religion, Model model) {
        religionRepository.save(religion);
       
        return "redirect:/religion";
    }
    
//    @GetMapping("/delete")
//    public String softDelete(@Valid Religion religion){
//        religionRepository.updateIsDelete("", "");
//        return "religion";
//    }
    @GetMapping("/delete")
    public String softDelete(@PathVariable("id") String id){
        religionRepository.softDelete(id);
        return "religion";
    }
            
    
    @GetMapping("/*")
    public String Error(){
        return "error";
    }
}