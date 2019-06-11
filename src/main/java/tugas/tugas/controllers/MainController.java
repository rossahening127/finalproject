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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tugas.tugas.entities.Religion;
import tugas.tugas.repositories.ReligionRepository;
import tugas.tugas.services.ReligionService;

/**
 *
 * @author RossaHening
 */
@Controller
public class MainController {
    
   
    @RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "index";
    }
    
        @GetMapping("/error")
    public String Error() {
        return "error";
    }
    
//     @GetMapping("/user")
//    public String user() {
//        return "";
//    }
    
    
    

}
