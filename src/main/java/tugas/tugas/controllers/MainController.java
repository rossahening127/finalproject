/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.tugas.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MainController {
    
   
    @GetMapping("/")
    public String index() {
        return "index";
    }
    

//    @GetMapping("/*")
//    public String Error() {
//        return "error";
//    }
    
    
    
    

}
